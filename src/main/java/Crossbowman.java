public class Crossbowman extends BaseShooter {


    public Crossbowman(String name){
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
