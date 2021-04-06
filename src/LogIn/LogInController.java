package LogIn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import utils.ConnectionUtil;


public class LogInController implements Initializable {

    @FXML
    private Label lblErrors;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnSignUp;

    @FXML
    private StackPane parentContainer;




    @FXML
    public void handleButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignIn) {
            //login here

            if (logIn().equals("Success")) {

                try {

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setMaximized(true);
                    stage.close();


                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Home.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }


            }
        }


    }


    @FXML
    public void SignUpButtonAction(MouseEvent event) {

        if (event.getSource() == btnSignUp) {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                Scene scene = btnSignUp.getScene();

                root.translateYProperty().set(scene.getHeight());
                parentContainer.getChildren().add(root);

                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
                timeline.getKeyFrames().add(kf);
                timeline.play();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // To do

    }


    public LogInController() {

        con = ConnectionUtil.conDB();

        // if you remove this the null becomes active below.
        // Also this is the method which gives the connection to the database.
    }

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    //will use string to know the status.

    private String logIn() {

        String Email = txtUsername.getText();
        String Password = txtPassword.getText();


        String sql = "SELECT * FROM clients.customers WHERE Email =? AND Password =?";

        try {

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, Email);
            preparedStatement.setString(2, Password);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {

                lblErrors.setTextFill(Color.TOMATO);
                lblErrors.setText("Incorrect Username or Password");
                System.err.println("Wrong Credentials");
                return "Error";


            } else {


                lblErrors.setTextFill(Color.GREEN);
                lblErrors.setText("Successful Log in");
                System.out.println("Successful");
                return "Success";

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }



}

