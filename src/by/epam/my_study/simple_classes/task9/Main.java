package by.epam.my_study.simple_classes.task9;

public class Main {

    public static void main(String[] args){
        Book thinkingInJava = new Book("Thinking in Java","Bruce Eckel","Prentice Hall", 2006, 1079,79.5 ,Cover.HARD);
        Book myBookOne = new Book("I am an author", "S. Dorozhko", "DorPub", 2015, 100, 5,Cover.SOFT);
        Book headFirstJava = new Book("Head First Java","Bert Bates, Kathy Sierra"," O'Reilly Media, Inc.",2005,690, 30.7, Cover.SOFT);
        Book myBookTwo = new Book("i am a programmer", "Ivanov P. Dorozhko S.", "DorPub", 2019, 234,10, Cover.SOFT);
        Book myBookThree = new Book("My life", "Dorozhko S.", "DorPub", 2019, 334,15, Cover.HARD);


        BookShop bukvar = new BookShop(headFirstJava);
        bukvar.addBook(thinkingInJava);
        bukvar.addBook(myBookOne);
        bukvar.addBook(myBookThree);
        bukvar.addBook(myBookTwo);
        bukvar.addBook(thinkingInJava);

        for(Book el: bukvar.showBook()) {
            System.out.println(el);

        }
        bukvar.removeBook(1);

        System.out.println("\tAfter remove");
        for(Book el: bukvar.showBook()) {
            System.out.println(el);

        }


        System.out.println("\tby author:");
        bukvar.booksOfAuthor("Dor");



        System.out.println("\tby publishing compony:");
        bukvar.booksPublishedBy("Dor");

        System.out.println("\tPublished after:");
        bukvar.booksPublishedAfter(2010);

    }
}
