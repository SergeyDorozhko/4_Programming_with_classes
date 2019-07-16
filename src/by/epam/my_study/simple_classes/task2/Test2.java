package by.epam.my_study.simple_classes.task2;
/*
создайте класс Test2 с двумя переенными. Добавьте конструктор с входными параметрами. Добавьте конструктор,
инициализирующий члены класса по умолчанию. Добавьте методы set и get для полей экземпляра класса.
 */
public class Test2 {
    private int valueOne;
    private int valueTwo;

    Test2(int valueOne, int valueTwo){
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    Test2(){};

    public int getValueOne() {
        return valueOne;
    }

    public int getValueTwo() {
        return valueTwo;
    }


    public void setValueOne(int valueOne) {
        this.valueOne = valueOne;
    }

    public void setValueTwo(int valueTwo) {
        this.valueTwo = valueTwo;
    }

    public static void main(String[] args){
        Test2 test = new Test2(5,9);
        Test2 defaultTest = new Test2();
        System.out.println("undefault value one: " + test.getValueOne() + " value two: " + test.getValueTwo());

        System.out.println("default, value one: " + defaultTest.getValueOne() + " value two: " + defaultTest.getValueTwo());

        test.setValueOne(3);
        defaultTest.setValueTwo(11);



        System.out.println("undefault value one: " + test.getValueOne() + " value two: " + test.getValueTwo());

        System.out.println("default, value one: " + defaultTest.getValueOne() + " value two: " + defaultTest.getValueTwo());

    }
}
