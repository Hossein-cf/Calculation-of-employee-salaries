package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DailyRecordsController {


    public TextField txtEmployeeCode;
    public JFXButton btnSearchEmployee;
    public TextArea txtDescribeEmployee;
    public Pane RecordSalaryPane;
    public TextField txtOverTimeHour;
    public TextField txtVacationHour;
    public JFXButton btnConfirm;
    public TextField txtWorkingTime;
    public JFXCheckBox checkAbsent;


    public void searchEmployee(){





    }
    public void Confirm(){





    }
    public void checkAbsence(){

        if(checkAbsent.isSelected()){
            txtWorkingTime.setDisable(true);
            txtOverTimeHour.setDisable(true);
            txtVacationHour.setDisable(true);
        }
        else {

            txtWorkingTime.setDisable(false);
            txtOverTimeHour.setDisable(false);
            txtVacationHour.setDisable(false);

        }
    }





}
