package ManagerDashbord.DashboardControllers;

import ManagerDashbord.DashBordNewController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ManagerSalaryPaneController  {
    public TextField txtEmployeeCode;
    public JFXButton btnSearchEmployee;
    public TextArea txtDescribeEmployee;
    public Pane finalSalaryPane;
    public TextField txtOverTimeHour;
    public TextField txtVacationHour;
    public TextField txtAbsenceDays;
    public TextArea txtDescribeMission;
    public JFXCheckBox checkDoingMission;
    public JFXButton btnCalculateFinalSalary;
    public JFXDatePicker dateOfIssuance;
    public AnchorPane loadAnchorPane;
    private DashBordNewController dashBordNewController ;


    public void searchEmployee(){
        //TODO search and set information of employee

        finalSalaryPane.setVisible(true);
    }

    public void loadSalaryReceipt(){

        try {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Salary/SalariesReceipt.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }

        //TODO write Receipt to data base



    }


    public void DoingMission(MouseEvent mouseEvent) {

        if(checkDoingMission.isSelected()) txtDescribeMission.setDisable(false);
        else txtDescribeMission.setDisable(true);

    }
}
