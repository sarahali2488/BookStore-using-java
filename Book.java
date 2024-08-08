public class Book {
    private final double price;
    private int quantity;
    private final String Author;
    private final String Name;
    public String ISBN;
    public Book book;
    public String Title;

    public Book(String name, String author, double price, int quantity, String ISBN){
        this.Name= name;
        this.Author = author;
        this.price = price;
        this.quantity = quantity;
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return Author;
    }

    public String getName(){
        return Name;
    }

    public void displayBookInfo(){
        System.out.println("Book Name: " + Name
                + "\nAuthor: " + Author
                + "\nprice: " + price
                + "\nQuantity: " + quantity
                + "\nISBN: " + ISBN);
    }

    public String getISBN(){
        return ISBN;
    }

    @Override
    public String toString() {
        return Title; // Return the book's title
    }
}
