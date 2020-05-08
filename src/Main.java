import employeeTypes.EmployeeType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./loginPages/MainLogin.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 536, 383));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.show();
    }


    public static void main(String[] args) {
//        System.out.println(EmployeeType.BackEnd.getValue());
        launch(args);
    }
}
