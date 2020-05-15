package EmployeeDashbord.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeLoginController implements Initializable {


    public TextField txtUserName;
    public TextField txtPassWord;
    public JFXButton btnCheckProfile;
    public JFXButton btnClose;
    public JFXButton btnBack;

    public void loadDashBoard() {
        if(txtUserName.getText().equals("")||txtPassWord.getText().equals("")){


        }

        else {

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
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
