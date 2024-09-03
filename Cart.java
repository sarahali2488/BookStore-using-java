import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static ArrayList<Book> BooksInCart = new ArrayList<>();
    private static Cart instance;

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public Cart() {
        BooksInCart = new ArrayList<>();

    }

    public void addBookToCart(Book book) {
        BooksInCart.add(book);
    }

    public static void displayCart() {
        for (Book book : BooksInCart) {
            System.out.println(book);
        }
    }

    public static int getSize(){
        return BooksInCart.size();
    }

    public static Book getBook(){
        for (Book book : BooksInCart) {
            return book;
        }
        return null;
    }

    public static List<Book> getBooksList(){
        return BooksInCart;
    }

    public static double totalPrice() {
        double TotalPrice = 0;

        for (Book book : BooksInCart) {
            TotalPrice += book.getPrice();
        }
        return TotalPrice;
    }

    public static void clearCart(){
        BooksInCart.clear();
    }

    @Override
    public String toString() {
        return BooksInCart.toString();
    }
}

