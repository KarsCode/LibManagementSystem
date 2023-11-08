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

public class LoginSceneController implements Initializable{

    @FXML
    private Button LoginBtn;
    @FXML
    private TextField loginCred;
    //private Button LoginCloseBtn
    // public LoginSceneController() {
    //     super("", 0); // Invoke user's constructor with default or placeholder values
    // }


    // LoginSceneController(String name, int uid)
    // {
    //     super(name,uid);
    // }

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
         int regid;
         User user = null;

         
    
        
            try{
                regid = Integer.parseInt(userInput);
                 user = credentials(regid, UserDatabase.users);
            }catch(NumberFormatException e){
                user = credentials(userInput,UserDatabase.users);
        }// Print the input (you can handle it as needed)

        try {
            
            if(user!=null)
            {
                AppData.getInstance().setCurrentUser(user);
            }
            Parent loader = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
            Scene LoginPageScene = new Scene(loader);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            loader.setOnMousePressed(mouseEvent -> {
                appStage.setUserData(new double[]{mouseEvent.getSceneX(), mouseEvent.getSceneY()});
            });
    
            loader.setOnMouseDragged(mouseEvent -> {
                double[] data = (double[]) appStage.getUserData();
                appStage.setX(mouseEvent.getScreenX() - data[0]);
                appStage.setY(mouseEvent.getScreenY() - data[1]);
            });
            
            appStage.setScene(LoginPageScene);
            appStage.show();

 
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }
        
    }

    //     public static <T> User credentials(T id, User u[])  {
    //     int in = -1;
    //     if (id instanceof Integer) {
    //         int regid = (Integer) id;
    //         for(int i=0;i<3;i++){
    //             if (regid == u[i].getUid()){
    //                 in = i;
    //                 break;
    //             }
    //         }
    //     }
    //      else if (id instanceof String) {
    //         String name = (String) id;
        
    //         for(int i=0;i<3;i++){
    //             if(u[i].getUsername().toLowerCase().contains(name.toLowerCase())){
    //                 in = i;
    //                 break;
    //             }
    //         }
    //     } 
    //     else {
    //         System.out.println("Invalid input type");
    //         return null;
    //     }
    //     if(in != -1) 
    //     {System.out.println("Welcome back, "+u[in].getUsername() +"!");
    //     return u[in];
    
        
    // }
    // }

    public static <T> User credentials(T id, User[] users) {
        int in = -1;
        if (id instanceof Integer) {
            int regid = (Integer) id;
            for (int i = 0; i < users.length; i++) {
                if (regid == users[i].getUid()) {
                    in = i;
                    break;
                }
            }
        } else if (id instanceof String) {
            String name = (String) id;
    
            for (int i = 0; i < users.length; i++) {
                if (users[i].getUsername().toLowerCase().contains(name.toLowerCase())) {
                    in = i;
                    break;
                }
            }
        } else {
            System.out.println("Invalid input type");
            return null;
        }
    
        if (in != -1) {
            System.out.println("Welcome back, " + users[in].getUsername() + "!");
            return users[in];
        } else {
            return null;
        }
    }
   
    
    
    
    
    
    
}

