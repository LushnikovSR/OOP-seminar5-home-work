import java.util.Random;

public class Monk extends BaseWarrior {

    public Monk(String name){
        super(name);
    }

    public void treat(BaseCharacter target){
        if (target.getLiveStatus() == LiveStatuses.live) {
            int points = new Random().nextInt(10, 20);
            target.addHealthPoints(points);
            System.out.println(target.getName() + " get " + points + " points of health");
        } else {
            System.out.println(target.getName() + " is " + target.getLiveStatus());
        }
    }
}
