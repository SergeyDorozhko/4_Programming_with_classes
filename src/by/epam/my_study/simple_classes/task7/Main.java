package by.epam.my_study.simple_classes.task7;

public class Main {
    public static void main(String[] args){
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);
        System.out.println("a " + triangle.getSideA() + "; b " + triangle.getSideB() + "; c " + triangle.getSideC() + "; alfa " + triangle.getAngleALFA());



        triangle = new Triangle(2.0, 2.0 , 60f);
        System.out.println("a " + triangle.getSideA() + "; b " + triangle.getSideB() + "; c " + triangle.getSideC() + "; alfa " + triangle.getAngleALFA());


        System.out.println("Square " + triangle.square());

        System.out.println("Perimetr " + triangle.perimetr());

        triangle.medianCross();




        System.out.println("\nNext triangle\n");

        triangle = new Triangle(8,12.5,30);

        System.out.println("a " + triangle.getSideA() + "; b " + triangle.getSideB() + "; c " + triangle.getSideC() + "; alfa " + triangle.getAngleALFA());


        System.out.println("Square " + triangle.square());

        System.out.println("Perimetr " + triangle.perimetr());


        triangle.medianCross();





        System.out.println("\n\nNegotiv test\n");

        triangle = new Triangle(2,3,6d);

        System.out.println("a " + triangle.getSideA() + "; b " + triangle.getSideB() + "; c " + triangle.getSideC() + "; alfa " + triangle.getAngleALFA());


        triangle = new Triangle(10, 15, 190);

        System.out.println("a " + triangle.getSideA() + "; b " + triangle.getSideB() + "; c " + triangle.getSideC() + "; alfa " + triangle.getAngleALFA());

    }
}
