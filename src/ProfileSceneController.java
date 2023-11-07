import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.Initializable;



public class ProfileSceneController implements Initializable {

    @FXML
    private TableView<?> bookTableView;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> isbnColumn;

    @FXML
    private TextField isbnTextField;

    @FXML
    private Button ProfiletoLoginBtn;

    @FXML
    private Button ProfileToHomeBtn;

    @FXML
    private Button ReturnBookBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize your scene elements or handle initial setup here
        // You can bind data, set up listeners, or any other initialization.
        // For example:
        // nameColumn.setCellValueFactory(...);
        // isbnColumn.setCellValueFactory(...);
    }

    @FXML
    public void goToLogin(ActionEvent event) {
        // Define actions when the "Back To Login" button is clicked
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
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

    @FXML
    public void backToHome(ActionEvent event) {
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

    @FXML
    public void returnBook() {
        // Define actions when the "Return Book" button is clicked
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Book Return");
        alert.setHeaderText(null);
        alert.setContentText("Book Successfully Returned");
        alert.show();
    }
}

