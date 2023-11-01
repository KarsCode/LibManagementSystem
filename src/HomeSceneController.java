import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeSceneController {

    @FXML
    private Text welcomeText;

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private Text searchLabelText;

    @FXML
    private Button HomeToLoginBtn;

    // This method is called when the FXML is initialized
    @FXML
    public void initialize() {
        // You can perform any additional setup here
        // For example, setting the text of components
        welcomeText.setText("Welcome Back User");
    }

    // Define action/event handling methods here
    @FXML
    public void searchAction() {
        // Implement what happens when the search button is clicked
        String searchText = searchField.getText();
        // Add your logic here for handling the search functionality
        System.out.println("Search button clicked with text: " + searchText);
    }

    @FXML
    private void goToLogin(ActionEvent event) {
        
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene HomePageScene = new Scene(loader);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            appStage.setScene(HomePageScene);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }
}