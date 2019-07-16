package by.epam.my_study.simple_classes.task6;

public class Main {
    public static void main(String[] args){
        TimeRealisation time = new TimeRealisation();

        time.getTime();

        time.setHour(5);

        time.getTime();


        time = new TimeRealisation(5,18,62);

        time.getTime();

        time.correctForMinutes(1000);

        time.getTime();

        time.correctForSeconds(-5);

        time.getTime();
    }
}
