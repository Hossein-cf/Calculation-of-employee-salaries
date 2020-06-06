package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import extras.employeeTypes.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerEmploymentController implements Initializable {


    public AnchorPane loadAnchorPane;
    public ComboBox comboEmployeeType;
    public ComboBox comboWorkTime;
    public JFXButton btnLoadForm;
    public ComboBox comboEmployeeLevel;
    private static EmployeeType employeeType;
    public static String employeeLevel;
    public static String workTime;

    public static void setEmployeeLevel(String employeeLevel) {
        ManagerEmploymentController.employeeLevel = employeeLevel;
    }

    public static String getEmployeeLevel() {
        return employeeLevel;
    }

    public static void setWorkTime(String workTime) {
        ManagerEmploymentController.workTime = workTime;
    }

    public static String getWorkTime() {
        return workTime;
    }

    public static EmployeeType getEmployeeType() {
        return employeeType;
    }

    public static void setEmployeeType(EmployeeType employeeType) {
        ManagerEmploymentController.employeeType = employeeType;
    }

    public void loadForm() {
        if (comboEmployeeType.getSelectionModel().getSelectedIndex() == -1 || comboWorkTime.getSelectionModel().getSelectedIndex() == -1 || comboEmployeeLevel.getSelectionModel().getSelectedIndex() == -1) {

        } else {
            setEmployeeType(EmployeeType.valueOf(comboEmployeeType.getValue().toString()));
            setEmployeeLevel(comboEmployeeLevel.getValue().toString());
            setWorkTime(comboWorkTime.getValue().toString());
            try {

                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Employment/SubmitPane.fxml"));
                loadAnchorPane.getChildren().addAll(anchorPane);
            } catch (IOException ex) {
                System.out.println("Problem in loading");
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] employeeType = {EmployeeType.DBExpert.toString(), EmployeeType.NetworkSecurityExpert.toString(), EmployeeType.FullStack.toString(), EmployeeType.BackEnd.toString(), EmployeeType.FrontEnd.toString()};
        String[] levels = {"Junior", "Mid-level", "Senior"};
        String[] workTime = {"full time", "Morning Work", "afternoon Work", "night work"};
        comboEmployeeType.getItems().addAll(employeeType);
        comboEmployeeLevel.getItems().addAll(levels);
        comboWorkTime.getItems().addAll(workTime);
    }
}//end
