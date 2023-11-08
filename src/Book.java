import java.util.Date;
import java.text.SimpleDateFormat;
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


// class Book {
//     public String name;
//     public String author;
//     public String genre;
//     public String isbn;
//     public int inventory;
//     private Date borrowedDate;

//     Book(String name, String author, String genre, String isbn, int inv) {
//         this.name = name;
//         this.author = author;
//         this.genre = genre;
//         this.isbn = isbn;
//         inventory = inv;
//         borrowedDate = null;
//     }

//     synchronized void display() {
//         SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//         System.out.println("Book name: " + name);
//         System.out.println("Book author: " + author);
//         System.out.println("Book genre: " + genre);
//         System.out.println("Book isbn code: " + isbn);
//         System.out.println("No. of books left: " + inventory);
//         if (borrowedDate != null) {
//             System.out.println("Borrowed on: " + dateFormat.format(borrowedDate));
//         }
//         System.out.println();
//     }

//     public synchronized boolean borrowBook(User user) {
//         if (inventory > 0) {
//             inventory--;
//             borrowedDate = new Date();
//             user.addBorrowedBook(this, borrowedDate);
//             return true;
//         }
//         return false;
//     }

//     public void returnBook() {
//         inventory++;
//         borrowedDate = null;
//     }

//     public String getIsbn() {
//         return isbn;
//     }
// }