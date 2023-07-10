package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseShooter extends BaseWarrior {
    private float shootingAccuracy;
    private int arrows;

    public BaseShooter(String name, int x, int y){
        super(name, x, y);
        this.shootingAccuracy = 0.3f;
        this.arrows = new Random().nextInt(10, 100);
        takeWeapon(Weapons.crossbow);
    }

    protected float getShootingAccuracy(){
        return this.shootingAccuracy;
    }

    private void setShootingAccuracy(float value){
        this.shootingAccuracy = value;
    }
    protected int getArrows(){ return this.arrows;}

    protected void setArrows(int value){
        this.arrows = value;
    }

    @Override
    public void attack(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live){
            int points = (int)Math.floor(advantagePower(target) * advantageGrowth(target)
                    * (getDamage() * getShootingAccuracy()) * advantageAccuracy(target)) - target.getProtection();
            if (points > 0) {
                target.subtractHealthPoints(points);
                System.out.print(this.getName() + " shoot and ");
                System.out.println(target.getName() + " loses " + points + " points of health" + " less " + target.getHealth() + " HP ");
            }
            if (target.getHealth() <= 0) {
                target.setLiveStatus(LiveStatuses.dead);
                target.setHealth(0);
                System.out.println(target.getClass() + " " + target.getName() + " is " + target.getLiveStatus());
                target = null;
            }
            experienceGain();
            newLevel();
        }
    }

    protected float advantageAccuracy (BaseCharacter target){
        switch ((int) Math.floor(nearestEnemy(target))){
            case 1: return 1.5f;
            case 2: return 1.4f;
            case 3: return 1.3f;
            case 4: return 1.2f;
            case 5: return 1.1f;
            case 6: return 1.0f;
            case 7: return 0.9f;
            case 8: return 0.8f;
            case 9: return 0.7f;
            default: return 0.6f;
        }
    }

    @Override
    protected void upLevel(){
        if (shootingAccuracy <= 1){
            setShootingAccuracy(this.shootingAccuracy + 0.1f);
        }
    }

    protected void takeWeapon(Weapons weapon){
        switch (weapon) {
            case stone:
                setDamage(4);
                break;
            case bow:
                setDamage(7);
                break;
            case crossbow:
                setDamage(15);
                break;
            case gun:
                setDamage(30);
                break;
            case rifle:
                setDamage(50);
                break;
            case zeus_lightning:
                setDamage(600);
                break;
        }
    }
    enum Weapons{
        stone, bow, crossbow, gun, rifle, zeus_lightning
    }

    protected void findPeasant(ArrayList<BaseCharacter> myTeam){
        for (int i = 0; i < myTeam.size(); i++) {
            if (myTeam.get(i).getClass() == Peasant.class){
                break;
            } else if (i == myTeam.size() - 1){
                this.setArrows(this.getArrows() - 1);
            }
        }
    }

}
