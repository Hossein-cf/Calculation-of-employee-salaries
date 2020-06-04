package EmployeeDashboard.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import extras.Employee;
import extras.SalaryInformation;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {
    public JFXTimePicker EnterTime;
    public JFXTimePicker ExitTime;
    public JFXButton btnConfirm;
    public DatePicker date;

    private Employee employee ;


    public void ConfirmAttendance(){
        SalaryInformation salaryInformation = employee.getSalaryInformation();



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employee=EmployeeLoginController.employee;
    }
}
