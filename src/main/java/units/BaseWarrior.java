package units;

public abstract class BaseWarrior extends BaseCharacter{
    private float impactAccuracy;
    private int damage;
    public BaseWarrior(String name, int x, int y){
        super(name, x, y);
        this.impactAccuracy = 0.3f;
        this.damage = 40;
    }

    protected int getDamage(){
        return this.damage;
    }

    protected void setDamage(int weaponDamage){
        this.damage = weaponDamage;
    }

    protected float getImpactAccuracy(){
        return this.impactAccuracy;
    }

    private void setImpactAccuracy(float value){
        this.impactAccuracy = value;
    }

    public void attack(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live){
            int points = (int)Math.floor(advantagePower(target) * advantageGrowth(target)
                    * (getDamage() * getImpactAccuracy())) - target.getProtection();
            if (points > 0) {
                target.subtractHealthPoints(points);
                System.out.print(this.getName() + " fight and ");
                System.out.println(target.getName() + " loses " + points + " points of health ");
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

    protected float advantageGrowth (BaseCharacter target){
        float difference = (getHeight() - target.getHeight());
        if (difference > 0 & difference <= 10) { return 1.1f; }
        else if (difference > 10 & difference <= 20) { return 1.2f; }
        else if (difference > 20 & difference <= 30) { return 1.3f; }
        else if (difference > 30 & difference <= 40) { return 1.4f; }
        else if (difference > 40 & difference <= 50) { return 1.5f; }
        else if (difference > 50 & difference <= 60) { return 1.6f; }
        else if (difference > 60 & difference <= 70) { return 1.7f; }
        else return 1.0f;
    }

    protected float advantagePower (BaseCharacter target){
        switch (getPower() - target.getPower()){
            case 1: return 1.1f;
            case 2: return 1.2f;
            case 3: return 1.3f;
            case 4: return 1.4f;
            case 5: return 1.5f;
            case 6: return 1.6f;
            case 7: return 1.7f;
            case 8: return 1.8f;
            case 9: return 1.9f;
            default: return 1.0f;
        }
    }

    @Override
    protected void upLevel(){
        setImpactAccuracy(this.impactAccuracy + 0.1f);
    }

    protected void takeWeapon(Weapons weapon){
        switch (weapon) {
            case fists:
                setDamage(4);
                break;
            case stick:
                setDamage(7);
                break;
            case knife:
                setDamage(15);
                break;
            case cudgel:
                setDamage(30);
                break;
            case sword:
                setDamage(50);
                break;
            case excalibur:
                setDamage(200);
                break;
        }
    }
    enum Weapons{
        fists, stick, knife, cudgel, sword, excalibur
    }

}
