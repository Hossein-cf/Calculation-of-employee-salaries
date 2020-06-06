package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import extras.DBHelper;
import extras.Employee;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.time.LocalTime;

import java.time.LocalTime;

public class DailyRecordsController {


    public TextField txtEmployeeCode;
    public JFXButton btnSearchEmployee;
    public TextArea txtDescribeEmployee;
    public Pane RecordSalaryPane;

    public JFXButton btnConfirm;

    public JFXCheckBox checkAbsent;
    public JFXTimePicker TPWorkingTimeStart;
    public JFXTimePicker TPWorkingTimeEnd;
    public JFXTimePicker TPOverTimeStart;
    public JFXTimePicker TPVacationStart;
    public JFXTimePicker TPOverTimeEnd;
    public JFXTimePicker TPVacationEnd;
    public JFXDatePicker chooseDateForDailyRecords;
    public JFXCheckBox overTimeCheck;
    public JFXCheckBox LeaveCheck;
    public Label lblAlertSearch;
    public Label lblAlertConfirm;
    private Employee employee;

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void searchEmployee() {

        employee = new DBHelper().selectEmployee(Long.parseLong(txtEmployeeCode.getText()));
        //TODO set personal info to txtDescribeEmployee
        //TODO check null or not employee object
    }

    public void Confirm() {

        if (checkAbsent.isSelected()) {
            int absence = employee.getSalaryInformation().getAbsenceDays();
            ++absence;
            employee.getSalaryInformation().setAbsenceDays(absence);
            new DBHelper().updateEmployee(employee);

        } else {
            if (overTimeCheck.isSelected()) {
                LocalTime start = TPOverTimeStart.getValue();
                LocalTime end = TPOverTimeEnd.getValue();
                double last = employee.getSalaryInformation().getOverWorkTime();
                last += sumHour(start, end, last);
                employee.getSalaryInformation().setOverWorkTime(last);
                new DBHelper().updateEmployee(employee);

            }
            if (LeaveCheck.isSelected()) {
                LocalTime start = TPVacationStart.getValue();
                LocalTime end = TPVacationEnd.getValue();
                double last = employee.getSalaryInformation().getOverWorkTime();
                last += sumHour(start, end, last);
                employee.getSalaryInformation().setOverWorkTime(last);
                new DBHelper().updateEmployee(employee);
            }
        }


        alert("Done",lblAlertConfirm,"green");
    }

    public void checkAbsence() {

        if (checkAbsent.isSelected()) {
            overTimeCheck.setDisable(true);
            LeaveCheck.setDisable(true);

            TPOverTimeStart.setVisible(false);
            TPOverTimeEnd.setVisible(false);

            TPVacationStart.setVisible(false);
            TPVacationEnd.setVisible(false);

        } else {
            overTimeCheck.setDisable(false);
            LeaveCheck.setDisable(false);

        }
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

    public void overTimeShow(MouseEvent mouseEvent) {
        if (overTimeCheck.isSelected()) {
            TPOverTimeStart.setVisible(true);
            TPOverTimeEnd.setVisible(true);
        } else {
            TPOverTimeStart.setVisible(false);
            TPOverTimeEnd.setVisible(false);
        }
    }

    public void leaveShow(MouseEvent mouseEvent) {
        if (LeaveCheck.isSelected()) {
            TPVacationStart.setVisible(true);
            TPVacationEnd.setVisible(true);
        } else {
            TPVacationStart.setVisible(false);
            TPVacationEnd.setVisible(false);
        }


    }
}
