import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

class user{
    String name;
    int uid;

    user(String name, int uid){
        this.name = name;
        this.uid = uid;
    }
}

public class LoginSceneController extends user implements Initializable{

    @FXML
    private Button LoginBtn;
    @FXML
    private TextField loginCred;
    //private Button LoginCloseBtn
    public LoginSceneController() {
        super("", 0); // Invoke user's constructor with default or placeholder values
    }


    LoginSceneController(String name, int uid)
    {
        super(name,uid);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize code here if needed
    }

     @FXML
    public void goToHome(ActionEvent event) {
        // Load the FXML file for MainScene
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
            Scene LoginPageScene = new Scene(loader);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            appStage.setScene(LoginPageScene);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
    }

    @FXML
    public void closeLogin(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void LoginFunc(ActionEvent event) {
         String userInput = loginCred.getText(); // Retrieve the text from the TextField
         System.out.println("User input: " + userInput);

            user u[]= new user[]{
            new user("dog", 123),
            new user("cat", 356),
            new user("cow", 678),
        };
         
        int regid;
        
            try{
                regid = Integer.parseInt(userInput);
                credentials(regid, u);
            }catch(NumberFormatException e){
                credentials(userInput,u);
        }// Print the input (you can handle it as needed)

        try {
            Parent loader = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
            Scene LoginPageScene = new Scene(loader);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            appStage.setScene(LoginPageScene);
            appStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
        
    }

        public static <T> void credentials(T id, user u[])  {
        int in = -1;
        if (id instanceof Integer) {
            int regid = (Integer) id;
            for(int i=0;i<3;i++){
                if (regid == u[i].uid){
                    in = i;
                    break;
                }
            }
        }
         else if (id instanceof String) {
            String name = (String) id;
        
            for(int i=0;i<3;i++){
                if(u[i].name.toLowerCase().contains(name.toLowerCase())){
                    in = i;
                    break;
                }
            }
        } 
        else {
            System.out.println("Invalid input type");
        }
        if(in != -1) 
        System.out.println("Welcome back, "+u[in].name +"!");
    }
}


