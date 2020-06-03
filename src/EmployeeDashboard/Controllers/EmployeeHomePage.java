package EmployeeDashboard.Controllers;

import ManagerDashbord.ManagerLoginController;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeHomePage implements Initializable {
    public AnchorPane loadAnchorPane;
    public Pane Pane1;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtJob;
    public JFXTextField txtEmployeeCode;
    public Pane Pane2;
    public JFXTextField txtBaseSalary;
    public JFXTextField txtCompanyName;
    public JFXTextField txtCompanyType;
    public Label lblRecievedSalary;
    private ManagerLoginController managerLoginController;

    public void settingCompanyName(String CompanyName, String CompanyType) {
        txtCompanyName.setText(CompanyName);
        txtCompanyType.setText(CompanyType);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerLoginController =  new ManagerLoginController();
        settingCompanyName(managerLoginController.CName, managerLoginController.CType);

    }
}
