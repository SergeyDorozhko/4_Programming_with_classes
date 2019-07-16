package by.epam.my_study.simple_classes.task9;
/*
Создать класс Book, спецификачия которого приведена ниже. Определить конструкторыб set- и  get- методы и метод toString().
Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами. Задать критерии выбора
данных и вывести эти данные на консоль.

Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
а) список книг заданного автора;
б) список книгб выпущенных заданным издательством;
с) список книг, выпущенных после заданного года.
 */
public class Book {

    private int id;
    private static int idCounter;

    private String titel;
    private String author;
    private String publishingCompony;
    private short year;
    private short pages;
    private double price;
    private Cover cover;


    Book(String titel, String author, String publishingCompony, int year, int pages, double price, Cover cover){
        this.id = idCounter++;
        this.titel = titel;
        this.author = author;
        this.publishingCompony = publishingCompony;
        if(year > 1000 && year < 2020) {
            this.year = (short) year;
        }else{
            System.out.println("Incorrect value, set default 0, value must be from 1000 to 2020. ID#" + id);
        }

        if(pages > 0){
            this.pages = (short) pages;

        }else{
            System.out.println("Pages must be > 0, set default 0. ID#" + id);
        }

        if(price > 0){
            this.price = price;

        }else{
            System.out.println("Price must be > 0, set default 0. ID#" + id);
        }

        this.cover = cover;
    }




    public int getId(){
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingCompony() {
        return publishingCompony;
    }

    public void setPublishingCompony(String publishingCompony) {
        this.publishingCompony = publishingCompony;
    }

    public short getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = (short)year;
    }

    public short getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = (short) pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Cover getCover(){
        return cover;
    }

    @Override
    public String toString(){
        return "\n----------\nID#" + id + "\nTitle: " + titel + "\nAutor(s): " + author + "\nPublishingCompony: " + publishingCompony + "\npublished: " + year + "\npages: " + pages + "\nCover type: " +cover + "\nPrice: " + price + " BYN\n----------\n";
    }


}
