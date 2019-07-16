package by.epam.my_study.simple_classes.task9;

public class BookShop {

    private Book [] book = new Book[15];

    BookShop(){}

    BookShop(Book book){
        this.book[0] = book;
    }

    public void addBook(Book book){
        for(int i = 0; i < this.book.length; i++){
            if(this.book[i] == null){
                this.book[i] = book;
                break;
            }
            if(i == this.book.length - 1 && this.book[i] != null){
                System.out.println("Shop reached max number of books, can not add book to the shop.");
            }
        }
    }

    public void removeBook(int bookId){
        for(int i = 0; i < this.book.length; i++){
            if(this.book[i] != null && this.book[i].getId() == bookId){
                this.book[i] = null;
                break;
            }
            if(i == this.book.length - 1 && (this.book[i] == null || this.book[i].getId() != bookId)){
                System.out.println("There is no book in shop with id#" + bookId);
            }
        }
    }

    public Book[] showBook(){
        int countBook = 0;
        for(int i = 0; i < book.length; i++){
            if(book[i] != null){
                countBook++;
            }
        }

        Book [] booksInShop = new Book[countBook];

        for (int i = 0, j = 0; i < this.book.length; i++) {
            if (this.book[i] != null) {
                booksInShop[j] = this.book[i];
                j++;
                continue;
            }
        }

        return booksInShop;
    }


    public void booksOfAuthor(String author){

        for (int i = 0; i < showBook().length; i++){
            if (showBook()[i].getAuthor().contains(author)){
                System.out.println(showBook()[i]);
            }
        }
    }


    public void booksPublishedBy(String publishingCompony){
        for (int i = 0; i < showBook().length; i++){
            if (showBook()[i].getPublishingCompony().contains(publishingCompony)){
                System.out.println(showBook()[i]);
            }
        }
    }


    public void booksPublishedAfter(int year){
        for (int i = 0; i < showBook().length; i++){
            if (showBook()[i].getYear() > year){
                System.out.println(showBook()[i]);
            }
        }
    }

}
