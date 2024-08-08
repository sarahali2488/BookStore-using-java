//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //-> Initially: append books in inventory
        //-> List of options to user:
        // op1 find a book by (name/isbn) from inventory -> reply with details
        // op2 add to my cart, input isbn (iteration) -> search about isbn,quantity, add to cart --> op2 recursive with op1 to repeat these two
        // op3 proceed to checkout : Are you sure to check out? take input -> check no. books in cart >0, checkout succeeded, (print: no. books , total price , clean cart)
        //-> Test all options , Edit on Adding book quantity , other methods

        Book[] book = {
                new Book("Java Programming", "John Doe", 29.99, 3, "123-456-789"),
                new Book("Python for Beginners", "Jane Smith", 19.99, 3, "987-654-321"),
                new Book("C++ Programming", "Alice Johnson", 34.99, 2, "111-222-333"),
                new Book("Data Structures in Java", "Bob Wilson", 27.99, 2, "444-555-666"),
                new Book("JavaScript Fundamentals", "Mary Brown", 24.99, 2, "777-888-999")
        };

        //Add previous books to inventory
        Inventory inventory = new Inventory();
        for (Book b : book) {
            Inventory.addBook(b);
        }

        Scanner scanner = new Scanner(System.in);
        boolean CheckoutSuccess = false;

        //View Options to user
        System.out.println("""
                Hello!
                Choose one of these options:\

                1- Find Book by NAme/ISBN.\

                2- Add Book to Cart.\

                3- Checkout!""");
        scanner.nextLine();
        int UserOption = scanner.nextInt();

        switch (UserOption) {
            case 1:
                UserOptionOne(book);
                break;
            case 2:
                UserOptionTwo(book);
                break;
            case 3:
                CheckoutSuccess = true;
                System.out.println("Are you sure to Checkout? (y/n)");
                String UserCheckout = scanner.nextLine();

                if (UserCheckout.equals("y")) {
                    //Check number of books , total price. Then clean cart.
                    if (Cart.getSize() > 0) {
                        if (Cart.totalPrice() > 0) {
                            Cart.displayCart();
                            Cart.clearCart();
                            System.out.println("Your Cart has been checked out!");
                        }
                    } else if(Cart.getSize() == 0) {
                        System.out.println("Your Cart is empty!");
                    }
                } else{
                    CheckoutSuccess = false;
                }
                break;

            default:
                System.out.println("Invalid option!");
        }
    }
    //scanner.close();

    //Methods op1
    public static void UserOptionOne(Book[] book) {
        System.out.println("Find a Book by [ Name | ISBN ]? ");
        Scanner scanner = new Scanner(System.in);
        String UserAnswer = scanner.nextLine();

        if (UserAnswer.equals("Name")) {
            System.out.println("Enter the name of the book: ");
            String UserAnswer2 = scanner.nextLine();
            Inventory.SearchBookByName(UserAnswer2);
        }
        else if (UserAnswer.equals("ISBN")) {
            System.out.println("Enter the ISBN of the book: ");
            String BookISBN = scanner.nextLine();
            Inventory.SearchBookByISBN(BookISBN);
        }
        else{
            System.out.println("Invalid input! Choose 'Name' or 'ISBN'.");
        }
    }

    //Method op2: Recusive/Repeated untill saying done
    public static void UserOptionTwo(Book[] book) {
        boolean AddMore = true;
        while (AddMore) {
            System.out.println("Let's Add This Book to the cart: " + "\nEnter the ISBN of the Book...");
            Scanner scanner = null;
            String BookISBN = scanner.nextLine();

            for (Book b : book) {
                if (b.getISBN().equals(BookISBN) && b.getQuantity() > 0) {
                    Cart.addBookToCart(b); //book quantity should decrease and check q > 0.
                    System.out.println("Book Added to cart.");
                }
                else{
                    System.out.println("Book Not found");
                }
            }
        }
        Cart.displayCart();
        //Inventory.ShowInventoryList();

        //Option to add more books or just stop
        System.out.println("Do ou want to add more books? (y/n)");
        Scanner Ans_scanner = null;
        String AnswerAddMore= Ans_scanner.nextLine();
        if (AnswerAddMore.equals("n")) {
            AddMore = false;
        }
    }
}