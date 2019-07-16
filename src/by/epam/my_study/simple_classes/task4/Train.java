package by.epam.my_study.simple_classes.task4;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

/*
Создайте класс Train, содержащиц поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массиве из пяти элементов типа Train, добавьте возмжность сортировки элементов по номерам поездов. Добавить
возможность вывоа информации о поезде, номер которого введен пользователем. Добавьте возмжность сортировки массива по пункту
назначения, причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */
public class Train {

    private int trainNumber;
    private String destination;
    private String departureTime;

    Train(int trainNumber, String departureAt, String destination){
        this.trainNumber = trainNumber;
        this.destination = destination;
        /*
        проверка на корректность данных по времени отправления.
         */
        String [] departure = departureAt.split(":| |-", 2);  //split by ":" or " " or "-"

        if(departureAt.length() == 5 && departure.length == 2) {
            boolean hour = (Integer.parseInt(departure[0]) < 24 && Integer.parseInt(departure[0]) >= 0);
            boolean minutes = (Integer.parseInt(departure[1]) < 60 && Integer.parseInt(departure[0]) >= 0);

            if (hour && minutes) {
                this.departureTime = departureAt.replaceAll(" |-",":");
            } else {
                System.out.println("Incurrect time format: " + departureAt + ". At train number :" + trainNumber);
            }
        }else{
            System.out.println("Incurrect time format: " + departureAt + ". At train number :" + trainNumber);
        }

    }


    Train(){}



    public int getTrainNumber(){
        return trainNumber;
    }



    public String getDestination(){
        return destination;
    }



    public String getDepartureTime(){
        return departureTime;
    }


    public void sortByNumber(Train[] train){
        for(int i = 1; i < train.length; i++){
            if(train[i - 1].getTrainNumber() > train[i].getTrainNumber()){
                Train forChange = train[i];
                train[i] = train[i - 1];
                train[i - 1] = forChange;
                if(i > 1){
                    i -= 2;
                }else {
                    i--;
                }
            }
        }

        for(Train element : train){
            System.out.println("Train #" + element.getTrainNumber() + " departure at " + element.getDepartureTime() + ", destination: " + element.getDestination() );
        }
    }



    public void sortByDestination(Train[] timetable){
        for (int i = 1; i < timetable.length; i++){
            for(int j = 0; j < timetable[i].getDestination().length() && j < timetable[i - 1].getDestination().length(); j++){
                if(timetable[i - 1].getDestination().toLowerCase().charAt(j) < timetable[i].getDestination().toLowerCase().charAt(j)){
                    break;
                }else if(timetable[i - 1].getDestination().toLowerCase().charAt(j) > timetable[i].getDestination().toLowerCase().charAt(j)){
                    Train forChange = timetable[i];
                    timetable[i] = timetable[i - 1];
                    timetable[i - 1] = forChange;


                    if (i > 1){
                        i -= 2;
                    }else{
                        i--;
                    }

                    break;
                }else{
                    continue;
                }

            }

        }

        for(int i = 1; i < timetable.length; i++){
            if(timetable[i - 1].getDestination().equals(timetable[i].getDestination())){
            String[] firstTrainTime = timetable[i - 1].getDepartureTime().split(":");
            String[] secondTrainTime = timetable[i].getDepartureTime().split(":");

            boolean firstIsEarlier = ((Integer.parseInt(firstTrainTime[0]) * 60) + Integer.parseInt(firstTrainTime[1])) <= ((Integer.parseInt(secondTrainTime[0]) * 60) + Integer.parseInt(secondTrainTime[1]));
                if(firstIsEarlier){
                    break;
                }else{
                    Train forChange = timetable[i];
                    timetable[i] = timetable[i - 1];
                    timetable[i - 1] = forChange;


                    if (i > 1){
                        i -= 2;
                    }else{
                        i--;
                    }

                    break;
                }
            }
        }

        for(Train element : timetable){

            System.out.println("Train #" + element.getTrainNumber() + " departure at " + element.getDepartureTime() + ", destination: " + element.getDestination() );
        }

    }


    public void info(int trainNumber, Train [] timetable){
        int isFind = 0;
        for(int i = 0; i < timetable.length; i++){
            if(trainNumber == timetable[i].getTrainNumber()){
                System.out.println("Train #" + timetable[i].getTrainNumber() + " departure at " + timetable[i].getDepartureTime() + ", destination: " + timetable[i].getDestination() + "\n");
                isFind++;
            }
        }

        if(isFind == 0){
            System.out.println("Данные по поезду №" + trainNumber + " отсутсвуют.\n");
        }
    }


    public static void startTimetable(){
        Train [] train = new Train[5];
        train[0] = new Train(752, "13:50", "Polotsk");
        train[1] = new Train(382, "12:00", "Orsha");
        train[2] = new Train(834, "11:02", "Polotsk");
        train[3] = new Train(12, "00 05", "Vitebsk");
        train[4] = new Train(53, "02-30", "Brest");



        Scanner scan = new Scanner(System.in);
        Train timetable = new Train();
        do{
            System.out.println("Выберите действие:\n1) Сортировка по возростанию номеров поездов.\n2) Вывод информации по поезду.\n3)Сортировка по алфавиту пунктов назначения, при совподении по времени.\n0) Выход");
            int action = scan.nextInt();
            switch(action){
                case 1:
                    timetable.sortByNumber(train);
                    break;
                case 2:
                    System.out.println("По какому поезду вывести информацию. Введите номер:");
                    int trainNumber = scan.nextInt();
                    timetable.info(trainNumber, train);
                    break;
                case 3:
                    timetable.sortByDestination(train);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Не верное значение, попробуйте еще раз.\n");
            }

        }while(true);
    }

    public static void main(String[] args){
        Train.startTimetable();
    }

}
