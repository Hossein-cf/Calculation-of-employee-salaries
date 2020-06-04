package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import employeeTypes.*;
import extras.Employee;
import extras.GenerateEmployeeNumber;
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
    public ComboBox<String> comboLevelOfEduction;
    public ComboBox<String> comboGender;
    public JFXCheckBox gitCheck;
    public JFXCheckBox linuxCheck;
    public JFXCheckBox teleWorkingCheck;
    public JFXButton btnDoneExperience;
    public ComboBox<String> comboExperience;
    public TextField txtLastCompanyName;
    public TableColumn<TableFormat, String> clmRow;
    public TableColumn<TableFormat, String> clmExpertise;
    public TableColumn<TableFormat, String> clmCheckBtn;
    public Label tableViewSpecialties;
    public JFXButton btnCheckTheStatus;
    public Label lbl1;
    public TableView<TableFormat> tblSpecialties;
    private final byte GIT = 1;
    private final byte TELEWORKING = 1;
    private final byte MAC_LINUX = 1;

    private final byte NOT_HAVE = 1;
    private final byte UNDER_ONE_YEAR = 1;
    private final byte OVER_A_YEAR = 1;
    private final byte MORE_THAN_FOUR_YEAR = 1;
    private int Score = 0;
    private Employee employee;

    public Label lblAlert1;
    public Label lblAlert2;


    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void DonePersonalInfo() {
        if (txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtFatherName.getText().equals("") || txtNationalCode.getText().equals("") || txtBornPlace.getText().equals("") || bornData.getValue() == null || comboGender.getSelectionModel().getSelectedIndex() == -1 || comboLevelOfEduction.getSelectionModel().getSelectedIndex() == -1 || txtAddress.getText().equals("") || txtPostalCode.getText().equals("") || txtPhoneNumber.getText().equals("")) {
            alert("Fill the blanks", lblAlert1, "red");
        } else {

            employee.setName(txtFirstName.getText());
            employee.setLastName(txtLastName.getText());
            employee.setFatherName(txtFatherName.getText());
            employee.setNationalNumber(Long.parseLong(txtNationalCode.getText()));
            employee.setBirthTime(bornData.getValue());
            employee.setBirthPlace(txtBornPlace.getText());
            employee.setGender(comboGender.getValue().toString());
            employee.setPostalCode(Long.parseLong(txtPostalCode.getText()));
            employee.setPhoneNumber(Long.parseLong(txtPhoneNumber.getText()));
            employee.setAddress(txtAddress.getText());
            employee.setCertificate(comboLevelOfEduction.getValue().toString());
        }

    }

    public void DoneExperienceTime() {


        if (gitCheck.isSelected()) {
            Score += GIT;
        }
        if (linuxCheck.isSelected()) {
            Score += MAC_LINUX;
        }
        if (teleWorkingCheck.isSelected()) {
            Score += TELEWORKING;
        }
        String experience = comboExperience.getValue();
        employee.setWorkExperience(experience);
        switch (experience) {
            case "does not have":
                Score += NOT_HAVE;
                break;
            case "Under one year":
                Score += UNDER_ONE_YEAR;
                break;
            case "Over a year":
                Score += OVER_A_YEAR;
                break;
            case "More than four years":
                Score += MORE_THAN_FOUR_YEAR;
                break;
        }
    }

    public void checkTheFinalStatus() {

        for (int i = 0; i < tblSpecialties.getItems().size(); i++) {
            TableFormat tableFormat = tblSpecialties.getItems().get(i);
            if (tableFormat.getJfxCheckBox().isSelected()) {
                Score += EmployeeType.valueOf(tableFormat.getExpertise()).getValue();
            }
        }
        if (checkScore(Score)) {
            String employeeNumber = new GenerateEmployeeNumber().generateNumber();
            employee.setEmployeeNumber(Long.parseLong(employeeNumber));
            EmployeeType employeeType = ManagerEmploymentController.getEmployeeType();
            if (employeeType == EmployeeType.FullStack)
                employee.setBaseSalary(new FullStack().calculateBaseSalary(Score));
            else if (employeeType == EmployeeType.FrontEnd)
                employee.setBaseSalary(new FrontEnd().calculateBaseSalary(Score));
            else if (employeeType == EmployeeType.BackEnd)
                employee.setBaseSalary(new BackEnd().calculateBaseSalary(Score));
            else if (employeeType == EmployeeType.DBExpert)
                employee.setBaseSalary(new DBExpert().calculateBaseSalary(Score));
            else if (employeeType == EmployeeType.NetworkSecurityExpert)
                employee.setBaseSalary(new NetworkSecurityExpert().calculateBaseSalary(Score));


        } else {
// karmand mojaz be estexdam nist
        }

    }

    private boolean checkScore(int Score) {
        EmployeeType employeeType = ManagerEmploymentController.getEmployeeType();
        if (employeeType == EmployeeType.NetworkSecurityExpert) {
            return new NetworkSecurityExpert().getFINAL_SCORE() <= Score;
        } else if (employeeType == EmployeeType.FullStack) {
            return new FullStack().getFINAL_SCORE() <= Score;
        } else if (employeeType == EmployeeType.FrontEnd) {
            return new FrontEnd().getFINAL_SCORE() <= Score;
        } else if (employeeType == EmployeeType.DBExpert) {
            return new DBExpert().getFINAL_SCORE() <= Score;
        } else if (employeeType == EmployeeType.BackEnd) {
            return new BackEnd().getFINAL_SCORE() <= Score;
        }
        return false;
    }

    private void setTableEmployeeSpecialties() {

        EmployeeType employeeType = ManagerEmploymentController.getEmployeeType();
        if (employeeType.equals(EmployeeType.DBExpert)) {
            DB_Expert[] db_experts = DB_Expert.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < db_experts.length; i++) {
                observableList.add(new TableFormat(db_experts[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);
        } else if (employeeType.equals(EmployeeType.NetworkSecurityExpert)) {
            Network_Security[] network_securities = Network_Security.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < network_securities.length; i++) {
                observableList.add(new TableFormat(network_securities[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);


        } else if (employeeType.equals(EmployeeType.FullStack)) {
            Full_Stack[] full_stacks = Full_Stack.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < full_stacks.length; i++) {
                observableList.add(new TableFormat(full_stacks[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);
        } else if (employeeType.equals(EmployeeType.BackEnd)) {
            Back_End[] back_ends = Back_End.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < back_ends.length; i++) {
                observableList.add(new TableFormat(back_ends[i].toString(), i + 1, new JFXCheckBox()));
            }
            clmRow.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            clmExpertise.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            clmCheckBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tblSpecialties.setItems(observableList);

        } else if (employeeType.equals(EmployeeType.FrontEnd)) {
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
                if (e.getCharacter().matches("[ا-ی-ن]") || e.getCharacter().matches("[ ]") || e.getCharacter().matches("[A-Za-z]")) {
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
        employee = new Employee();
        employee.setEmployeeType(ManagerEmploymentController.getEmployeeType());


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
