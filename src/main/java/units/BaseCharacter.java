package units;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class BaseCharacter extends Area implements CharacterInterface{
    private final static String FORMAT = "#0.00";

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
    public int initiative;
    private int speed;
    private int protection;

    private BaseCharacter(int x, int y){
        super(x, y);
        this.level = 1;
        this.experience = 0;
        this.liveStatus = LiveStatuses.live;
        this.birthday = LocalDate.now();
        this.health = new Random().nextInt(50, 100);
        this.maxHealth = 200;
        this.height = Float.parseFloat((new DecimalFormat(FORMAT)
                .format(new Random().nextFloat(150, 220))).replace(',', '.'));
        this.power = new Random().nextInt(0,10);
        this.initiative = 1;
        this.speed = new Random().nextInt(0,10);
        this.protection = 1;
    }

    public BaseCharacter(String name, String sex, int x, int y){
        this(x, y);
        this.name = name;
        this.sex = sex;
    }

    public BaseCharacter(String name, int x, int y){
        this(name, "male", x, y);
    }

    public String getName(){
        return this.name;
    }

    protected void setName(String name){
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

    protected int getInitiative(){
        return this.initiative;
    }

    protected void setInitiative(int value){
        this.initiative = value;
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
            case 10:
                upLevel();
                break;
            case 20:
                upLevel();
                break;
            case 40:
                upLevel();
                break;
            case 60:
                upLevel();
                break;
            case 120:
                upLevel();
                break;
            case 160:
                upLevel();
                break;
            case 320:
                upLevel();
                break;
            case 480:
                upLevel();
                break;
            case 960:
                upLevel();
                break;
        }
    }

    protected void upLevel(){
        setLevel(this.level + 1);
        setMaxHealth(this.maxHealth * 2);
        setHealth(getMaxHealth());
        if (this.getPower() < 10) { setPower(this.power + 1); }
        if (this.getHeight() < 210.0f) { setHeight(this.height + 10); }
    }
    public BaseCharacter nearestTargetAttack(ArrayList <BaseCharacter> enemyTeam){
        double nearest = nearestEnemy(enemyTeam.get(0));
        int index = 0;
        for (int i = 1; i < enemyTeam.size(); i++) {
            if (nearestEnemy(enemyTeam.get(i)) < nearest){
                nearest = nearestEnemy(enemyTeam.get(i));
                index = i;
            }
        }
        return enemyTeam.get(index);
    }

}
