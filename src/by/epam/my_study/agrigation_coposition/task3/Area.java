package by.epam.my_study.agrigation_coposition.task3;

public class Area {
    private String mainCity;
    private String areaName;
    private Region belongToRegion;

    private double areaSquare;


    private City[] cities = new City[100];

    Area (String mainCity, String areaName, Region region, double areaSquare){
        this.mainCity = mainCity;
        this.areaName = areaName;
        this.belongToRegion = region;

        this.areaSquare = areaSquare;

    }


    public String getMainCity(){
        return mainCity;
    }

    public String getAreaName() {
        return areaName;
    }

    public Region getBelongToRegion() {
        return belongToRegion;
    }

    public void addCity(City city){
        boolean hasCity = false;
        for (int i = 0; i < cities.length; i++){
            if(cities[i] != null && cities[i].getCityName() == city.getCityName()){
                hasCity = true;
                break;
            }
        }

        if(!hasCity){
            for (int i = 0; i < cities.length; i++){
                if(cities[i] == null){
                    cities[i] = city;
//                    System.out.println("add City" + i);
                    break;
                }
            }
        }
    }

    public City[] getCities(){
        int countNotNull = 0;
        for(int i = 0; i < cities.length; i++){
            if(cities[i] != null){
                countNotNull++;
            }
        }
        City [] hasCity = new City[countNotNull];
        for(int i = 0; i < hasCity.length; i++){

                hasCity[i] = cities[i];

        }

        return hasCity;
    }

    public double getAreaSquare(){
        return areaSquare;
    }
}
