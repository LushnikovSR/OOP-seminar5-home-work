public class Main {
    public static void main(String[] args) {
//        Крестьянин, разработчик, снайпер, колдун, копейщик, арбалетчик, монах.
//        peasant, developer, sniper, sorcerer, lanceman, crossbowman, monk.

//        Для каждого сформировать список свойств и возможных действий(поведение).
//        Например свойство - скорость, действие - нанести удар.
//        Проанализировать получившиеся свойства и действия персонажей и создать Обобщенный класс
//        описывающий свойства и действия имеющиеся у всех персонажей. Создать этот класс.
//        Создать классы для каждого типа персонажей наследующие и расширяющие абстрактный (обобщённый) класс.
//        В основной программе создать по одному экземпляру каждого типа персонажей.
//

        Peasant peasant = new Peasant("Bob");
        Developer developer = new Developer("James");
        Sniper sniper = new Sniper("Cris");
        Sorcerer sorcerer = new Sorcerer("Saruman");
        Lanceman lanceman = new Lanceman("Enkidu");
        Crossbowman crossbowman = new Crossbowman("Rhodok");
        Monk monk = new Monk("Aaron");

        crossbowman.showCharacterInfo();
        System.out.println();

        System.out.println(crossbowman.getClass() + " " + crossbowman.getName() + ": " + crossbowman.getHealth());
        System.out.println(monk.getClass() + " " + monk.getName() + ": " + monk.getHealth());
        System.out.println(peasant.getClass() + " " + peasant.getName() + ": " + peasant.getHealth());
        System.out.println();

        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.takeWeapon(BaseWarrior.Weapons.knife);
        System.out.println(peasant.getDamage());
        peasant.attack(crossbowman);
        monk.treat(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        peasant.attack(crossbowman);
        monk.treat(crossbowman);

//        monk.addHealthPoints(10);
//        crossbowman.addHealthPoints(10);
//        System.out.println(monk.getClass() + ": " + monk.getHealth());
//        System.out.println(crossbowman.getClass() + ": " + crossbowman.getHealth());
//        monk.treat(crossbowman);

//        crossbowman.treat(monk);
//        System.out.println(monk.getClass() + ": " + monk.getHealth());
//        System.out.println(crossbowman.getClass() + ": " + crossbowman.getHealth());

    }
}
