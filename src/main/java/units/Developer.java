package units;

import java.util.ArrayList;

public class Developer extends BaseCharacter {
    public Developer(String name, int x, int y){
        super(name, x, y);
        setInitiative(7);
    }
    protected void changePower(BaseCharacter target, int value){
        if ((value >= 0) & (value <= 10)){
            target.setPower(value);
        }
    }

    protected void changeLiveStatus(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live){
            target.setHealth(0);
            target.setLiveStatus(LiveStatuses.dead);
            target = null;
        }
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemyTeam, ArrayList<BaseCharacter> myTeam) {
        BaseCharacter foe = nearestTargetAttack(enemyTeam);
        foe.setHealth(0);
        foe.setLiveStatus(LiveStatuses.dead);
        System.out.print(this.getName() + " click and ");
        System.out.println(foe.getName() + " is " + foe.getLiveStatus());
    }

    @Override
    public String getInfo() {
        return String.valueOf((this.getClass())).replaceAll("^[\\w+]+\\s[\\w+]+\\.", "") + " "
                + this.getName() + " " + "hp: " + this.getHealth();
    }
}
