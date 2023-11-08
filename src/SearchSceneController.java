import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;



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
    public void goToHome(ActionEvent event) {
        System.out.println("Back to Home button clicked");
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
            Scene profilePageScene = new Scene(loader);
            Stage appStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            loader.setOnMousePressed(mouseEvent -> {
                appStage.setUserData(new double[]{mouseEvent.getSceneX(), mouseEvent.getSceneY()});
            });

            loader.setOnMouseDragged(mouseEvent -> {
                double[] data = (double[]) appStage.getUserData();
                appStage.setX(mouseEvent.getScreenX() - data[0]);
                appStage.setY(mouseEvent.getScreenY() - data[1]);
            });

            appStage.setScene(profilePageScene);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
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
