package ManagerDashbord.DashbordControllers;

import ManagerDashbord.DashBordNewController;
import com.jfoenix.controls.JFXButton;
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

    public void loadForm(){
        if(comboEmployeeType.getSelectionModel().getSelectedIndex()==-1||comboWorkTime.getSelectionModel().getSelectedIndex()==-1||comboEmployeeLevel.getSelectionModel().getSelectedIndex()==-1){


        }
        else {


            try {
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashbordFXMLs/Employment/SubmitPane.fxml"));
                loadAnchorPane.getChildren().addAll(anchorPane);
            } catch (IOException ex) {
                System.out.println("Problem in loading");
            }
        }

   }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] employeeType ={"Data base Expert","NetWork Security Expert" , "Full Stack","Back-end","front-end"};
        String[] levels ={"Junior","Mid-level","Senior"};
        String[] workTime ={"full time" , "Morning Work" , "afternoon Work" ,"night work"};
        comboEmployeeType.getItems().addAll(employeeType);
        comboEmployeeLevel.getItems().addAll(levels);
        comboWorkTime.getItems().addAll(workTime);
    }
}
