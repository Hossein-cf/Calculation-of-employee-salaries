package ManagerDashbord.DashboardControllers;

import ManagerDashbord.DashBordNewController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import extras.*;
import extras.employeeTypes.*;
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
    public Label lblAlert2;
    private DashBordNewController dashBordNewController;
    private Employee employee;

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void searchEmployee() {


        if(txtEmployeeCode.getText().equals(""))
            alert("Enter employee code",lblAlertSearch,"red");

        else {
            employee = new DBHelper().selectEmployee(Long.parseLong(txtEmployeeCode.getText()));
            //TODO search and set information of employee
            //TODO check that employee is null or not
            txtAbsenceDays.setText(employee.getSalaryInformation().getAbsenceDays() + "");
            txtOverTimeHour.setText(employee.getSalaryInformation().getOverWorkTime() + "");
            txtVacationHour.setText(employee.getSalaryInformation().getVacationHour() + "");

            finalSalaryPane.setVisible(true);

        }
    }

    public void loadSalaryReceipt() {
        Receipt receipt = new Receipt();
        EmployeeType employeeType = employee.getEmployeeType();
        if (employeeType == EmployeeType.BackEnd) {
            double finalSalary = new BackEnd().calculateFinalSalary(employee.getSalaryInformation().getOverWorkTime(), employee.getSalaryInformation().getNightWorkDays(), employee.getSalaryInformation().getVacationHour(), employee.getWorkExperience(), employee.getBaseSalary(), employee.getSalaryInformation().getHolidayWorkTime(), employee.getSalaryInformation().getMorningWorkDays(), employee.getSalaryInformation().getAfternoonWorkDays(), employee.getSalaryInformation().getFullTimeWorksDays());
            receipt.setFinalSalary(finalSalary);
            receipt.setOverTimeSalary(new BackEnd().calculateMoneyForOverTimeWork(employee.getSalaryInformation().getOverWorkTime(),employee.getBaseSalary()));
            receipt.setSerial(Long.parseLong(new CreateSerialForReceipt().generateSerial()));
            receipt.setSalaryDate(dateOfIssuance.getValue());
            receipt.setBaseSalary(employee.getBaseSalary());


        } else if (employeeType == EmployeeType.FrontEnd) {
            double finalSalary = new FrontEnd().calculateFinalSalary(employee.getSalaryInformation().getOverWorkTime(), employee.getSalaryInformation().getNightWorkDays(), employee.getSalaryInformation().getVacationHour(), employee.getWorkExperience(), employee.getBaseSalary(), employee.getSalaryInformation().getHolidayWorkTime(), employee.getSalaryInformation().getMorningWorkDays(), employee.getSalaryInformation().getAfternoonWorkDays(), employee.getSalaryInformation().getFullTimeWorksDays());
            receipt.setFinalSalary(finalSalary);
            receipt.setOverTimeSalary(new BackEnd().calculateMoneyForOverTimeWork(employee.getSalaryInformation().getOverWorkTime(),employee.getBaseSalary()));
            receipt.setSerial(Long.parseLong(new CreateSerialForReceipt().generateSerial()));
            receipt.setSalaryDate(dateOfIssuance.getValue());
            receipt.setBaseSalary(employee.getBaseSalary());
        } else if (employeeType == EmployeeType.DBExpert) {
            double finalSalary = new DBExpert().calculateFinalSalary(employee.getSalaryInformation().getOverWorkTime(), employee.getSalaryInformation().getNightWorkDays(), employee.getSalaryInformation().getVacationHour(), employee.getWorkExperience(), employee.getBaseSalary(), employee.getSalaryInformation().getHolidayWorkTime(), employee.getSalaryInformation().getMorningWorkDays(), employee.getSalaryInformation().getAfternoonWorkDays(), employee.getSalaryInformation().getFullTimeWorksDays());
            receipt.setFinalSalary(finalSalary);
            receipt.setOverTimeSalary(new DBExpert().calculateMoneyForOverTimeWork(employee.getSalaryInformation().getOverWorkTime(),employee.getBaseSalary()));
            receipt.setSerial(Long.parseLong(new CreateSerialForReceipt().generateSerial()));
            receipt.setSalaryDate(dateOfIssuance.getValue());
            receipt.setBaseSalary(employee.getBaseSalary());
        } else if (employeeType == EmployeeType.FullStack) {
            double finalSalary = new FullStack().calculateFinalSalary(employee.getSalaryInformation().getOverWorkTime(), employee.getSalaryInformation().getNightWorkDays(), employee.getSalaryInformation().getVacationHour(), employee.getWorkExperience(), employee.getBaseSalary(), employee.getSalaryInformation().getHolidayWorkTime(), employee.getSalaryInformation().getMorningWorkDays(), employee.getSalaryInformation().getAfternoonWorkDays(), employee.getSalaryInformation().getFullTimeWorksDays());
            receipt.setFinalSalary(finalSalary);
            receipt.setOverTimeSalary(new FullStack().calculateMoneyForOverTimeWork(employee.getSalaryInformation().getOverWorkTime(),employee.getBaseSalary()));
            receipt.setSerial(Long.parseLong(new CreateSerialForReceipt().generateSerial()));
            receipt.setSalaryDate(dateOfIssuance.getValue());
            receipt.setBaseSalary(employee.getBaseSalary());
        } else if (employeeType == EmployeeType.NetworkSecurityExpert) {
            double finalSalary = new NetworkSecurityExpert().calculateFinalSalary(employee.getSalaryInformation().getOverWorkTime(), employee.getSalaryInformation().getNightWorkDays(), employee.getSalaryInformation().getVacationHour(), employee.getWorkExperience(), employee.getBaseSalary(), employee.getSalaryInformation().getHolidayWorkTime(), employee.getSalaryInformation().getMorningWorkDays(), employee.getSalaryInformation().getAfternoonWorkDays(), employee.getSalaryInformation().getFullTimeWorksDays());
            receipt.setFinalSalary(finalSalary);
            receipt.setOverTimeSalary(new NetworkSecurityExpert().calculateMoneyForOverTimeWork(employee.getSalaryInformation().getOverWorkTime(),employee.getBaseSalary()));
            receipt.setSerial(Long.parseLong(new CreateSerialForReceipt().generateSerial()));
            receipt.setSalaryDate(dateOfIssuance.getValue());
            receipt.setBaseSalary(employee.getBaseSalary());
        }

        new DBHelper().insertReceipt(receipt,employee.getEmployeeNumber());
//        SalaryInformation salaryInformation = employee.getSalaryInformation();
//        salaryInformation.set
        employee.setSalaryInformation(new SalaryInformation());
        new DBHelper().updateEmployee(employee);
        try {

                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Salary/SalariesReceipt.fxml"));
                loadAnchorPane.getChildren().addAll(anchorPane);
            } catch (IOException ex) {
                System.out.println("Problem in loading");
            }


            CreateSerialForReceipt cs = new CreateSerialForReceipt();
            String ReceiptSerial = cs.generateSerial();

            //TODO write Receipt to data base
        }

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


        txtEmployeeCode.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(12));


    }
}
