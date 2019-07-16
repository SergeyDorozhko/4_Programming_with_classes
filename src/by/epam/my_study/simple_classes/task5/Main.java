package by.epam.my_study.simple_classes.task5;

public class Main {
    public static void main(String[] args){
        DecimalCounter counter = new DecimalCounter(15);

        System.out.println(counter.getCounterCycle() + " " + counter.getCounterStatus());

        counter.positivCount(7);

        System.out.println(counter.getCounterCycle() + " " + counter.getCounterStatus());

        counter.negotivCount(31);

        System.out.println(counter.getCounterCycle() + " " + counter.getCounterStatus());

        DecimalCounter nextCounter = new DecimalCounter();

        System.out.println(nextCounter.getCounterCycle() + " " + nextCounter.getCounterStatus());

        nextCounter.positivCount(7);

        System.out.println(nextCounter.getCounterCycle() + " " + nextCounter.getCounterStatus());

        nextCounter.negotivCount(31);

        System.out.println(nextCounter.getCounterCycle() + " " + nextCounter.getCounterStatus());
    }
}
