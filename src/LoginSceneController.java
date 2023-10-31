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

public class LoginSceneController implements Initializable {

    @FXML
    private Button LoginBtn;
    @FXML
    private TextField loginCred;
    //private Button LoginCloseBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize code here if needed
    }

     @FXML
    public void goToHome(ActionEvent event) {
        // Load the FXML file for MainScene
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
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
         System.out.println("User input: " + userInput); // Print the input (you can handle it as needed)
        
    }
}


// //


// class user{
//     String name;
//     int uid;

//     user(String name, int uid){
//         this.name = name;
//         this.uid = uid;
//     }
// }


// public class Input extends user {

//     public static <T> void credentials(T id, user u[])  {
//         int in = -1;
//         if (id instanceof Integer) {
//             int regid = (Integer) id;
//             for(int i=0;i<3;i++){
//                 if (regid == u[i].uid){
//                     in = i;
//                     break;
//                 }
//             }
//         }
//          else if (id instanceof String) {
//             String name = (String) id;
        
//             for(int i=0;i<3;i++){
//                 if(u[i].name.toLowerCase().contains(name.toLowerCase())){
//                     in = i;
//                     break;
//                 }
//             }
//         } 
//         else {
//             System.out.println("Invalid input type");
//         }
//         if(in != -1) 
//         System.out.println("Welcome back, "+u[in].name +"!");
//     }

//     public static void main(String[] args) {
//         user u[]= new user[]{
//             new user("dog", 123);
//             new user("cat", 356);
//             new user("cow", 678);
//         }
//         System.out.println("Enter name or UID: ");
//         Scanner sc = new Scanner(System.in);
//         if(sc.hasNextInt()){
//             int regid = sc.nextInt();
//         credentials(regid, u);
//         }
//         else{
//             String name = sc.nextLine();
//             credentials(name, u);
//         }
//     }
// }



/*public  static void borrow(int i){

    inventory[i]=inventory[i]-1;

}

public  static void intreturn(int i){
    inventory[i]=inventory[i]+1;    
}*/
