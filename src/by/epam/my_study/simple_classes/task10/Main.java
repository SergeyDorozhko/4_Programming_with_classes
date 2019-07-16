package by.epam.my_study.simple_classes.task10;

public class Main {
    public static void main(String[] args){
        Airline parisPR756 = new Airline("Paris", "PR756", AircraftType.BOEING, "23 00", DayOfWeek.SATURDAY);
        Airline berlinAK657 = new Airline("Berlin", "AK657", AircraftType.BOEING, "24 30", DayOfWeek.SATURDAY);
        Airline moscowMS377 = new Airline("Moscow", "MS-377", AircraftType.BOEING, "23 30", DayOfWeek.THURSDAY);
        Airline parisPR753 = new Airline("Paris", "753", AircraftType.BOEING, "23 00", DayOfWeek.WEDNESDAY);
        Airline parisPR755 = new Airline("Paris", "PR755", AircraftType.BOEING, "23 00", DayOfWeek.FRIDAY);

        berlinAK657.setDepartureTime("10-00");
        moscowMS377.setFlight("MS377");
        parisPR753.setFlight("PR75");
        parisPR753.setFlight("PR753");


        Belavia belavia = new Belavia();
        belavia.addFlight(parisPR753);
        belavia.addFlight(parisPR753);
        belavia.addFlight(parisPR753);
        belavia.addFlight(berlinAK657);
        belavia.addFlight(parisPR755);
        belavia.addFlight(parisPR755);
        belavia.addFlight(parisPR756);
        belavia.addFlight(moscowMS377);
        belavia.addFlight(parisPR753);
        belavia.addFlight(moscowMS377);
        belavia.addFlight(parisPR753);
        belavia.addFlight(parisPR753);

        for(Airline el: belavia.showFlights()){
            System.out.println(el);
        }

        belavia.removeFlight("755");
        belavia.removeFlight("753");
        System.out.println("-----------------AFTER REMOVE-----------------");
        for(Airline el: belavia.showFlights()){
            System.out.println(el);
        }

        belavia.addFlight(moscowMS377);
        belavia.addFlight(parisPR753);
        belavia.addFlight(parisPR753);
        System.out.println("-----------------AFTER ADD-----------------");
        for(Airline el: belavia.showFlights()){
            System.out.println(el);
        }




        System.out.println("\n\n-----------------Destination TO MOSCOW-----------------");
        belavia.showFlightsTo("MOS");


        System.out.println("\n\n-----------------Destination TO Paris-----------------");
        belavia.showFlightsTo("paris");

        System.out.println("\n\n\n\n-----------------DAY OF WEEK-----------------");

        belavia.showFlightsOfDay(DayOfWeek.THURSDAY);

        System.out.println("\n\n\n\n-----------------DAY OF WEEK AFTER -----------------");
        belavia.showFlightsOfDayAfter(DayOfWeek.SATURDAY, "09-00");

    }
}
