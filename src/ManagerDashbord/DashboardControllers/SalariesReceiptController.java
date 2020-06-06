package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXTextField;
import extras.Employee;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SalariesReceiptController  implements Initializable {
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmployeeCode;
    public JFXTextField txtNationalCode;
    public JFXTextField txtJob;
    public JFXTextField txtLevel;
    public JFXTextField txtWorkTime;
    public JFXTextField txtOverTimeSalary;
    public JFXTextField txtDeducatedSalary;
    public JFXTextField txtBaseSalary;
    public JFXTextField txtExperienceSalary;
    public JFXTextField txtFinalSalary;
    private Employee employee ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
           employee = ManagerSalaryPaneController.employee;
           txtFirstName.setText(employee.getName());
           txtLastName.setText(employee.getLastName());
           txtEmployeeCode.setText(employee.getEmployeeNumber()+"");
           txtNationalCode.setText(employee.getEmployeeType().toString());
           txtLevel.setText(employee.getEmployeeLevel());
           txtWorkTime.setText("");
           txtBaseSalary.setText(employee.getBaseSalary()+"");
         //  txtOverTimeSalary.setText();
         //  txtFinalSalary.setText();
        //TODO setting information to Receipt


    }
}
