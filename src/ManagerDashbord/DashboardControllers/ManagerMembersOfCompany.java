package ManagerDashbord.DashboardControllers;

import ManagerDashbord.ManagerLoginController;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerMembersOfCompany implements Initializable {
    public Label lblFullStackNumber;
    public Label lblSecurityNumber;
    public Label lblFrontNumber;
    public Label lblAppDeveloperNumber;
    public Label lblBackNumber;
    public Label lblDataBaseExNumber;
    public Label lblCname;
    public Label lblCtype;
    private ManagerLoginController managerLoginController ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerLoginController =  new ManagerLoginController();
        lblCname.setText(managerLoginController.CName);
        lblCtype.setText(managerLoginController.CType);


    }
}
