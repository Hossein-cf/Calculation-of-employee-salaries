package EmployeeDashboard.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import extras.DBHelper;
import extras.Employee;
import extras.SalaryInformation;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {
    public JFXTimePicker EnterTime;
    public JFXTimePicker ExitTime;
    public JFXButton btnConfirm;
    public DatePicker date;

    private Employee employee;


    public void ConfirmAttendance() {
        System.out.println(EnterTime.getValue());
        SalaryInformation salaryInformation = employee.getSalaryInformation();
        if (salaryInformation.isAfternoonWork()) {
            double hours = salaryInformation.getAfternoonWorkDays();
            LocalTime enter = EnterTime.getValue();
            LocalTime exit = ExitTime.getValue();
            hours += sumHour(enter, exit, hours);
            salaryInformation.setAfternoonWorkDays(hours);
        }
        if (salaryInformation.isFullTime()) {
            double hours = salaryInformation.getFullTimeWorksDays();
            LocalTime enter = EnterTime.getValue();
            LocalTime exit = ExitTime.getValue();
            hours += sumHour(enter, exit, hours);
            salaryInformation.setFullTimeWorksDays(hours);
        }

        if (salaryInformation.isMorningWork()) {
            double hours = salaryInformation.getMorningWorkDays();
            LocalTime enter = EnterTime.getValue();
            LocalTime exit = ExitTime.getValue();
            hours += sumHour(enter, exit, hours);
            salaryInformation.setMorningWorkDays(hours);
        }
        if (salaryInformation.isNightWork()) {
            double hours = salaryInformation.getMorningWorkDays();
            LocalTime enter = EnterTime.getValue();
            LocalTime exit = ExitTime.getValue();
            hours += sumHour(enter, exit, hours);
            salaryInformation.setMorningWorkDays(hours);
        }

        new DBHelper().updateEmployee(employee);

    }

    private double sumHour(LocalTime enter, LocalTime exit, double last) {
        int resultHour = 0;
        int enterHour = enter.getHour();
        int enterMinute = enter.getMinute();
        int exitHour = exit.getHour();
        int exitMinute = exit.getMinute();
        int resultMinute = exitMinute - enterMinute;
        if (resultMinute < 0) {
            --exitHour;
            resultMinute += 60;
        }
        if (exitHour <= 12 && enterHour > 12) {
            resultHour += (24 - enterHour + exitHour);
        } else {
            resultHour += (exitHour - enterHour);
        }
        String time = resultHour + "." + resultMinute;
        last += Double.parseDouble(time);
        return last;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employee = EmployeeLoginController.employee;
    }
}
