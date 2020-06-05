package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import extras.DBHelper;
import extras.Employee;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    private Employee employee;

    public void searchEmployee() {

        employee =new DBHelper().selectEmployee(Long.parseLong(txtEmployeeCode.getText()));
        //TODO set personal info to txtDescribeEmployee

    }

    public void Confirm() {


    }

    public void checkAbsence() {

        if (checkAbsent.isSelected()) {
            overTimeCheck.setDisable(true);
            LeaveCheck.setDisable(true);

        } else {
            overTimeCheck.setDisable(false);
            LeaveCheck.setDisable(false);

        }
    }


    public void overTimeShow(MouseEvent mouseEvent) {
        if(overTimeCheck.isSelected()) {
            TPOverTimeStart.setVisible(true);
            TPOverTimeEnd.setVisible(true);
        }
        else {
            TPOverTimeStart.setVisible(false);
            TPOverTimeEnd.setVisible(false);
        }
    }

    public void leaveShow(MouseEvent mouseEvent) {
        if(LeaveCheck.isSelected()) {
            TPVacationStart.setVisible(true);
            TPVacationEnd.setVisible(true);
        }
        else {
            TPVacationStart.setVisible(false);
            TPVacationEnd.setVisible(false);
        }


    }
}
