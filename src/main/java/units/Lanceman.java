package units;

import java.util.ArrayList;

public class Lanceman extends BaseWarrior {
    public Lanceman(String name, int x, int y){
        super(name, x, y);
        super.setInitiative(3);
        super.takeWeapon(Weapons.spear);
    }

    @Override
    public void step(ArrayList<BaseCharacter> enemyTeam, ArrayList<BaseCharacter> myTeam) {
        super.step(enemyTeam, myTeam);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
