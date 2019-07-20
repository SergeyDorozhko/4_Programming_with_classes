package by.epam.my_study.agrigation_coposition.task5;

public class TravelAgency {
    private String agencyName;

    private Voucher[] vouchers = new Voucher[20];

    TravelAgency(String agencyName){
        this.agencyName = agencyName;
    }

    public String getAgencyName(){
        return agencyName;
    }

    public void addVoucher(String country, String city, String hotel, PurposeOfTrip purpose, int durationDays, FoodType foodType, boolean canRentCar, double price){
        boolean findEmpty = false;
        for(int i = 0; i < vouchers.length; i++){
            if(vouchers[i] == null){
                vouchers[i] = new Voucher(country, city, hotel, purpose, durationDays, foodType, canRentCar, price);
                findEmpty = true;
                break;
            }
        }


        if(!findEmpty){
            System.out.println("Not add, vouchers is full.");
        }
    }

    public Voucher[] getVouchers(){
        int countVouchers = 0;

        for(int i = 0; i < vouchers.length; i++){
            if(vouchers[i] != null){
                countVouchers++;
            }
        }

        Voucher [] hasVouchers = new Voucher[countVouchers];

        for (int i = 0; i < hasVouchers.length; i++){
            hasVouchers[i] = vouchers[i];
        }

        return hasVouchers;

    }

    public Voucher[] showVouchers(PurposeOfTrip purpose){
        int countPurpuse = 0;
        for(int i = 0; i < getVouchers().length; i++){
            if(getVouchers()[i].getPurpose() == purpose){
                countPurpuse++;

            }
        }

        Voucher [] purpuseVounchers = new Voucher[countPurpuse];

        for(int i = 0, j = 0; i < getVouchers().length; i++){
            if(getVouchers()[i].getPurpose() == purpose){
                purpuseVounchers[j] = getVouchers()[i];
                j++;
            }
        }

        for(int i = 1; i < purpuseVounchers.length; i++){
            if(purpuseVounchers[i - 1].getDurationDays() > purpuseVounchers[i].getDurationDays()){
                Voucher forChange = purpuseVounchers[i - 1];
                purpuseVounchers[i - 1] = purpuseVounchers[i];
                purpuseVounchers[i] = forChange;

                if(i > 1){
                    i -= 2;
                }else{
                    i--;
                }
            }else if(purpuseVounchers[i - 1].getDurationDays() == purpuseVounchers[i].getDurationDays() && purpuseVounchers[i - 1].getPrice() < purpuseVounchers[i].getPrice()){
                Voucher forChange = purpuseVounchers[i - 1];
                purpuseVounchers[i - 1] = purpuseVounchers[i];
                purpuseVounchers[i] = forChange;

                if(i > 1){
                    i -= 2;
                }else{
                    i--;
                }
            }else{
                continue;
            }
        }

        return purpuseVounchers;
    }

    public void showPurposeVouchers(PurposeOfTrip purpose, int durationMin, int durationMax){
        boolean isFind = false;
        for(int i = 0; i < showVouchers(purpose).length; i++){
            if(showVouchers(purpose)[i].getDurationDays() >= durationMin && showVouchers(purpose)[i].getDurationDays() <= durationMax && durationMin > 0 && durationMax  >= durationMin){
                System.out.format("Country : %-10s| City: %-10s| Hotel: %-20s| Purpose of trip: %-10s| duration: %-3d| Food type: %-21s| Can rent car in hotel: %-6s| prise: %8.2f|%n", showVouchers(purpose)[i].getCountry(), showVouchers(purpose)[i].getCity(), showVouchers(purpose)[i].getHotel(), showVouchers(purpose)[i].getPurpose(), showVouchers(purpose)[i].getDurationDays(), showVouchers(purpose)[i].getFoodType(), showVouchers(purpose)[i].isCanRentCar(), showVouchers(purpose)[i].getPrice());

                isFind = true;
            }
        }

        if(!isFind){
            System.out.println("There is no one vouncher with duration from " + durationMin + " to " + durationMax + " days");
        }
    }





    public void showPurposeVouchers(PurposeOfTrip purpose, int durationMin, int durationMax , FoodType type){
        boolean isFind = false;
        for(int i = 0; i < showVouchers(purpose).length; i++){
            boolean showVoucher = showVouchers(purpose)[i].getDurationDays() >= durationMin && showVouchers(purpose)[i].getDurationDays() <= durationMax && durationMin > 0 && durationMax  >= durationMin && type == showVouchers(purpose)[i].getFoodType();
            if(showVoucher){
                System.out.format("Country : %-10s| City: %-10s| Hotel: %-20s| Purpose of trip: %-10s| duration: %-3d| Food type: %-21s| Can rent car in hotel: %-6s| prise: %8.2f|%n", showVouchers(purpose)[i].getCountry(), showVouchers(purpose)[i].getCity(), showVouchers(purpose)[i].getHotel(), showVouchers(purpose)[i].getPurpose(), showVouchers(purpose)[i].getDurationDays(), showVouchers(purpose)[i].getFoodType(), showVouchers(purpose)[i].isCanRentCar(), showVouchers(purpose)[i].getPrice());

                isFind = true;
            }
        }

        if(!isFind){
            System.out.println("There is no one vouncher with this filter");
        }
    }


    public void showPurposeVouchers(PurposeOfTrip purpose, int durationMin, int durationMax , FoodType type, boolean canRentCar){
        boolean isFind = false;
        for(int i = 0; i < showVouchers(purpose).length; i++){
            boolean showVoucher = showVouchers(purpose)[i].getDurationDays() >= durationMin && showVouchers(purpose)[i].getDurationDays() <= durationMax && durationMin > 0 && durationMax  >= durationMin && type == showVouchers(purpose)[i].getFoodType() && showVouchers(purpose)[i].isCanRentCar() == canRentCar;
            if(showVoucher){
                System.out.format("Country : %-10s| City: %-10s| Hotel: %-20s| Purpose of trip: %-10s| duration: %-3d| Food type: %-21s| Can rent car in hotel: %-6s| prise: %8.2f|%n", showVouchers(purpose)[i].getCountry(), showVouchers(purpose)[i].getCity(), showVouchers(purpose)[i].getHotel(), showVouchers(purpose)[i].getPurpose(), showVouchers(purpose)[i].getDurationDays(), showVouchers(purpose)[i].getFoodType(), showVouchers(purpose)[i].isCanRentCar(), showVouchers(purpose)[i].getPrice());

                isFind = true;
            }
        }

        if(!isFind){
            System.out.println("There is no one vouncher with this filter");
        }
    }
}
