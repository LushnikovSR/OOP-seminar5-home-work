package units;

import units.BaseCharacter;

public class Area {
    public int x;
    public int y;
    public Area(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x:" + x + " y: " + y;
    }

    public double nearestEnemy(BaseCharacter hero){
        return Math.sqrt(Math.pow(this.x - hero.x, 2) + Math.pow(this.y - hero.y, 2));
    }
}
