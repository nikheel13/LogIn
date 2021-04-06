
package LogIn;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.ConnectionUtil;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class signUpController implements Initializable {

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtFN;

    @FXML
    private TextField txtLN;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPass;

    @FXML
    private PasswordField txtPassVal;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private Label emailError;

    @FXML
    private Label passValError;

    @FXML
    private Label fnError;

    @FXML
    private Label lnError;

    @FXML
    private Label passError;

    @FXML
    private Label dobError;





    PreparedStatement preparedStatement;
    Connection connection;






    public signUpController(){

        connection = (Connection) ConnectionUtil.conDB();


    }



    @Override

    public void initialize (URL url, ResourceBundle rb){

        //TO DO!!!

    }


    @FXML
    private void registerButtonAction (MouseEvent event){

        String First_Name = txtFN.getText();
        String Last_Name = txtLN.getText();
        String Email = txtEmail.getText();
        String Password = String.valueOf(txtPass.getText());
        String DOB = dateOfBirth.getValue().toString();


        if(First_Name.equals("")){

            fnError.setTextFill(Color.TOMATO);
            fnError.setText("*");

        } else if(Last_Name.equals("")){

            lnError.setTextFill(Color.TOMATO);
            lnError.setText("*");

        } else if(Email.equals("")){

            emailError.setTextFill(Color.TOMATO);
            emailError.setText("*");

        } else if(Password.equals("")){

            passError.setTextFill(Color.TOMATO);
            passError.setText("*");

        } else if(!Password.equals(txtPassVal)) {

            passValError.setTextFill(Color.GREEN);
            passValError.setText("User ADDED!");

        } else if(dateOfBirth.equals(null)) {

            dobError.setTextFill(Color.TOMATO);
            dobError.setText("ok");
        }



        String query = "INSERT INTO clients.customers(First_Name,Last_Name,Email,Password,DOB) VALUES (?,?,?,?,?)";


        try {
            preparedStatement = ConnectionUtil.conDB().prepareStatement(query);
            preparedStatement.setString(1,First_Name);
            preparedStatement.setString(2,Last_Name);
            preparedStatement.setString(3,Email);
            preparedStatement.setString(4,Password);
            preparedStatement.setString(5,DOB);

            preparedStatement.executeUpdate();






        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}

