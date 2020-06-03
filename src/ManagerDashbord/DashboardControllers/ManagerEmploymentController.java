package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import employeeTypes.*;
import extras.Employee;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerEmploymentController implements Initializable {


    public AnchorPane loadAnchorPane;
    public ComboBox comboEmployeeType;
    public ComboBox comboWorkTime;
    public JFXButton btnLoadForm;
    public ComboBox comboEmployeeLevel;
    public static String employeeType;

    public static String getEmployeeType() {
        return employeeType;
    }

    public static void setEmployeeType(String employeeType) {
        ManagerEmploymentController.employeeType = employeeType;
    }

    public void loadForm() {
        if (comboEmployeeType.getSelectionModel().getSelectedIndex() == -1 || comboWorkTime.getSelectionModel().getSelectedIndex() == -1 || comboEmployeeLevel.getSelectionModel().getSelectedIndex() == -1) {


        } else {
            setEmployeeType(comboEmployeeType.getValue().toString());
            String EmployeeLevel = comboEmployeeLevel.getValue().toString();
            String WorkTime = comboWorkTime.getValue().toString();
//            setTableEmployeeSpecialties(employeeType);
            try {

                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Employment/SubmitPane.fxml"));
                loadAnchorPane.getChildren().addAll(anchorPane);
            } catch (IOException ex) {
                System.out.println("Problem in loading");
            }
        }

    }

    private void setTableEmployeeSpecialties(String employeeType) {
        TableView tableView = null;
        AnchorPane pane = null;
        Pane pane1 = null;
        try {

            pane = FXMLLoader.load(getClass().getResource("../DashboardFXMLs/Employment/SubmitForm.fxml"));
            pane1 = (Pane) pane.getChildren().get(2);
            tableView = (TableView) pane1.getChildren().get(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ObservableList<TableColumn> tableColumns = tableView.getColumns();


        if (employeeType.equals(EmployeeType.DBExpert.toString())) {
            ObservableList<DB_Expert> observableList = FXCollections.observableArrayList();
            observableList.addAll(DB_Expert.values());
        } else if (employeeType.equals(EmployeeType.NetworkSecurityExpert.toString())) {
            NetworkSecurityExpert networkSecurityExpert = new NetworkSecurityExpert();
        } else if (employeeType.equals(EmployeeType.FullStack.toString())) {
            System.out.println(0);
//            FullStack fullStack = new FullStack();
            Full_Stack[] full_stacks = Full_Stack.values();
            ObservableList<TableFormat> observableList = FXCollections.observableArrayList();
            for (int i = 0; i < full_stacks.length; i++) {
                System.out.println(1);

                observableList.add(new TableFormat(full_stacks[i].toString(), i + 1, new JFXCheckBox()));
                System.out.println(observableList.get(i).getExpertise());
            }
            tableColumns.get(0).setCellValueFactory(new PropertyValueFactory<TableFormat, String>("row"));
            tableColumns.get(1).setCellValueFactory(new PropertyValueFactory<TableFormat, String>("expertise"));
            tableColumns.get(2).setCellValueFactory(new PropertyValueFactory<TableFormat, String>("jfxCheckBox"));
            tableView.setItems(observableList);
            TableFormat tableFormat = (TableFormat) tableView.getItems().get(0);
            System.out.println(tableFormat.getExpertise());
        } else if (employeeType.equals(EmployeeType.BackEnd.toString())) {
            BackEnd backEnd = new BackEnd();

        } else if (employeeType.equals(EmployeeType.FrontEnd.toString())) {
            FrontEnd frontEnd = new FrontEnd();
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
}
