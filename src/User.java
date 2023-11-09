

import java.util.Date;
public class User {
    private String username;
    private int uid;
    private Book[] borrowedBooks;
    private Date[] borrowedDates;
    private int borrowedCount;

    public User(String username, int uid) {
        this.username = username;
        this.uid = uid;
        this.borrowedBooks = new Book[10];
        this.borrowedDates = new Date[10];
        this.borrowedCount = 0;
    }
   

    public String getUsername() {
        return username;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public Date[] getBorrowedDates() {
        return borrowedDates;
    }

    public int getUid()
    {
        return uid;
    }

    public void addBorrowedBook(Book book, Date borrowedDate) {
        if (borrowedCount < borrowedBooks.length) {
            borrowedBooks[borrowedCount] = book;
            borrowedDates[borrowedCount] = borrowedDate;
            borrowedCount++;
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + username + ":");
        for (int i = 0; i < borrowedCount; i++) {
            borrowedBooks[i].display();
        }
    }

    public void returnBorrowedBook(Book book, Date returnDate) {
        int fineDays = calculateFineDays(book, returnDate);

        if (fineDays > 0) {
            System.out.println("Fine for overdue: Rs. " + fineDays * 2);
        }

        
        book.returnBook();

       
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].getIsbn().equals(book.getIsbn())) {
                borrowedBooks[i] = null;
                borrowedDates[i] = null;
                break;
            }
        }
    }

    private int calculateFineDays(Book book, Date returnDate) {
        Date borrowedDate = null;

        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].getIsbn().equals(book.getIsbn())) {
                borrowedDate = borrowedDates[i];
                break;
            }
        }

        if (borrowedDate != null) {
            long diff = returnDate.getTime() - borrowedDate.getTime();
            return (int) (diff / (24 * 60 * 60 * 1000)) - 10;
        }

        return 0;
    }
}

