package ManagerDashbord.DashboardControllers;

import ManagerDashbord.DashBordNewController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import extras.DBHelper;
import extras.Employee;
import extras.employeeTypes.BackEnd;
import extras.employeeTypes.EmployeeType;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerSalaryPaneController implements Initializable {
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
    public Label lblAlertSearch;
    private DashBordNewController dashBordNewController;
    private Employee employee;

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void searchEmployee() {
        //TODO search and set information of employee

        if(txtEmployeeCode.getText().equals(""))
            alert("Enter employee code",lblAlertSearch,"red");

        else {
            employee = new DBHelper().selectEmployee(Long.parseLong(txtEmployeeCode.getText()));

            txtAbsenceDays.setText(employee.getSalaryInformation().getAbsenceDays() + "");
            txtOverTimeHour.setText(employee.getSalaryInformation().getOverWorkTime() + "");
            txtVacationHour.setText(employee.getSalaryInformation().getVacationHour() + "");

            finalSalaryPane.setVisible(true);

        }
    }

    public void loadSalaryReceipt() {
        EmployeeType employeeType = employee.getEmployeeType();
        if (employeeType == EmployeeType.BackEnd) {
//            new BackEnd().calculateFinalSalary(employee.getBaseSalary(),employee.getEmployeeLevel())
        } else if (employeeType == EmployeeType.FrontEnd) {

        } else if (employeeType == EmployeeType.DBExpert) {

        } else if (employeeType == EmployeeType.FullStack) {

        } else if (employeeType == EmployeeType.NetworkSecurityExpert) {

        }
        try {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Salary/SalariesReceipt.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }

        //TODO write Receipt to data base


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

    public void DoingMission(MouseEvent mouseEvent) {

        if (checkDoingMission.isSelected()) txtDescribeMission.setDisable(false);
        else txtDescribeMission.setDisable(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        txtEmployeeCode.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(11));


    }
}
