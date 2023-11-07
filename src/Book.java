public class Book {
    private String name;
    private String author;
    private String genre;
    private String isbn;
    private int inventory;

    // Constructor
    public Book(String name, String author, String genre, String isbn, int inventory) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.inventory = inventory;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getInventory() {
        return inventory;
    }
}