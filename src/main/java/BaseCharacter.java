import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public abstract class BaseCharacter {
    private final String FORMAT = "#0.00";

    private String name;
    private String sex;
    private LiveStatuses liveStatus;
    private int level;
    private int experience;
    private int health;
    private int maxHealth;
    private LocalDate birthday;
    private float height;
    private int power;
    private int speed;
    private int protection;

    private BaseCharacter(){
        this.level = 1;
        this.experience = 0;
        this.liveStatus = LiveStatuses.live;
        this.birthday = LocalDate.now();
        this.health = new Random().nextInt(50, 100);
        this.maxHealth = 200;
        this.height = Float.parseFloat((new DecimalFormat(FORMAT)
                .format(new Random().nextFloat(150, 220))).replace(',', '.'));
        this.power = new Random().nextInt(10);
        this.speed = new Random().nextInt(10);
        this.protection = 0;
    }

    public BaseCharacter(String name, String sex){
        this();
        this.name = name;
        this.sex = sex;
    }

    public BaseCharacter(String name){
        this(name, "male");
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        if (!name.matches("[a-zA-Z][0-9]")){
            this.name = name;
        } else {
            this.name = "Snowman";
        }
    }

    protected LiveStatuses getLiveStatus(){
        return this.liveStatus;
    }

    protected void setLiveStatus(LiveStatuses status){
        this.liveStatus = status;
    }

    enum LiveStatuses{
        live, dead
    }

    protected int getHealth(){
        return this.health;
    }

    protected void setHealth(int value){
        this.health = value;
    }

    protected void addHealthPoints(int points){
        this.health += points;
    }

    protected void subtractHealthPoints(int points){
        this.health -= points;
    }

    protected int getMaxHealth(){
        return this.maxHealth;
    }

    private void setMaxHealth(int value){
        this.maxHealth = value;
    }

    protected float getHeight(){
        return this.height;
    }

    private void setHeight(float height){
        if ((height < 220.0f) & (height > 150.0f)){
            this.height = height;
        }
    }

    protected int getPower(){
        return this.power;
    }

    protected void setPower(int points){
        if ((this.power + points) <= 10) {
            this.power += points;
        }
    }

    protected int getProtection(){
        return this.protection;
    }

    private void setProtection(int armor){
        this.protection = armor;
    }

    protected int getLevel(){
        return this.level;
    }

    private void setLevel(int value){
        this.level = value;
    }

    protected int getExperience(){
        return this.experience;
    }

    protected void experienceGain(){
        this.experience += 1;
    }

    private String[] getCharacterInfo(){
        String[] info = new String[] {this.name, this.sex, String.valueOf(this.liveStatus), String.valueOf(this.level),
                String.valueOf(this.experience), String.valueOf(this.health), String.valueOf(this.maxHealth),
                String.valueOf(this.height), String.valueOf(this.power), String.valueOf(this.birthday),
                String.valueOf(this.speed), String.valueOf(this.protection)};
        return info;
    }
    public void showCharacterInfo(){
        String[] info = getCharacterInfo();
        System.out.println("name: " + info[0] + "; " + "sex: " + info[1] + "; " + "liveStatus: " + info[2] + "; "
                + "level: " + info[3] + "; " + "experience: " + info[4] + "; " + "health: " + info[5] + "; "
                + "maxHealth: " + info[6] + "; " + "height: " + info[7] + "; " + "power: " + info[8] + "; "
                + "birthday: " + info[9] + "; " + "speed: " + info[10] + "; " + "protection: " + info[11]);
    }

    protected void working(){
        experienceGain();
        newLevel();
    }

    protected void newLevel(){
        switch (getExperience()) {
            case 10: upLevel();
            case 20: upLevel();
            case 40: upLevel();
            case 60: upLevel();
            case 120: upLevel();
            case 160: upLevel();
            case 320: upLevel();
            case 480: upLevel();
            case 960: upLevel();
        }
    }

    protected void upLevel(){
        setLevel(this.level + 1);
        setMaxHealth(this.maxHealth * 2);
        setHealth(getMaxHealth());
        if (this.getPower() < 10) { setPower(this.power + 1); }
        if (this.getHeight() < 210.0f) { setHeight(this.height + 10); }
    }

}
