package by.epam.my_study.simple_classes.task10;
/*
Создайте класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- get- методы и метод toString().
Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. Задать критерии выбора данных
и вывести эти данные на консоль.

Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
а) список рейсов для заданного пункта назначения;
б) список рейсов для заданного для недели;
с) список рейсов для заданного для недели, время вылета для которых больше заданного.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Airline {


    private String destination;
    private String flight;
    private AircraftType aircraft;
    private String departureTime ;
    private DayOfWeek dayOfWeek;

    Airline(String destination, String flight, AircraftType type, String departureTime, DayOfWeek dayOfWeek){
        this.destination = destination;

        Pattern flightTemplate = Pattern.compile("^[A-Z]{2}\\d{3}$");  //формат рейса XX000
        Matcher checkFlight = flightTemplate.matcher(flight);
        if(checkFlight.find()){
            this.flight = flight;
        }else{
            System.out.println("Incorrect flight format " + flight + ", must be like AA777. Set default null.");
        }


        this.aircraft = type;

        Pattern timeTemplate = Pattern.compile("^[0,1]{1}\\d{1}[: -]{1}[0-5]{1}\\d{1}$|^[2]{1}[0-3]{1}[: -]{1}[0-5]{1}\\d{1}$");
        Matcher checkTime = timeTemplate.matcher(departureTime);
        if(checkTime.find()) {
            this.departureTime = departureTime;
        }else{
            System.out.println("Incorrect time format " + departureTime + ", must be like XX:XX  or XX-XX or XX XX 24h.. Set default null.");
        }

        this.dayOfWeek = dayOfWeek;

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        Pattern flightTemplate = Pattern.compile("^[A-Z]{2}\\d{3}$");  //формат рейса XX000
        Matcher checkFlight = flightTemplate.matcher(flight);
        if(checkFlight.find()){
            this.flight = flight;
        }else{
            System.out.println("Incorrect flight format " + flight + ", must be like AA777. Set default null.");
        }
    }

    public AircraftType getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftType aircraft) {
        this.aircraft = aircraft;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        Pattern timeTemplate = Pattern.compile("^[0,1]{1}\\d{1}[: -]{1}[0-5]{1}\\d{1}$|^[2]{1}[0-3]{1}[: -]{1}[0-5]{1}\\d{1}$");
        Matcher checkTime = timeTemplate.matcher(departureTime);
        if(checkTime.find()) {
            this.departureTime = departureTime;
        }else{
            System.out.println("Incorrect time format " + departureTime + ", must be like XX:XX  or XX-XX or XX XX 24h.. Set default null.");
        }
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString(){
        return "-----\nFlight: " + flight + " Time: " + departureTime + " Day:" + dayOfWeek + " Destination: " + destination + " Aircraft: " + aircraft + "\n-----";
    }
}
