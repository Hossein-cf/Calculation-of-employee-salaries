package EmployeeDashboard.Controllers;

import com.jfoenix.controls.JFXButton;
import extras.DBHelper;
import extras.Employee;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeLoginController implements Initializable {


    public TextField txtUserName;
    public TextField txtPassWord;
    public JFXButton btnCheckProfile;
    public JFXButton btnClose;
    public JFXButton btnBack;

    public void loadDashBoard() {
        DBHelper dbHelper = new DBHelper();

        if (txtUserName.getText().equals("") || txtPassWord.getText().equals("")) {


        } else {
//            Employee employee = dbHelper.selectEmployee(Long.parseLong(txtUserName.getText()));
//            if (employee != null && txtPassWord.getText().equals(employee.getNationalNumber())) {
                Parent root;
                try {
                    Stage stage = (Stage) btnCheckProfile.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/EmployeeDashbord.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//            }else {
//                System.out.println("not found ");
//            }
        }
    }
    public void exit() {

        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to go out ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent())
            if (result.get() == yes)
                System.exit(0);
    }

    public void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to go back to the home screen? ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("WARNING");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == yes) {

                Parent root;
                try {
                    Stage stage = (Stage) btnBack.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../loginPages/MainLogin.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root, 536, 383));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
