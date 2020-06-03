package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import employeeTypes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    public TableView tblSpecialties;

    public void DonePersonalInfo() {


    }

    public void DoneExperienceTime() {


    }

    public void checkTheFinalStatus() {


    }

    public void setTableEmployeeSpecialties() {

        String employeeType = ManagerEmploymentController.getEmployeeType();
        if (employeeType.equals(EmployeeType.DBExpert.toString())) {
            DB_Expert[] db_experts = DB_Expert.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < db_experts.length; i++) {
                observableList.add(new TableFormat(db_experts[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);
        } else if (employeeType.equals(EmployeeType.NetworkSecurityExpert.toString())) {
            Network_Security[] network_securities = Network_Security.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < network_securities.length; i++) {
                observableList.add(new TableFormat(network_securities[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);


        } else if (employeeType.equals(EmployeeType.FullStack.toString())) {
            Full_Stack[] full_stacks = Full_Stack.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < full_stacks.length; i++) {
                observableList.add(new TableFormat(full_stacks[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);
        } else if (employeeType.equals(EmployeeType.BackEnd.toString())) {
            Back_End[] back_ends = Back_End.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < back_ends.length; i++) {
                observableList.add(new TableFormat(back_ends[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);

        } else if (employeeType.equals(EmployeeType.FrontEnd.toString())) {
            Front_End[] front_ends = Front_End.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < front_ends.length; i++) {
                observableList.add(new TableFormat(front_ends[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTableEmployeeSpecialties();
        String[] LevelOfEduction = {"Diploma", "Bachelor", "MA"};
        String[] Gender = {"Male", "FeMale"};
        String[] WorkExperience = {"does not have", "Under one year", "Over a year", "More than four years"};
        comboLevelOfEduction.getItems().addAll(LevelOfEduction);
        comboGender.getItems().addAll(Gender);
        comboExperience.getItems().addAll(WorkExperience);

    }
}
