class Search1 implements Runnable { // for book name
    int n;
    int count;
    String s;
    Book book[];
    String[] isbnList;
    Thread t;

    Search1(int n, Book book[], String s) {
        this.n = n;
        this.s = s.toLowerCase();
        count = 0;
        this.book = book;
        isbnList = new String[n];
        t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            synchronized (Book.class) {
                String t1 = book[i].name.toLowerCase();

                if (t1.contains(s)) {
                    book[i].display();
                    isbnList[count] = book[i].getIsbn();
                    count++;
                }
            }
        }
    }
}

class Search2 implements Runnable { // for author name
    int n;
    int count;
    String s;
    Book book[];
    String[] isbnList;
    Thread t;

    Search2(int n, Book book[], String s) {
        this.n = n;
        this.s = s.toLowerCase();
        count = 0;
        this.book = book;
        isbnList = new String[n];
        t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            synchronized (Book.class) {
                String t1 = book[i].author.toLowerCase();

                if (t1.contains(s)) {
                    book[i].display();
                    isbnList[count] = book[i].getIsbn();
                    count++;
                }
            }
        }
    }
}

class Search3 implements Runnable { // for genre
    int n;
    int count;
    String s;
    Book book[];
    String[] isbnList;
    Thread t;

    Search3(int n, Book book[], String s) {
        this.n = n;
        this.s = s.toLowerCase();
        count = 0;
        this.book = book;
        isbnList = new String[n];
        t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            synchronized (Book.class) {
                String t1 = book[i].genre.toLowerCase();

                if (t1.contains(s)) {
                    book[i].display();
                    isbnList[count] = book[i].getIsbn();
                    count++;
                }
            }
        }
    }
}


public class MultiThreadedSearches
{

}