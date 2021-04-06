
package LogIn;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;




public class mainController implements Initializable {




    public void signUpButtonPushed (ActionEvent event) throws IOException{

        Parent registerSceneParent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene registerScene = new Scene(registerSceneParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }

    public void facebookButtonPushed(ActionEvent event) throws IOException{

        // coming soon
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
