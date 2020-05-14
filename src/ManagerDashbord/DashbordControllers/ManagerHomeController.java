package ManagerDashbord.DashbordControllers;

import ManagerDashbord.DashBordNewController;
import ManagerDashbord.ManagerLoginController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManagerHomeController implements Initializable {

    public Label lblCompanyName;
    public Label lblCompanyType;
    private ManagerLoginController managerLoginController;
    public void settingCompanyName(String CompanyName, String CompanyType) {

        lblCompanyName.setText(CompanyName);
        lblCompanyType.setText(CompanyType);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerLoginController =  new ManagerLoginController();
        settingCompanyName(managerLoginController.CName, managerLoginController.CType);
    }
}
