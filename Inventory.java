public class Inventory {
    private static Book book;
    private static int quantity;

    public Inventory(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public static Book getBook() {
        return book;
    }

    public static int getQuantity() {
        return quantity;

    }

    public static void setQuantity(int quantity) {
        Inventory.quantity = quantity;
    }

    public static void StoreBooksInInventory(Book[] books, int[] quantities, Inventory[] inventories){
        for (int i = 0; i < books.length; i++) {
            inventories[i] = new Inventory(books[i], quantities[i]);
        }
    }

    public static void DisplayInventory(Inventory[] inventories){
        for (Inventory inventory : inventories) {
            System.out.println(inventory);
        }
    }

    public static void ReduceQuantity(Book book, Inventory[] inventories) {
        for (Book cartBook : Cart.getBooksList()) {
            for (Inventory inventoryBook : inventories) {
                assert Cart.getBook() != null;
                if (Inventory.getBook().getISBN().equals(Cart.getBook().getISBN())) {
                    Inventory.setQuantity(Inventory.getQuantity()-1); //Todo for specific book not all books
                    break; // Exit the inner loop once the match is found and quantity is reduced
                }
            }
        }
    }

    public static Inventory SearchBookByName(String NAME, Inventory[] inventories){
        for(Inventory inventory : inventories){
            if(getBook().getName().equals(NAME)){
                return inventory;
            }
        }
        return null;
    }

    public static Inventory SearchBookByISBN(String ISBN, Inventory[] inventories){
        for(Inventory inventory : inventories){
            if(getBook().getISBN().equals(ISBN)) {
                return inventory;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "book=" + book +
                ", quantity=" + quantity +
                '}';
    }
}
