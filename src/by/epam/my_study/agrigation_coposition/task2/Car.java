package by.epam.my_study.agrigation_coposition.task2;
/*
Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы ехать, заправляться, менять колесо, вывести
на консоль марку автомобиля.
 */

import java.util.SortedMap;

public class Car{
    String brand;
    String model;
    CarBodyType type;
    Color color;
    int doorsNumber;
    Engine engine;
    Wheel wheel;


    Car(){};
    Car(String brand, String model, CarBodyType type, Color color, int doorsNumber, String engineModel, EngineType engineType, String wheelBrand, String wheelModel, String wheelSize){

        this.brand = brand;
        this.model = model;
        this.type = type;
        this.color = color;

        if(doorsNumber > 1 && doorsNumber < 5){
            this.doorsNumber = doorsNumber;
        }else{
            this.doorsNumber = 4;
            System.out.println("Incorrect number of doors " + doorsNumber + " set default 4.");
        }

        this.engine = new Engine(engineModel, engineType);


        this.wheel = new Wheel(wheelBrand, wheelModel, wheelSize);

    }

    public void ride(){
        System.out.println("Start riding.");
        engine.powerOn();
        engine.ride();
        wheel.start();
        wheel.stop();
        engine.powerOFF();
        System.out.println("Arrived");
    }

    public void takePatrol(){
        System.out.println("Need more patrol.");
        engine.takePetrol();
    }

    public void changeWheel(String brand, String model, String size){
        System.out.println("Ops... Need change wheel.");
        wheel.setBrand(brand);
        wheel.setModel(model);
        wheel.setSize(size);
    }

    public String getModel(){
        return model;
    }
    public  String getBrand(){
        return brand;
    }

    public String getWheel(){
        return wheel.getBrand() + " " + wheel.getModel() + " " + wheel.getSize();
    }
}
