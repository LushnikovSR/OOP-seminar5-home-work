public class Developer extends BaseCharacter {
    public Developer(String name){
        super(name);
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
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf((this.getClass())).replace("class ", "");
    }
}
