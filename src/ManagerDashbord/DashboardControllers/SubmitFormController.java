package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import employeeTypes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

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
    public Label lblAlert1;
    public Label lblAlert2;


    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void DonePersonalInfo() {
        if(txtFirstName.getText().equals("")||txtLastName.getText().equals("")||txtFatherName.getText().equals("")||txtNationalCode.getText().equals("")||txtBornPlace.getText().equals("")||bornData.getValue()==null||comboGender.getSelectionModel().getSelectedIndex()==-1||comboLevelOfEduction.getSelectionModel().getSelectedIndex()==-1||txtAddress.getText().equals("")||txtPostalCode.getText().equals("")||txtPhoneNumber.getText().equals("")){
            alert("Fill the blanks",lblAlert1,"red");
        }


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

    public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[ا-ی-ن]") || e.getCharacter().matches("[ ]")) {
                } else {
                    e.consume();
                }
            }
        };
    }

    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[0-9.]")) {
                    if (txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                        e.consume();
                    } else if (txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                        e.consume();
                    }
                } else {
                    e.consume();
                }
            }
        };
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        txtFirstName.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtLastName.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtLastName.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtFatherName.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtNationalCode.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        txtBornPlace.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtAddress.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtPostalCode.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));
        txtPhoneNumber.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(10));
        txtLastCompanyName.addEventFilter(KeyEvent.KEY_TYPED, letter_Validation(15));






        setTableEmployeeSpecialties();
        String[] LevelOfEduction = {"Diploma", "Bachelor", "MA"};
        String[] Gender = {"Male", "FeMale"};
        String[] WorkExperience = {"does not have", "Under one year", "Over a year", "More than four years"};
        comboLevelOfEduction.getItems().addAll(LevelOfEduction);
        comboGender.getItems().addAll(Gender);
        comboExperience.getItems().addAll(WorkExperience);

    }
}
