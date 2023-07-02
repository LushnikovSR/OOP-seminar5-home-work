public class BaseMagician extends BaseShooter {

    int mana;
    int maxMana;
    public BaseMagician(String name) {
        super(name);
        this.mana = 200;
    }
    protected int getMana(){
        return this.mana;
    }

    protected void setMana(int value){
        this.mana = value;
    }

    @Override
    public void attack(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live){
            int points = (int)Math.floor(advantagePower(target) * advantageGrowth(target)
                    * (getDamage() * getShootingAccuracy())) - target.getProtection();
            if (points > 0) {
                setMana(getMana() - 10);
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
    public void step() {

    }

    @Override
    public String getInfo() {
        return null;
    }

    enum Weapons{
        magic_stuff, stick, magic_wand, sword, gloves, rings, fists
    }

    protected void takeWeapon(Weapons weapon){
        switch (weapon) {
            case magic_stuff: setDamage(300);
            case stick: setDamage(100);
            case magic_wand: setDamage(30);
            case sword: setDamage(15);
            case gloves: setDamage(10);
            case rings: setDamage(5);
            case fists: setDamage(1);
        }
    }

//    @Override
//    public void attack(BaseCharacter target){
////        if (target.getLiveStatus() == LiveStatuses.live){
////            int points = (int)Math.floor(advantagePower(target) * advantageGrowth(target)
////                    * (getDamage() * getShootingAccuracy())) - target.getProtection();
////            if (points > 0) {
////                setMana(getMana() - 10);
////                target.subtractHealthPoints(points);
////                System.out.println(target.getName() + " less " + points + " points of health ");
////            }
////            if (target.getHealth() <= 0) {
////                target.setLiveStatus(LiveStatuses.dead);
////                target.setHealth(0);
////                System.out.println(target.getClass() + " " + target.getName() + " is " + target.getLiveStatus());
////                target = null;
////            }
////            experienceGain();
////            newLevel();
////        }
//    }

    @Override
    protected void upLevel(){
        this.maxMana = this.maxMana*2;
        this.mana = this.maxMana;
    }
}
