package by.epam.my_study.agrigation_coposition.task2;
/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы ехать, заправляться, менять колесо, вывести
на консоль марку автомобиля.
 */

public class Main {
    public static void main(String[] args) {
        Car fordMustang = new Car("Ford", "Mustang", CarBodyType.COUPE, Color.PURPLE, 4, "dt402", EngineType.DIESEL, "Hunkook", "K415", "215/40R17");
        fordMustang.ride();

        fordMustang.takePatrol();

        System.out.println(fordMustang.getBrand() + " " + fordMustang.getModel());

        System.out.println(fordMustang.getWheel());

        fordMustang.changeWheel("Continental", "Contact 5", " ");

        System.out.println(fordMustang.getWheel());
    }

}
