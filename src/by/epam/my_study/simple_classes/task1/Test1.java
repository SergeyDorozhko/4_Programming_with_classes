package by.epam.my_study.simple_classes.task1;
/*
Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и метода изменения этих переменных.
Добавьте метод который находит сумму этих переменных и метод, который находит наибольшее значение из этих переменных.
 */
public class Test1 {

    private int valueOne;
    private int valueTwo;

    public void show(int value){
        System.out.println("Value is " + value);
    }

    public void show(int value, int valueNext){
        System.out.println("First value: " + value + ", second value: " + valueNext);
    }


    public int getValueOne(){
        return valueOne;
    }

    public int getValueTwo(){
        return valueTwo;
    }


    public int setValueOne(int value){
       return this.valueOne = value;
    }


    public int setValueTwo(int value){
        return  valueTwo = value;
    }

    public int summ(int valueOne, int valueTwo){
        return valueOne + valueTwo;
    }


    public void maxValue(int valueOne, int valueTwo){
        if(valueOne > valueTwo){
            System.out.println("max: " + valueOne);
        }else if(valueOne < valueTwo){
            System.out.println("max: " + valueTwo);
        }else{
            System.out.println(valueOne + " and " + valueTwo + " are equals");
        }
    }


    public static void main(String[] args){
        Test1 test = new Test1();

        test.show(test.getValueOne(), test.getValueTwo());


        test.setValueOne(5);
        test.setValueTwo(5);


        test.show(test.getValueOne(), test.getValueTwo());


        test.maxValue(test.valueOne, test.valueTwo);

        System.out.println("summ:");

        test.show(test.summ(test.getValueOne(), test.getValueTwo()));

    }
}
