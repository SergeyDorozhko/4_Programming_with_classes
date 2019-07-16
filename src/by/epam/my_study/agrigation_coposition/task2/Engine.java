package by.epam.my_study.agrigation_coposition.task2;

public class Engine {
    String model;
    EngineType type;

    Engine(String model, EngineType type){
        this.model = model;
        this.type = type;
    }

    public void powerOn(){
        System.out.println("Power On");
    }


    public void powerOFF(){
        System.out.println("Power OFF");
    }


    public void ride(){
        System.out.println("drdrdr");
    }

    public void takePetrol(){
        System.out.println("GOOD IDEA");
    }
}
