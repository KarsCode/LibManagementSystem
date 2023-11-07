import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class SearchSceneController {

    @FXML
    private TableView<Book> tableView;

    @FXML
    private TextField isbnTextField;

    @FXML
    private TableColumn<Book, String> name;
    @FXML
    private TableColumn<Book, String> author;
    @FXML
    private TableColumn<Book, String> isbn;
    @FXML
    private TableColumn<Book, String> genre;
    @FXML
    private TableColumn<Book, String> inventory;


    // Method triggered when Borrow button is clicked
    @FXML
    public void BorrowBook() {
        String isbn = isbnTextField.getText();
        // Implement borrowing logic here using the entered ISBN code
        System.out.println("Borrow button clicked with ISBN: " + isbn);
        // Perform borrowing actions here
    }

    // Method triggered when Back To Home button is clicked
    @FXML
    public void goToHome() {
        System.out.println("Back to Home button clicked");
        // Perform actions to navigate back to the home view
    }

     ObservableList<Book> bookList = FXCollections.observableArrayList(
                new Book("Book1", "Author1", "Fiction", "ISBN001", 10),
                new Book("Book2", "Author2", "Non-Fiction", "ISBN002", 15),
                new Book("Book3", "Author3", "Science", "ISBN003", 20)
        );

    @FXML
    public void initialize() {
       
        //Add dummy data to the table
    
    if (tableView != null && name != null) {
        //name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        author.setCellValueFactory(new PropertyValueFactory<>("author"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        inventory.setCellValueFactory(new PropertyValueFactory<>("inventory"));
        tableView.setItems(bookList);
    }
       
       

        
    }
}
