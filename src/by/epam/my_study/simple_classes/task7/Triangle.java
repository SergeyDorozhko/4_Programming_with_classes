package by.epam.my_study.simple_classes.task7;

/*
Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, Вычисления площади,
периметря и точки пересечения медиан.
 */
public class Triangle {

    private double sideA;
    private double sideB;
    private double sideC;
    private double angleALFA;

    Triangle(double a, double b, double c){
        boolean correctValue = a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && c + b > a;
        if(correctValue){
            sideA = a;
            sideB = b;
            sideC = c;

        /*
        angleALFA - округляем до 5 знаков после запятой
         */
            angleALFA = Math.round(Math.toDegrees(Math.acos((Math.pow(sideA,2) + Math.pow(sideB,2) - Math.pow(sideC,2)) / (2 * sideA * sideB))) * 100_000);
            angleALFA /= 100_000;

        }else{
            System.out.println("Incorrect value, triangle with sides" + a + " " + b + " " + c + ", doesn't exist. Set default regular triangle with side 1 ");
            sideA = 1;
            sideB = 1;
            sideC = 1;
            angleALFA = 60;
        }
    }

    Triangle(double a, double b, float angleGradBetweenSideASideB){
        boolean correctValue = a > 0 && b > 0 && angleGradBetweenSideASideB > 0 && angleGradBetweenSideASideB < 180;

        if(correctValue) {
            sideA = a;
            sideB = b;
            angleALFA = angleGradBetweenSideASideB;

        /*
        sideC - округляем до 5 знаков после запятой
         */
            sideC = Math.round(Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(Math.toRadians(angleALFA))) * 100_000);
            sideC /= 100_000;
        }else{
            System.out.println("Incorrect value, triangle with sides" + a + " " + b + ", and angle " + angleGradBetweenSideASideB + "deg, doesn't exist. Set default regular triangle with side 1 ");
            sideA = 1;
            sideB = 1;
            sideC = 1;
            angleALFA = 60;
        }

    }

    public double getSideA(){
        return sideA;
    }

    public double getSideB(){
        return sideB;
    }

    public double getSideC(){
        return sideC;
    }

    public double getAngleALFA(){
        return angleALFA;
    }

    public double square(){
        return 0.5 * sideA * sideB *Math.sin(Math.toRadians(angleALFA));
    }

    public double perimetr(){
        return sideA + sideB + sideC;
    }

    public void medianCross(){
        double medianBetweenAB = Math.sqrt(2 * Math.pow(sideA,2) + 2 * Math.pow(sideB, 2) - Math.pow(sideC, 2)) / 2;
        double medianBetweenBC = Math.sqrt(2 * Math.pow(sideB,2) + 2 * Math.pow(sideC, 2) - Math.pow(sideA, 2)) / 2;
        double medianBetweenAC = Math.sqrt(2 * Math.pow(sideA,2) + 2 * Math.pow(sideC, 2) - Math.pow(sideB, 2)) / 2;

        System.out.println("Медианы треугольника равны:\nмежду сторонами:\nab " + medianBetweenAB + ";\nbc " + medianBetweenBC + ";\nac " + medianBetweenAC);
        System.out.println("Точка пересечения медиан находится на расстоянии от углов между сторонами:\nab " + medianBetweenAB / 3 * 2 + ";\nbc " + medianBetweenBC / 3 * 2 + ";\nac " + medianBetweenAC / 3 * 2);

    }

}
