package by.epam.my_study.agrigation_coposition.task3;
/*
Создайте объект класса Государство, используя классы Область,  Район, Город. Методы: вывести на консоль столицу,
количество областей, площадь, Обласные центры.
 */



public class Main {
    public static void main(String[] args){
        State belarus = new State("Belarus");

        City minsk = new City("Minsk", 2_000_000, true, "Minskiy",2000, true, "Minskaya", true, belarus);

        belarus.addCity(minsk);

        City borisov = new City("Borisov", 100_000, true, "Borisovski", 800, false, "Minskaya", false, belarus);

        belarus.addCity(borisov);

        City mogilev = new City("Mogilev", 1_000_000, true, "Mogilevski", 1000, true, "Mogilevskaya", false, belarus);

        belarus.addCity(mogilev);


        City gorki = new City("Gorki", 20_000, true, "Gorecki", 100, false, "Mogilevskaya", false, belarus);

        belarus.addCity(gorki);


        City zhodino = new City("Zhodino", 30_000, false, "Borisovski",300, false, "Minskaya", false, belarus);

        belarus.addCity(zhodino);



        /*
        ----------------------------TEST--------------------------------
         */
        belarus.getCapital();

        belarus.getMainRegionCities();

        belarus.getRegionNumber();

        System.out.format("Hole square of the Republic %s is %.2f sq.km.",belarus.getStateName(),belarus.stateSquare());

    }

}
