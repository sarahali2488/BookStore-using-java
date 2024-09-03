//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book[] books = {
                new Book("Java Programming", "John Doe", 29.99, "123-456-789"),
                new Book("Python for Beginners", "Jane Smith", 19.99, "987-654-321"),
                new Book("C++ Programming", "Alice Johnson", 34.99, "111-222-333"),
                new Book("Data Structures in Java", "Bob Wilson", 27.99,  "444-555-666"),
                new Book("JavaScript Fundamentals", "Mary Brown", 24.99, "777-888-999")
        };

        int[] quantities = {3,3,2,2,2};
        

        //Add previous books to list of inventories
        Inventory[] inventories = new Inventory[books.length];
        Inventory.StoreBooksInInventory(books, quantities, inventories);
        Inventory.DisplayInventory(inventories);

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
                    UserOptionOne(scanner, inventories);
                    break;
                case 2:
                    UserOptionTwo(scanner,inventories);
                    break;
                case 3:
                    UserOptionThree(scanner, inventories);
                    DoneOptions = true;
                    break;
                default:
                    System.out.println("Invalid option! Choose Again..");
            }
        }
        scanner.close();
    }

    // Method for finding a book by Name or ISBN
    public static void UserOptionOne(Scanner scanner, Inventory[] inventories) {
        System.out.println("Find a Book by [ Name | ISBN ]? ");
        String UserAnswer = scanner.nextLine();

        if (UserAnswer.equalsIgnoreCase("Name")) {
            System.out.println("Enter the name of the book: ");
            String BookName = scanner.nextLine();

            Inventory inventory = Inventory.SearchBookByName(BookName, inventories);
            if(inventory==null){
                System.out.println("Book not found");
                return;
            }
            System.out.println(inventory.getBook());
            System.out.println("Book Quantity= "+ inventory.getQuantity());
        }
        else if (UserAnswer.equalsIgnoreCase("ISBN")) {
            System.out.println("Enter the ISBN of the book: ");
            String BookISBN = scanner.nextLine();

            Inventory inventory = Inventory.SearchBookByISBN(BookISBN, inventories);
            if(inventory==null){
                System.out.println("Book not found");
                return;
            }
            System.out.println(inventory.getBook());
            System.out.println("Book Quantity= "+ inventory.getQuantity());
        }
        else {
            System.out.println("Invalid input! Choose 'Name' or 'ISBN'.");
        }
    }

    // Method for adding a book to the cart, with a loop to allow adding multiple books
    public static void UserOptionTwo(Scanner scanner, Inventory[] inventories) {

        System.out.println("Enter the ISBN of the Book to add it to the cart...");
        String BookISBN = scanner.nextLine();

        // Find the book by ISBN
        Inventory inventory = Inventory.SearchBookByISBN(BookISBN,inventories);
        if(inventory==null){
            System.out.println("Book not found");
            return;
        }
        System.out.println(inventory);

        // Add book to the Cart
        Cart cart = Cart.getInstance();
        cart.addBookToCart(inventory.getBook());

        System.out.println("Book Added to the Cart!");
        System.out.println(cart);

        // Recursion
        System.out.println("Do you want to add more books? (y/n)");
        String AnswerAddMore = scanner.nextLine();
        if (AnswerAddMore.equals("y")) {
            UserOptionTwo(scanner, inventories);
        }
    }

    //Todo get the cart books and inventory books and reduce the amount 
    public static void UserOptionThree(Scanner scanner,Inventory[] inventories) {
        System.out.println("Are you sure you want to Checkout? (y/n)");
        String UserCheckout = scanner.nextLine();

        if (UserCheckout.equals("y")) {

            if (Cart.getSize() > 0) {
                System.out.println("Total Price= " + Cart.totalPrice());
                Cart.displayCart();

                // Access books in the cart, then reduce the corresponding quantity in inventory
                Inventory.ReduceQuantity(Cart.getBook(), inventories);

                //For loop to print the inventory quantities -> For check
                for (int i = 0; i < 5; i++) {
                    System.out.println(inventories[i]);
                }

                //Clear Cart
                Cart.clearCart();
                System.out.println("Your Cart has been checked out!");
            } else {
                System.out.println("Your Cart is empty!");
            }
        }
        }
    }
