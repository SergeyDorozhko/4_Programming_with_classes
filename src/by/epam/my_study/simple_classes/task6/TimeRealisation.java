package by.epam.my_study.simple_classes.task6;

import java.sql.Time;

/*
Составьте описание класса для представления времени.  Предусмотрите возможность установки времени и изменения его отдельных полей
(часы, минуты, секунды) с проверкой допустимости вводимых значений. В случае недопустимости вводимого значения, поле учтонавливается в 0.
Создать методы изменения времени на заданное количество часов, минут, секунд.
 */
public class TimeRealisation {
    private int hour;
    private int minute;
    private int second;

    TimeRealisation(){
        hour = 0;
        minute = 0;
        second = 0;
    }

    TimeRealisation(int hour, int minute, int second){
        if(hour >= 0 && hour < 24) {
            this.hour = hour;
        }else {
            this.hour = 0;
            System.out.println("Incorrect value hour " + hour + " set default 0");
        }

        if(minute >= 0 && minute < 60){
            this.minute = minute;
        }else{
            this.minute = 0;
            System.out.println("Incorrect value minutes " + minute + " set default 0");
        }

        if(second >= 0 && second < 60){
            this.second = second;
        }else{
            this.second = 0;
            System.out.println("Incorrect value seconds " + second + " set default 0");
        }
    }

    public void setHour(int hour){
        if(hour >= 0 && hour < 24) {
            this.hour = hour;
        }else{
            this.hour = 0;
            System.out.println("Set incorrect value hour " + hour + " set default 0");

        }
    }


    public void setMinute(int minute) {
        if(minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            this.minute = 0;
            System.out.println("Set incorrect value minutes " + minute + " set default 0");
        }
    }


    public void setSecond(int second){
        if( second >= 0 && second < 60){
            this.second = second;
        }else{
            this.second = 0;
            System.out.println("Set incorrect value seconds " + second + " set default 0");
        }
    }

    public void correctForHours(int hour){
        if(this.hour + hour < 24 && this.hour + hour >= 0) {
            this.hour += hour;
        }else{
            System.out.println("Incorrect value (out of day) with changing hours for" + hour + ", hours not changed");
        }

    }

    public void correctForMinutes(int minute){
        if(this.minute + minute >= 0 && this.minute + minute < 60){
            this.minute +=minute;
        }else{
            if(this.hour + minute / 60 >= 0 &&  this.hour + minute / 60 < 24){
                this.hour += (int) minute / 60;
                this.minute += minute % 60;
            }else{
                System.out.println("Incorrect value (out of day) with changing minutes for" + minute + ", time not changed");
            }
        }
    }

    public void correctForSeconds(int second){

        if(second >= 0) {
            if (this.second + second >= 0 && this.second + second < 60) {
                this.second += second;
            } else {
                if ((this.minute + (second / 60)) >= 0 && (this.minute + (second / 60)) < 60) {
                    this.minute += (int) second / 60;
                    this.second += second % 60;

                } else {
                    if (this.hour + (second / 60) / 60 >= 0 && this.hour + (second / 60) / 60 < 24) {


                        this.second += second % 60;
                        this.minute += second / 60;

                        this.hour += (int) this.minute / 60;


                        this.minute %= 60;

                    } else {
                        System.out.println("Incorrect value (out of day) with changing seconds for" + second + ", time not changed");
                    }
                }
            }
        }else{
            System.out.println("Incorrect value, it can not be negative. Time didn't change.");
        }
    }

    public void getTime(){
        System.out.format("%02d:%02d:%02d%n",hour,minute,second);
    }
}
