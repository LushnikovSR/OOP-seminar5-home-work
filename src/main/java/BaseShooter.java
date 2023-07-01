public abstract class BaseShooter extends BaseWarrior {
    private float shootingAccuracy;

    public BaseShooter(String name){
        super(name);
        this.shootingAccuracy = 0.3f;
    }

    protected float getShootingAccuracy(){
        return this.shootingAccuracy;
    }

    private void setShootingAccuracy(float value){
        this.shootingAccuracy = value;
    }

    @Override
    public void attack(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live){
            int points = (int)Math.floor(advantagePower(target) * advantageGrowth(target)
                    * (getDamage() * getShootingAccuracy())) - target.getProtection();
            if (points > 0) {
                target.subtractHealthPoints(points);
                System.out.println(target.getName() + " less " + points + " points of health ");
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

    @Override
    protected void upLevel(){
        if (shootingAccuracy <= 1){
            setShootingAccuracy(this.shootingAccuracy + 0.1f);
        }
    }

}
