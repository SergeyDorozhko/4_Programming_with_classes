package by.epam.my_study.agrigation_coposition.task3;
/*
Создайте объект класса Государство, используя классы Область,  Район, Город. Методы: вывести на консоль столицу,
количество областей, площадь, Обласные центры.
 */
public class State {
    private String stateName;
    private Region[] regions = new Region[20];

    State(String stateName){
        this.stateName = stateName;
    }

    public void addCity(City city){

        boolean hasRegion = false;
        for (int i = 0; i < regions.length; i++){

            if(regions[i] != null && regions[i].getRegionName() == city.getBelongToRegion().getRegionName()){
                hasRegion = true;
                break;
            }
        }

        if(!hasRegion){
            for (int i = 0; i < regions.length; i++){

                if(regions[i] == null){
                    regions[i] = city.getBelongToRegion();
//                    System.out.println("add Region " + i);
                    break;
                }
            }
        }


        city.getBelongToRegion().addArea(city);
        city.getBelongToArea().addCity(city);


    }

    public String getStateName() {
        return stateName;
    }

    public Region[] getRegions() {
        int countNotNull = 0;
        for(int i = 0; i < regions.length; i++){
            if(regions[i] != null){
                countNotNull++;
            }
        }

        Region [] hasRegion = new Region[countNotNull];
        for(int i = 0; i < hasRegion.length; i++){
            if(regions[i] != null){
                hasRegion[i] = regions[i];
            }
        }

        return hasRegion;
    }

    public void getCapital(){
        for(int i = 0; i < getRegions().length; i++){
            for(int j = 0; j < getRegions()[i].getAreas().length; j++){
                for(int k = 0; k < getRegions()[i].getAreas()[j].getCities().length; k++){

                    if(getRegions()[i].getAreas()[j].getCities()[k].isCapital()){
                        System.out.println("Capital is :" + getRegions()[i].getAreas()[j].getCities()[k].getCityName());
                    }
                }
            }
        }
    }



    public void getMainRegionCities(){
        for(int i = 0; i < getRegions().length; i++){
            for(int j = 0; j < getRegions()[i].getAreas().length; j++){
                for(int k = 0; k < getRegions()[i].getAreas()[j].getCities().length; k++){

                    if(getRegions()[i].getAreas()[j].getCities()[k].isMainCityOfRegion()){
                        System.out.println("Main region city :" + getRegions()[i].getAreas()[j].getCities()[k].getCityName());
                    }
                }
            }
        }
    }

    public void getRegionNumber(){
        System.out.println("There is(are) " + getRegions().length + " regions.");
    }

    public double stateSquare(){
        double holeSquare = 0;
        for(int i = 0; i < getRegions().length; i++){
            for (int j = 0; j < getRegions()[i].getAreas().length; j++){
                holeSquare += getRegions()[i].getAreas()[j].getAreaSquare();
            }
        }
        return holeSquare;
    }
}
