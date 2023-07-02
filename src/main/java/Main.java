import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        ДЗ - 1
//        Крестьянин, разработчик, снайпер, колдун, копейщик, арбалетчик, монах.
//        peasant, developer, sniper, sorcerer, lanceman, crossbowman, monk.

//        Для каждого сформировать список свойств и возможных действий(поведение).
//        Например свойство - скорость, действие - нанести удар.
//        Проанализировать получившиеся свойства и действия персонажей и создать Обобщенный класс
//        описывающий свойства и действия имеющиеся у всех персонажей. Создать этот класс.
//        Создать классы для каждого типа персонажей наследующие и расширяющие абстрактный (обобщённый) класс.
//        В основной программе создать по одному экземпляру каждого типа персонажей.
//
//        ДЗ - 2
//        Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo();
//        Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа.
//        Создать два списка в классе main. В каждый из списков добавить по десять экземнляров наследников BaseHero.
//        Удалить ненужные методы из абстрактного класса, если такие есть.
//        В main пройти по спискам и вызвать у всех персонажей getInfo.

//        final int TEAM_SIZE = 10;

        Peasant peasant = new Peasant("Bob");
        Developer developer = new Developer("James");
        Sniper sniper = new Sniper("Cris");
        Sorcerer sorcerer = new Sorcerer("Saruman");
        Lanceman lanceman = new Lanceman("Enkidu");
        Crossbowman crossbowman = new Crossbowman("Rhodok");
        Monk monk = new Monk("Aaron");

        ArrayList<BaseCharacter> teamWhite = new ArrayList<>();
        ArrayList<BaseCharacter> teamBlack = new ArrayList<>();

        fillTeam(teamWhite);
        fillTeam(teamBlack);

        System.out.println("teamWhite: ");
        showHeroes(teamWhite);
        System.out.println();
        System.out.println("teamBlack: ");
        showHeroes(teamBlack);

    }

    public static void fillTeam(ArrayList<BaseCharacter> list){
        final int TEAM_SIZE = 10;

        enum heroesClasses {
            Peasant, Developer, Sniper, Sorcerer, Lanceman, Crossbowman, Monk
        }

        for (int i = 1; i < TEAM_SIZE + 1; i++) {
            int randNum = new Random().nextInt(0, heroesClasses.values().length);
            switch (randNum){
                case 0:
                    list.add(new Peasant("peasant" + "_" + i));
                    break;
                case 1:
                    list.add(new Developer("developer" + "_" + i));
                    break;
                case 2:
                    list.add(new Sniper("sniper" + "_" + i));
                    break;
                case 3:
                    list.add(new Sorcerer("sorcerer" + "_" + i));
                    break;
                case 4:
                    list.add(new Lanceman("lanceman" + "_" + i));
                    break;
                case 5:
                    list.add(new Crossbowman("crossbowman" + "_" + i));
                    break;
                case 6:
                    list.add(new Monk("monk" + "_" + i));
                    break;
            }
        }
    }

    public static void showHeroes(ArrayList<BaseCharacter> teamName){
        for (BaseCharacter hero: teamName) {
            System.out.println(hero.getInfo() + " " + hero.getName());
        }
    }
}
