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

        Inventory.ShowInventoryList();

        // Scanner and variable declarations
        Scanner scanner = new Scanner(System.in);
        boolean DoneOptions = false;

        while (!DoneOptions) {
            // Display options to the user
            System.out.println("""
               \nChoose one of these options:
                1- Find Book by Name/ISBN.
                2- Add Book to Cart.
                3- Checkout!""");

            int UserOption = scanner.nextInt();
            scanner.nextLine();  // Clear newline left by nextInt()

            switch (UserOption) {
                case 1:
                    UserOptionOne(book, scanner);
                    break;
                case 2:
                    UserOptionTwo(book, scanner);
                    break;
                case 3:
                    UserOptionThree(book, scanner, DoneOptions);
                    break;
                default:
                    System.out.println("Invalid option! Choose Again..");
            }
        }
        scanner.close();
    }

    // Method for finding a book by Name or ISBN
    public static void UserOptionOne(Book[] book, Scanner scanner) {
        System.out.println("Find a Book by [ Name | ISBN ]? ");
        String UserAnswer = scanner.nextLine();

        if (UserAnswer.equalsIgnoreCase("Name")) {
            System.out.println("Enter the name of the book: ");
            String BookName = scanner.nextLine();
            Inventory.SearchBookByName(BookName);
        }
        else if (UserAnswer.equalsIgnoreCase("ISBN")) {
            System.out.println("Enter the ISBN of the book: ");
            String BookISBN = scanner.nextLine();
            Inventory.SearchBookByISBN(BookISBN);
        }
        else {
            System.out.println("Invalid input! Choose 'Name' or 'ISBN'.");
        }
    }

    // Method for adding a book to the cart, with a loop to allow adding multiple books
    public static void UserOptionTwo(Book[] book, Scanner scanner) {
        boolean AddMore = true;
        while (AddMore) {
            System.out.println("Enter the ISBN of the Book to add it to the cart...");
            String BookISBN = scanner.nextLine();

            for (Book b : book) {
                if (b.getISBN().equals(BookISBN) && b.getQuantity() > 0) {
                    Cart.addBookToCart(b);  // Book quantity should decrease and check q > 0.
                    System.out.println("Book added to cart.");
                    break;
                }
            }

            System.out.println("Do you want to add more books? (y/n)");
            String AnswerAddMore = scanner.nextLine();
            if (AnswerAddMore.equals("n")) {
                AddMore = false;
            }
        }
        Cart.displayCart();
    }

    public static void UserOptionThree(Book[] book, Scanner scanner, boolean DoneOp) {
        System.out.println("Are you sure you want to Checkout? (y/n)");
        String UserCheckout = scanner.nextLine();

        if (UserCheckout.equals("y")) {
            if (Cart.getSize() > 0) {
                if (Cart.totalPrice() > 0) {
                    Cart.displayCart();
                    System.out.println("Your Cart has been checked out!");
                    Cart.clearCart();
                } else {
                    System.out.println("Your Cart is empty!");
                }
            } else {
                System.out.println("Your Cart is empty!");
            }
            DoneOp = true;
        }
    }
}