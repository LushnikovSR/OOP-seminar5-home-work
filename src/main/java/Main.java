import units.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

//        Семинар - 3
//        1. Создать класс с описанием координат, x и y.
//        2. Добавить в абстрактный класс поле с координатами и пробросить его инициализацию
//        до конструкторов персонажей. Farmer farmer = new Farmer(getName(), x, y);
//        3.2. Поиск среди противников наиболее приближенного и вывести в консоль.
//
//        Семинар - 4
//        Step арбалетчика и лучника должны включать следующий интерфейс:
//        1.Если жизни 0 вернуть управление
//        2.Если стрел 0 вернуть управление
//        3.Найти ближайшего противника
//        4.Нанести ему среднее повреждение
//        5.Если среди своих есть крестьянин вернуть управление
//        6.Если нет крестьян уменьшить кол-во стрел на одну и вернуть управление
//

        Peasant peasant = new Peasant("Bob", 0,0);
        Developer developer = new Developer("James", 0,0);
        Sniper sniper = new Sniper("Cris", 0,0);
        Sorcerer sorcerer = new Sorcerer("Saruman", 0,0);
        Lanceman lanceman = new Lanceman("Enkidu", 0,0);
        Crossbowman crossbowman = new Crossbowman("Rhodok", 0,0);
        Monk monk = new Monk("Aaron", 0,0);

        ArrayList<BaseCharacter> teamWhite = new ArrayList<>();
        ArrayList<BaseCharacter> teamBlack = new ArrayList<>();
        ArrayList<BaseCharacter> fightingTeams = new ArrayList<>();

        fillTeam(teamWhite, 1);
        fillTeam(teamBlack, 10);

        fightingTeams.addAll(teamWhite);
        fightingTeams.addAll(teamBlack);
        fightingTeams.sort(Comparator.comparingInt((BaseCharacter hero) -> hero.initiative));

//        System.out.println("teamWhite: ");
//        showHeroes(teamWhite);
//        System.out.println();
//        System.out.println("teamBlack: ");
//        showHeroes(teamBlack);
//
//        System.out.println();
//        System.out.println("Fight: ");
//        teamWhite.forEach(n -> n.step(teamBlack, teamWhite)); // Поиск среди противников наиболее приближенного и вывести в консоль.
//        teamBlack.forEach(n -> n.step(teamWhite, teamBlack));

        System.out.println("teamWhite: ");
        teamWhite.forEach(n -> System.out.println(n.getInfo() + " init: " + n.initiative));
        System.out.println("teamBlack: ");
        teamBlack.forEach(n -> System.out.println(n.getInfo() + " init: " + n.initiative));
        System.out.println("========Fight========");

        for (BaseCharacter hero: fightingTeams) {
//            System.out.println(hero.getInfo());
            if (teamWhite.contains(hero)){
                hero.step(teamBlack, teamWhite);
            } else {
                hero.step(teamWhite, teamBlack);
            }
        }

        System.out.println("========FINAL========");
        System.out.println("teamWhite: ");
        teamWhite.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("teamBlack: ");
        teamBlack.forEach(n -> System.out.println(n.getInfo()));
    }

    public static void fillTeam(ArrayList<BaseCharacter> list, int teamSide){
        final int TEAM_SIZE = 10;

        enum heroesClasses {
            Peasant, Developer, Sniper, Sorcerer, Lanceman, Crossbowman, Monk
        }

        for (int i = 1; i < TEAM_SIZE + 1; i++) {
            int randNum = new Random().nextInt(0, heroesClasses.values().length);
            switch (randNum){
                case 0:
                    list.add(new Peasant("peasant" + "_" + i, teamSide, i));
                    break;
                case 1:
                    list.add(new Developer("developer" + "_" + i, teamSide, i));
                    break;
                case 2:
                    list.add(new Sniper("sniper" + "_" + i, teamSide, i));
                    break;
                case 3:
                    list.add(new Sorcerer("sorcerer" + "_" + i, teamSide, i));
                    break;
                case 4:
                    list.add(new Lanceman("lanceman" + "_" + i, teamSide, i));
                    break;
                case 5:
                    list.add(new Crossbowman("crossbowman" + "_" + i, teamSide, i));
                    break;
                case 6:
                    list.add(new Monk("monk" + "_" + i, teamSide, i));
                    break;
            }
        }
    }

    public static void showHeroes(ArrayList<BaseCharacter> teamName){
        for (BaseCharacter hero: teamName) {
            System.out.println(hero.getInfo() + " " + hero.getName() + " x: " + hero.x + " y: " + hero.y);
        }
    }

}
