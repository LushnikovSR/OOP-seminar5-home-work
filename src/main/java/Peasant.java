public class Peasant extends BaseWarrior {

    public Peasant(String name){
        super(name);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf((this.getClass())).replace("class ", "");
    }
}
