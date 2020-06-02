package EmployeeDashbord.Controllers;

import ManagerDashbord.ManagerLoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeDashbordController implements Initializable {

    public JFXButton btnHomePage;
    public JFXButton btnSalaryPage;
    public AnchorPane loadAnchorPane;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtJob;
    public JFXTextField txtEmployeeCode;
    public JFXTextField txtBaseSalary;
    public JFXTextField txtCompanyName;
    public JFXTextField txtCompanyType;
    public Label lblRecievedSalary;
    public Label lblOverTime;
    public Label lblVacation;
    public Label lblNumbersOfCompany;
    public Pane Pane1;
    public Pane Pane2;
    private ManagerLoginController managerLoginController;


    public void settingCompanyName(String CompanyName, String CompanyType) {
        txtCompanyName.setText(CompanyName);
        txtCompanyType.setText(CompanyType);

    }

    public void loadHomePage(){
        hidingThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/EmployeeDashbord/FXMLs/HomePage.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }


    }
    public void loadSalaryPage(){
        hidingThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/EmployeeDashbord/FXMLs/SalaryReceipt.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }

    }

    public void hidingThings(){
        Pane1.setVisible(false);
        Pane2.setVisible(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        managerLoginController =  new ManagerLoginController();
        settingCompanyName(managerLoginController.CName, managerLoginController.CType);

    }
}
