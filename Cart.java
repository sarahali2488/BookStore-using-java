import java.util.ArrayList;

public class Cart {
    private static ArrayList<Book> BooksInCart = new ArrayList<>();

    public Cart() {
        BooksInCart = new ArrayList<>();
    }

    public static void addBookToCart(Book book) {
        BooksInCart.add(book);

        //Note: remove from inventory and subtract quantity
        if (book.getQuantity() == 0) {
            Inventory.removeBook(book);
        } else if (book.getQuantity() > 0) {
            Inventory.ReduceBookQuantity(book.getISBN());
        }

        System.out.print("Cart Contains: ");
        for (Book b : BooksInCart) {
            System.out.print(b.getName() + ", ");
        }
    }

    //Note add quantity again
    public void removeBook(Book book) {
        //Note: add quantity again
        BooksInCart.remove(book);
    }

    public static void displayCart() {
        for (Book book : BooksInCart) {
            System.out.println(book);
        }
    }

    public static int getSize(){
        return BooksInCart.size();
    }

//    public static int BooksNumberInCart(){
//        return Cart.BooksInCart.size();
//    }

    public static double totalPrice() {
        double TotalPrice = 0;

        for (Book book : BooksInCart) {
            TotalPrice += book.getPrice();
        }
        return TotalPrice;
    }

    public static void clearCart() {
        for (Book book : BooksInCart) {
            BooksInCart.remove(book);
        }
    }
}

