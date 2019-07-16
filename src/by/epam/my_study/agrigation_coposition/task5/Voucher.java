package by.epam.my_study.agrigation_coposition.task5;

public class Voucher {
    private String country;
    private String city;
    private String hotel;


    private PurposeOfTrip purpose;
    private int durationDays;
    private FoodType foodType;

    private boolean canRentCar;


    private double price;

    Voucher(String country, String city, String hotel, PurposeOfTrip purpose, int durationDays, FoodType foodType, boolean canRentCar, double price){
        this.country = country;
        this.city = city;
        this.hotel = hotel;

        this.purpose = purpose;
        this.durationDays = durationDays;
        this.foodType = foodType;
        this.canRentCar = canRentCar;

        if(price > 0) {
            this.price = price;
        }else{
            System.out.println("Price not set." + country + " " + city + " " + hotel);
        }
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHotel() {
        return hotel;
    }

    public PurposeOfTrip getPurpose() {
        return purpose;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public boolean isCanRentCar() {
        return canRentCar;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }else{
            System.out.println("Price not set.");
        }
    }


}
