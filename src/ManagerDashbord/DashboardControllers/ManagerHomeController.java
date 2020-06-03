package ManagerDashbord.DashboardControllers;

import ManagerDashbord.ManagerLoginController;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
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
