package by.epam.my_study.simple_classes.task3;

import java.util.Arrays;
import java.util.Random;

/*
Создать класс с именем Student, содержащий поля: ФИО, номер группы, успеваемость (массив из 5 элементов).
Создать массив из 10 элементов такого типа. Добавть возможность вывода фамилий и номеров групп студентов
имеющих оценки только 9 и 10.
 */
public class Student {
    private String firstNameLastName;
    private int group;
    private int [] mark = new int[5];


    Student(String firstNameLastName, int group, int [] mark){
        this.firstNameLastName = firstNameLastName;
        this.group = group;
/*
если задается более 5 оценок учитываем первые 5
 */
        for(int i = 0; i < this.mark.length; i++){
            if (mark.length > i) {
                if (mark[i] >= 0 && mark[i] <= 10) {
                    this.mark[i] = mark[i];
                } else {
                    System.out.println("Incorrect value of mark " + mark[i] + " replaced to default 0, Student " + firstNameLastName + " from group " + group);
                    this.mark[i] = 0;
                }
            }else{
                System.out.println("Student" + firstNameLastName + " from group " + group + " has less then 5 marks. Mark №" + (i + 1) + " set default 0" );
            }
        }





    }


    Student(String firstNameLastName, int group){
        this.firstNameLastName = firstNameLastName;
        this.group = group;

        for(int i = 0; i < mark.length; i++){
            mark[i] = new Random().nextInt(10);
        }

    }


    Student(){};

    public String getFirstNameLastName(){
        return firstNameLastName;
    }

    public int getGroup(){
        return group;
    }

    public int[] getMark(){
        return mark;
    }


    public void showOtlichnik(Student student){
        for(int i = 0; i < student.getMark().length; i++){
            if(i == student.getMark().length - 1 && student.getMark()[i] > 8){
                System.out.println(student.getFirstNameLastName() + " from group #" + student.getGroup() + " has marks: " + Arrays.toString(student.getMark()));
            }else if(student.getMark()[i] > 8){
                continue;
            }else{
                break;
            }
        }
    }



    public static void main(String[] args){

        Student student = new Student();

        int [] otlichnikOne = {9, 10, 10, 9, 9};
        int [] otlichnikTwo = {10, 10, 10, 9, 10};

        Student [] university = new Student[10];
        university[0] = new Student("Petr Petrov", 354);
        university[1] = new Student("Vitaly Ivanov", 354);
        university[2] = new Student("Vasiliy Kot", 355);
        university[3] = new Student("Ivan Fedorov", 355);
        university[4] = new Student("Fedor Pirogov", 355, otlichnikOne);
        university[5] = new Student("Chun Li", 89);
        university[6] = new Student("Wan Gu", 89,otlichnikTwo);
        university[7] = new Student("Lee Hu", 89);
        university[8] = new Student("Sadio Mane", 89);
        university[9] = new Student("Daniel Agger", 355, otlichnikOne);



        for(int i = 0; i < university.length; i++){
            student.showOtlichnik(university[i]);
        }
    }


}
