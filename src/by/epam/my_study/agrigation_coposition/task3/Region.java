package by.epam.my_study.agrigation_coposition.task3;

public class Region {
    private String mainCity;
    private String regionName;
    private State belongToState;

    private Area [] areas = new Area[50];

    Region(String regionName, String mainCity, State state){
        this.regionName = regionName;
        this.mainCity = mainCity;
        belongToState = state;
    }

    public String getMainCity() {
        return mainCity;
    }

    public String getRegionName() {
        return regionName;
    }

    public State getBelongToState() {
        return belongToState;
    }

    public void addArea(City city){
        boolean hasArea = false;
        for (int i = 0; i < areas.length; i++){
           if(areas[i] != null && areas[i].getAreaName() == city.getBelongToArea().getAreaName()){
//               System.out.println(areas[i].getAreaName() + " class");
//               System.out.println(city.belongToArea.getAreaName() + " city" + city.getCityName());
               hasArea = true;
               break;
            }
        }

        if(!hasArea){
            for (int i = 0; i < areas.length; i++){
                if(areas[i] == null){
                    areas[i] = city.getBelongToArea();
//                    System.out.println("add Area" + i);
                    break;
                }
            }
        }

    }

    public Area[] getAreas() {
        int countNotNull = 0;
        for(int i = 0; i < areas.length; i++){
            if(areas[i] != null){
                countNotNull++;
            }
        }

        Area [] hasAreas = new Area[countNotNull];
        for(int i = 0; i < hasAreas.length; i++){
            if(areas[i] != null){
                hasAreas[i] = areas[i];
            }
        }

        return hasAreas;
    }
}
