package ManagerDashbord.DashboardControllers;

import ManagerDashbord.ManagerLoginController;
import extras.employeeTypes.EmployeeType;
import extras.DBHelper;
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
    private ManagerLoginController managerLoginController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerLoginController = new ManagerLoginController();

        DBHelper dbHelper = new DBHelper();
        int count = 0;
        lblCname.setText(managerLoginController.CName);
        lblCtype.setText(managerLoginController.CType);
        lblBackNumber.setText((count += dbHelper.numberOfEmployeeType(EmployeeType.BackEnd)) + "");
        lblDataBaseExNumber.setText((count += dbHelper.numberOfEmployeeType(EmployeeType.DBExpert)) + "");
        lblFrontNumber.setText((count += dbHelper.numberOfEmployeeType(EmployeeType.FrontEnd)) + "");
        lblFullStackNumber.setText((count += dbHelper.numberOfEmployeeType(EmployeeType.FullStack)) + "");
        lblSecurityNumber.setText((count += dbHelper.numberOfEmployeeType(EmployeeType.NetworkSecurityExpert)) + "");
        lblAppDeveloperNumber.setText(count + "");
    }
}//end
