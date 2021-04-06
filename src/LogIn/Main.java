  package LogIn;

  import javafx.application.Application;
  import javafx.fxml.FXMLLoader;
  import javafx.scene.Parent;
  import javafx.scene.Scene;
  import javafx.stage.Stage;

  public class Main extends Application {

      @Override
      public void start(Stage primaryStage) throws Exception{
          Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
          primaryStage.setTitle("N13 Entertainment");
          primaryStage.setScene(new Scene(root, 673, 465));
          primaryStage.show();
      }


      public static void main(String[] args) {
          launch(args);
      }
  }