package EmployeeDashboard.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import extras.DBHelper;
import extras.Employee;
import extras.Receipt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class SalaryPaneController implements Initializable {
    public TableView<TableFormat> ReceiptTableView;
    public TableColumn<TableFormat, String> clmDate;
    public TableColumn<TableFormat, String> clmSerial;
    public TableColumn<TableFormat, JFXButton> clmShowBtn;
    public AnchorPane showReceiptAnchorPane;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmployeeCode;
    public JFXTextField txtNationalCode;
    public JFXTextField txtJob;
    public JFXTextField txtEmployeeLevel;
    public JFXTextField txtWorkingTime;
    public JFXTextField txtOvertime;
    public JFXTextField txtDeducted;
    public JFXTextField txtBaseSalary;
    public JFXTextField txtMoneyOfExperience;
    public JFXTextField txtFinalSalary;
    public Pane ReceiptPane;
    private Employee employee;

    private void setReceiptInfoToTable() {


        // TODO hossein inja error hast chon null mide
            ArrayList<Receipt> receipts = new DBHelper().selectReceipts(employee.getEmployeeNumber());


        ObservableList<TableFormat> list = FXCollections.observableArrayList();
        if (list.size() > 0) {
            for (Receipt receipt : receipts) {
                JFXButton jfxButton = new JFXButton("Show Receipt");
                list.add(new TableFormat(receipt.getSerial() + "", receipt.getSalaryDate() + "", jfxButton));
                jfxButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        txtBaseSalary.setText(employee.getBaseSalary() + "");
                        txtEmployeeCode.setText(employee.getEmployeeNumber() + "");
                        txtEmployeeLevel.setText(employee.getEmployeeLevel());
                        txtFinalSalary.setText(receipt.getFinalSalary() + "");
                        txtFirstName.setText(employee.getName());
                        txtJob.setText(employee.getEmployeeType().toString());
                        txtLastName.setText(employee.getLastName());
                        txtNationalCode.setText(employee.getNationalNumber() + "");
                        txtOvertime.setText(receipt.getOverTimeSalary() + "");
//                   TODO set information
                    }
                });

            }
            clmDate.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("date"));
            clmSerial.setCellValueFactory(new PropertyValueFactory<TableFormat, String>("serial"));
            clmShowBtn.setCellValueFactory(new PropertyValueFactory<TableFormat, JFXButton>("jfxButton"));
            ReceiptTableView.setItems(list);
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setReceiptInfoToTable();
        employee = EmployeeLoginController.employee;
    }
}
