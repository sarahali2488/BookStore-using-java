import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static ArrayList<Book> bookList = new ArrayList<>();

    public Inventory(){
        bookList = new ArrayList<>();
    }

    public static void addBook(Book book){
        bookList.add(book);
    }

    public static void removeBook(Book book){
        bookList.remove(book);
    }

    public static void ShowInventoryList(){
        for(Book book : bookList) {
            System.out.println("Book name: " + book.getName()
                    + " - Author: " + book.getAuthor()
                    + " - Price: " + book.getPrice()
                    + " - Quantity: " + book.getQuantity()
                    + " - ISBN: " + book.getISBN() + ".");
        }
    }

    public static void SearchBookByName(String NAME){
        for(Book book : bookList){
            if(book.getName().equals(NAME)){
                System.out.println("Book name: " + book.getName()
                        + " - Author: " + book.getAuthor()
                        + " - Price: " + book.getPrice()
                        + " - Quantity: " + book.getQuantity()
                        + " - ISBN: " + book.getISBN() + ".");
            }
//            else{
//                System.out.println("Book NOT FOUND.");
//            }
        }
    }

    public static void SearchBookByISBN(String ISBN){
        for(Book book : bookList){
            if(book.getISBN().equals(ISBN)){
                System.out.println("Book name: " + book.getName()
                        + " - Author: " + book.getAuthor()
                        + " - Price: " + book.getPrice()
                        + " - Quantity: " + book.getQuantity()
                        + " - ISBN: " + book.getISBN() + ".");
            }
//            else{
//                System.out.println("Book NOT FOUND.");
//            }
        }
    }

    //Note: Remove from one book not all
    public static void AddBookQuantity(String BookISBN){
        for(Book book : bookList){
            if(book.getISBN().equals(BookISBN)) {
                book.setQuantity(book.getQuantity() + 1);
            }
        }
    }

    public static void ReduceBookQuantity(String BookISBN){
        for(Book book : bookList){
            if(book.getISBN().equals(BookISBN)){
                book.setQuantity(book.getQuantity() - 1);
            }
        }
    }
}
