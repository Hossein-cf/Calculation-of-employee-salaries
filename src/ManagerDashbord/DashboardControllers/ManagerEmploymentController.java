package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import employeeTypes.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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

    public void loadForm() {
        if (comboEmployeeType.getSelectionModel().getSelectedIndex() == -1 || comboWorkTime.getSelectionModel().getSelectedIndex() == -1 || comboEmployeeLevel.getSelectionModel().getSelectedIndex() == -1) {


        } else {
            String EmployeeType = comboEmployeeType.getValue().toString();
            String EmployeeLevel = comboEmployeeLevel.getValue().toString();
            String WorkTime = comboWorkTime.getValue().toString();


            try {
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Employment/SubmitPane.fxml"));
                loadAnchorPane.getChildren().addAll(anchorPane);
            } catch (IOException ex) {
                System.out.println("Problem in loading");
            }
        }

    }
    private void setTableEmployeeSpecialties(String employeeType){
        if (employeeType.equals("Database Expert")){
            DBExpert dbExpert = new DBExpert();
        }else if (employeeType.equals("NetWork Security Expert")){
            NetworkSecurityExpert networkSecurityExpert = new NetworkSecurityExpert();
        }else if (employeeType.equals("Full Stack")){
            FullStack fullStack = new FullStack();

        }else if(employeeType.equals("Back-end")){
            BackEnd backEnd = new BackEnd();

        }else if (employeeType.equals("Front-end")){
            FrontEnd frontEnd = new FrontEnd();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] employeeType = {"Database Expert", "NetWork Security Expert", "Full Stack", "Back-end", "Front-end"};
        String[] levels = {"Junior", "Mid-level", "Senior"};
        String[] workTime = {"full time", "Morning Work", "afternoon Work", "night work"};
        comboEmployeeType.getItems().addAll(employeeType);
        comboEmployeeLevel.getItems().addAll(levels);
        comboWorkTime.getItems().addAll(workTime);
    }
}
