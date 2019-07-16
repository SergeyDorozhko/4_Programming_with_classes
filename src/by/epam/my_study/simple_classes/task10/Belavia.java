package by.epam.my_study.simple_classes.task10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Belavia {
    private Airline [] airline = new Airline[10];

    Belavia(){};
    Belavia(Airline flight){
        this.airline[0] = flight;
    }


    public void addFlight(Airline flight){
        for(int i = 0; i < this.airline.length; i++){
            if(this.airline[i] == null){
                this.airline[i] = flight;
                break;
            }
            if(i == this.airline.length - 1 && this.airline[i] != null){
                System.out.println("Airport reached max number of flight, can not add flight.");
            }
        }
    }


    public void removeFlight(String flight){
        for(int i = 0; i < this.airline.length; i++){
            if(this.airline[i] != null && this.airline[i].getFlight().toLowerCase().contains(flight)){
                this.airline[i] = null;
                break;
            }

            if(i == this.airline.length - 1 && (this.airline[i] == null || !(this.airline[i].getFlight().toLowerCase().contains(flight)))){
                System.out.println("There is no flight: " + flight);
            }
        }
    }


    public Airline[] showFlights(){
        int countFlights = 0;

        for(int i = 0; i < airline.length; i++){
            if(airline[i] != null){
                countFlights++;
            }
        }

        Airline[] showFlights = new Airline[countFlights];

        for(int i = 0, j = 0; i < airline.length; i++){
            if(airline[i] != null){
                showFlights[j] = airline[i];
                j++;
            }
        }


        return showFlights;
    }

    public void showFlightsTo(String destination){
        for (int i = 0; i < showFlights().length; i++){
            if(showFlights()[i].getDestination().toLowerCase().contains(destination.toLowerCase())){
                System.out.println(showFlights()[i]);
            }
        }
    }


    public  void showFlightsOfDay(DayOfWeek day){
        for (int i = 0; i < showFlights().length; i++){
            if(showFlights()[i].getDayOfWeek() == day){
                System.out.println(showFlights()[i]);
            }
        }
    }


    public void showFlightsOfDayAfter(DayOfWeek day, String departureAfter){
        Pattern timeTemplate = Pattern.compile("^[0,1]{1}\\d{1}[: -]{1}[0-5]{1}\\d{1}$|^[2]{1}[0-3]{1}[: -]{1}[0-5]{1}\\d{1}$");
        Matcher checkTime = timeTemplate.matcher(departureAfter);
        if(checkTime.find()){
            String [] hourMinutesAfter = departureAfter.split("[ :-]");
            int hourAfter = Integer.parseInt(hourMinutesAfter[0]);
            int minutesAfter = Integer.parseInt(hourMinutesAfter[1]);
            for (int i = 0; i < showFlights().length; i++) {
                String[] hourMinutesFlight = showFlights()[i].getDepartureTime().split("[ :-]");
                int hourFlight = Integer.parseInt(hourMinutesFlight[0]);
                int minutesFlight = Integer.parseInt(hourMinutesFlight[1]);

                if(hourAfter < hourFlight && day == showFlights()[i].getDayOfWeek()){
                    System.out.println(showFlights()[i]);
                }else if(hourAfter == hourFlight && minutesAfter < minutesFlight && day == showFlights()[i].getDayOfWeek()){
                    System.out.println(showFlights()[i]);
                }else{
                    continue;
                }
            }
        }else{
            System.out.println("Incorrect time format " + departureAfter + ", must be like XX:XX  or XX-XX or XX XX 24h..");
        }
    }


}
