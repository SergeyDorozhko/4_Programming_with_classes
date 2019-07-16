package by.epam.my_study.agrigation_coposition.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wheel {
    String brand;
    String model;
    String size;

    Wheel(String brand, String model, String size){

        this.brand = brand;
        this.model = model;


        Pattern sizePattern = Pattern.compile("[0-9]{3}[/]{1}[0-9]{2}[ ]*?[R,r]{1}[0-9]{2}");
        Matcher checkSize = sizePattern.matcher(size);
        if(checkSize.find()){
            this.size = checkSize.group();
        }else{
            System.out.println("Incorrect size " + size + ", need format XXX/XX RXX");
        }

    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public String getSize(){
        return size;
    }


    public void setSize(String size){
        Pattern sizePattern = Pattern.compile("[0-9]{3}[/]{1}[0-9]{2}[ ]*?[R,r]{1}[0-9]{2}");
        Matcher checkSize = sizePattern.matcher(size);
        if(checkSize.find()){
            this.size = checkSize.group();
        }else{
            System.out.println("Incorrect size " + size + ", need format XXX/XX RXX. Size not changed from" + this.size + " If needed, please try again");
        }
    }

    public void setBrand(String brand){
        this.brand = brand;
    }


    public void setModel(String model){
        this.model = model;
    }

    public void start(){
        System.out.println("Start spinner");
    }

    public void stop(){
        System.out.println("Stop");
    }

}
