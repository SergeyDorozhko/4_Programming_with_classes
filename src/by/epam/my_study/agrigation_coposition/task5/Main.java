package by.epam.my_study.agrigation_coposition.task5;
/*
Туристическая путевка. Сформировать набор предложений клиенту по выбору туристической путевки различного типа (отдых, экскурсии,
лечение, шопинг, круиз) для оптимального выбора. Учитывать возможнось выбора транспорта, питания и числа дней. Реализвать выбор
и сортировку путевок.
 */
public class Main {
    public static void main(String[] args){
        TravelAgency tezTour = new TravelAgency("TezTour");

        tezTour.addVoucher("Egupt", "Hurgada", "Sinbad Club", PurposeOfTrip.RELAX, 10, FoodType.ALL_INCLUSIVE, false, 800 );
        tezTour.addVoucher("Turkey", "Avsalar", "Atique", PurposeOfTrip.RELAX, 11, FoodType.ALL_INCLUSIVE, true,1200);
        tezTour.addVoucher("Turkey", "Avsalar", "Antique", PurposeOfTrip.RELAX, 7, FoodType.BREAKFAST_AND_DINNER, true, 700);

        tezTour.addVoucher("Poland", "Warshawa", "Aramis", PurposeOfTrip.SHOPING, 2, FoodType.ONLY_BREAKFAST, true, 50);
        tezTour.addVoucher("Poland", "Bialostok", "Badders Willa", PurposeOfTrip.SHOPING, 1, FoodType.ONLY_BREAKFAST, true, 30);

        tezTour.addVoucher("Germany", "Berlin", "Quentin Boutique", PurposeOfTrip.EXCURTION, 5, FoodType.BREAKFAST_AND_DINNER, true, 300);
        tezTour.addVoucher("Germany", "Berlin", "Quentin Boutique", PurposeOfTrip.EXCURTION, 5, FoodType.ONLY_BREAKFAST, true, 270);
        tezTour.addVoucher("Germany", "Berlin", "Sachsenhof", PurposeOfTrip.EXCURTION, 5, FoodType.BREAKFAST_AND_DINNER, true, 250);

        tezTour.addVoucher("Spain", "Maiorca", "Cabrera", PurposeOfTrip.RELAX, 10, FoodType.BREAKFAST_AND_DINNER, true, 1500 );
        tezTour.addVoucher("Spain", "Maiorca", "Cabrera", PurposeOfTrip.RELAX, 10, FoodType.ONLY_BREAKFAST, true, 1300 );

        tezTour.addVoucher("Spain", "Maiorca", "Pamplona", PurposeOfTrip.RELAX, 10, FoodType.BREAKFAST_AND_DINNER, true, 1700 );
        tezTour.addVoucher("Spain", "Maiorca", "Pamplona", PurposeOfTrip.RELAX, 7, FoodType.BREAKFAST_AND_DINNER, true, 1300 );

        tezTour.addVoucher("Spain", "Maiorca", "Pamplona", PurposeOfTrip.RELAX, 10, FoodType.ONLY_BREAKFAST, true, 1500);
        tezTour.addVoucher("Spain", "Maiorca", "Pamplona", PurposeOfTrip.RELAX, 7, FoodType.ONLY_BREAKFAST, true, 1200);

        tezTour.addVoucher("Spain", "Maiorca", "Cabrera", PurposeOfTrip.RELAX, 8, FoodType.ONLY_BREAKFAST, true, 1200 );

        tezTour.addVoucher("Greece", "Crit", "Eftichia", PurposeOfTrip.RELAX, 9, FoodType.ONLY_BREAKFAST, false, 1200 );

        tezTour.addVoucher("Greece", "Crit", "Eftichia", PurposeOfTrip.RELAX, 9, FoodType.BREAKFAST_AND_DINNER, false, 1400 );


        for(Voucher el : tezTour.getVouchers()){
            System.out.format("Country : %-10s| City: %-10s| Hotel: %-20s| Purpose of trip: %-10s| duration: %-3d| Food type: %-21s| Can rent car in hotel: %-6s| prise: %8.2f|%n", el.getCountry(), el.getCity(), el.getHotel(), el.getPurpose(), el.getDurationDays(), el.getFoodType(), el.isCanRentCar(), el.getPrice());
        }


        System.out.println("---------------------------------------BY PURPOSE-----------------------------------");

        for(Voucher el: tezTour.showVouchers(PurposeOfTrip.RELAX)){
            System.out.format("Country : %-10s| City: %-10s| Hotel: %-20s| Purpose of trip: %-10s| duration: %-3d| Food type: %-21s| Can rent car in hotel: %-6s| prise: %8.2f|%n", el.getCountry(), el.getCity(), el.getHotel(), el.getPurpose(), el.getDurationDays(), el.getFoodType(), el.isCanRentCar(), el.getPrice());
        }

        System.out.println("---------------------------------------BY PURPOSE AND DAYS-----------------------------------");

        tezTour.showPurposeVouchers(PurposeOfTrip.RELAX, 5,9);

        System.out.println("---------------------------------------BY PURPOSE AND DAYS && FOOD-----------------------------------");

        tezTour.showPurposeVouchers(PurposeOfTrip.RELAX, 5, 11, FoodType.BREAKFAST_AND_DINNER);


        System.out.println("---------------------------------------BY PURPOSE AND DAYS && FOOD && RENT CAR-----------------------------------");

        tezTour.showPurposeVouchers(PurposeOfTrip.RELAX, 5, 11, FoodType.BREAKFAST_AND_DINNER, true);

    }
}
