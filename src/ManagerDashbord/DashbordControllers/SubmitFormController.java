package ManagerDashbord.DashbordControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SubmitFormController implements Initializable {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtFatherName;
    public TextField txtNationalCode;
    public TextField txtBornPlace;
    public DatePicker bornData;
    public TextField txtPhoneNumber;
    public TextField txtAddress;
    public TextField txtPostalCode;
    public JFXButton btnDonePersonalInfo;
    public ComboBox comboLevelOfEduction;
    public ComboBox comboGender;
    public JFXCheckBox gitCheck;
    public JFXCheckBox linuxCheck;
    public JFXCheckBox teleWorkingCheck;
    public JFXButton btnDoneExperience;
    public ComboBox comboExperience;
    public TextField txtLastCompanyName;
    public TableColumn clmRow;
    public TableColumn clmExpertise;
    public TableColumn clmCheckBtn;
    public Label tableViewSpecialties;
    public JFXButton btnCheckTheStatus;
    public Label lbl1;

    public void DonePersonalInfo(){


    }
    public void DoneExperienceTime(){


    }
    public void checkTheFinalStatus(){



    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
