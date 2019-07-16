package by.epam.my_study.simple_classes.task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
создать класс Customer, спецификация которого приведена ниже. Определить конструкторы set- и get- методы, метод to String.
Создать второй класс, агрегирующий массив типа Customer с подходящими конструкторами и методами. Задать критерии выбора данных и
вывести эти данные на консоль.
класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карты, номер банковского счета.
Найти и вывести:
a)Список покупателей в алфовитном порядке.
b)Список покупателей у которых номер кридитной карточки находится в заданном интервале.
 */
public class Customer {

    private int id;
    private String lastName;
    private String firstName;
    private String dadName;
    private String adress;
    private String cardNumber;
    private long bankAccount;

    private static int idCounter = 0; //   поле для генирации последовательного, уникального id.


    Customer(String firstName, String lastName, String cardNumber){
        idCounter++;
        id = idCounter;
        this.firstName = firstName;
        this.lastName = lastName;

        Pattern cardTemplate =Pattern.compile("^\\d{4}[ .,-]?\\d{4}[ .,-]?\\d{4}[ .,-]?\\d{4}$");
        Matcher cardCheck = cardTemplate.matcher(cardNumber);
        if(cardCheck.find()){
            this.cardNumber = cardNumber.replaceAll("[ .,-]","");
        }else{
            System.out.println("Incorrect card, customer id " + id + " check input: " + cardNumber + ".\nCorrect format:\nXXXXXXXXXXXXXXXX\nXXXX.XXXX.XXXX.XXXX\nXXXX,XXXX,XXXX,XXXX\nXXXX-XXXX-XXXX-XXXX\nCard of customer id #" + id + " don't set:");
        }
    }

    Customer(String firstName, String lastName, String dadName, String adress, String cardNumber, long bankAccount){
        idCounter++;
        id = idCounter;

        this.firstName = firstName;
        this.lastName = lastName;
        this.dadName = dadName;
        this.adress = adress;
        if(bankAccount > 0) {
            this.bankAccount = bankAccount;
        }else{
            System.out.println("Bank account cann't be negative" + bankAccount + " Check id#" + id);
        }
        Pattern cardTemplate = Pattern.compile("^\\d{4}[ .,-]?\\d{4}[ .,-]?\\d{4}[ .,-]?\\d{4}$");
        Matcher cardCheck = cardTemplate.matcher(cardNumber);
        if(cardCheck.find()){
            this.cardNumber = cardNumber.replaceAll("[ .,-]","");
        }else{
            System.out.println("Incorrect card, customer id " + id + " check input: " + cardNumber + ".\nCorrect format:\nXXXXXXXXXXXXXXXX\nXXXX.XXXX.XXXX.XXXX\nXXXX,XXXX,XXXX,XXXX\nXXXX-XXXX-XXXX-XXXX\nCard of customer id #" + id + " don't set:");
        }
    }


    public int getId(){
        return id;
    }



    public String getFirstName(){
        return  firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }



    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }



    public String getDadName(){
        return dadName;
    }

    public void setDadName(String dadName){
        this.dadName = dadName;
    }



    public String getAdress(){
        return adress;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }




    public String getCardNumber(){
        return cardNumber.substring(0,4) + "." + cardNumber.substring(4,8) + "." + cardNumber.substring(8,12) + "." + cardNumber.substring(12);
    }

    public long getLongCardNumber(){
        return Long.parseLong(cardNumber);
    }

    public void setCardNumber(String cardNumber){
        Pattern cardTemplate = Pattern.compile("^\\d{4}[ .,-]?\\d{4}[ .,-]?\\d{4}[ .,-]?\\d{4}$");
        Matcher cardCheck = cardTemplate.matcher(cardNumber);
        if(cardCheck.find()){
            this.cardNumber = cardNumber.replaceAll("[ .,-]","");
        }else{
            System.out.println("Incorrect card, customer id " + id + " check input: " + cardNumber + ".\nCorrect format:\nXXXXXXXXXXXXXXXX\nXXXX.XXXX.XXXX.XXXX\nXXXX,XXXX,XXXX,XXXX\nXXXX-XXXX-XXXX-XXXX\nCard of customer id #" + id + " don't set.");
        }
    }


    public long getBankAccount() {
        return bankAccount;
    }


    public void setBankAccount(long bankAccount) {
        if(bankAccount > 0) {
            this.bankAccount = bankAccount;
        }else{
            System.out.println("Bank account cann't be negative" + bankAccount + " Check id#" + id);


        }
    }

    @Override
    public String toString(){

        return "---\nid#" + id + ", first name: " + firstName +", last name: " + lastName + " dad's name: " + dadName + ",\nadress: " + adress + ",\ncard number" + cardNumber.substring(0,4) + "..."+ cardNumber.substring(12) + ",\nbank account: " + bankAccount + "\n---\n\n\n";
    }
}
