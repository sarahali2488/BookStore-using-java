public class Book {
    private final double price;
    private final String Author;
    private final String Name;
    public String ISBN;

    public Book(String name, String author, double price, String ISBN){
        this.Name= name;
        this.Author = author;
        this.price = price;
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return Author;
    }

    public String getName(){
        return Name;
    }

    public String getISBN(){
        return ISBN;

    }

    public void displayBookInfo(){
        System.out.println("Book Name: " + Name
                + "\nAuthor: " + Author
                + "\nprice: " + price
                + "\nISBN: " + ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", Author='" + Author + '\'' +
                ", Name='" + Name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}