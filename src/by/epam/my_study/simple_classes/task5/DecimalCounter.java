package by.epam.my_study.simple_classes.task5;
/*
Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение на единицу в заданном
диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями. Счетчик имеет методы
увеличения и уменьшения состояния, и метод позволяющий получить его текущее состояние. Написать код, демонстрирующий все
возможноси класса.
 */

public class DecimalCounter {
    private int counterStatus;
    private int counterCycle;

    DecimalCounter(){
        counterStatus = 0;
        counterCycle = 0;
    }

    DecimalCounter(int startPosition){
        if(startPosition >= 0 && startPosition < 10 ) {
            counterStatus = startPosition;
            counterCycle = 0;
        }else if(startPosition >= 10){
            counterStatus = startPosition % 10;
            counterCycle = startPosition / 10;
        }

    }

    public int getCounterStatus(){
        return counterStatus;
    }

    public int getCounterCycle(){
        return counterCycle;
    }

    public int positivCount(int steps){
        for(int i = 0; i < steps; i++) {
            if (counterStatus < 10) {
                counterStatus++;
            } else {
                counterCycle++;
                counterStatus = 0;

            }
        }
        return counterStatus;
    }

    public int negotivCount(int steps){
        for(int i = 0; i < steps; i++){
            if(counterStatus >= 0){
                counterStatus--;
            }else{
                counterCycle--;
                counterStatus = 9;
            }
        }
        return counterStatus;
    }


}
