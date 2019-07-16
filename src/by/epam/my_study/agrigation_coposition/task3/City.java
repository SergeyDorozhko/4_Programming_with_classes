package by.epam.my_study.agrigation_coposition.task3;

public class City {
    String cityName;
    int population;

    boolean mainCityOfArea;
    Area belongToArea;

    boolean mainCityOfRegion;
    Region belongToRegion;

    boolean isCapital;
    State belongToState;


    City(String cityName, int population, boolean mainCityOfArea, String areaName, double areaSquare, boolean mainCityOfRegion, String regionName, boolean isCapital, State state){
        this.cityName = cityName;
        this.population = population;

        this.belongToState = state;

        this.isCapital = isCapital;

        this.mainCityOfRegion = mainCityOfRegion;


        if(mainCityOfRegion){
            this.belongToRegion = new Region(regionName, cityName, state);
        }else{


            for (int i = 0; i < state.getRegions().length; i++){
                if(state.getRegions()[i].getRegionName().equals(regionName)){
                    this.belongToRegion = state.getRegions()[i];
//                    System.out.println("присвоили область " + i);

                     break;
                }
            }
        }

        if(mainCityOfArea){
            this.belongToArea = new Area(cityName, areaName, this.belongToRegion, areaSquare);
//            System.out.println("добавили новый район ");
        }else{
            for(int i = 0; i < this.belongToRegion.getAreas().length; i++) {
                if (this.belongToRegion.getAreas()[i].getAreaName().equals(areaName)){
                    this.belongToArea = this.belongToRegion.getAreas()[i];
//                    System.out.println("добавили в существующий район");
                    break;
                }
            }
        }
    }

    public String getCityName() {
        return cityName;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isMainCityOfArea() {
        return mainCityOfArea;
    }

    public Area getBelongToArea() {
        return belongToArea;
    }

    public boolean isMainCityOfRegion() {
        return mainCityOfRegion;
    }

    public Region getBelongToRegion() {
        return belongToRegion;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public State getBelongToState() {
        return belongToState;
    }
}
