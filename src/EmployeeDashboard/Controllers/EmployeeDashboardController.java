package EmployeeDashboard.Controllers;

import ManagerDashbord.ManagerLoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import extras.Employee;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeDashboardController implements Initializable {

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
    public Label lblReceivedSalary;
    public Label lblOverTime;
    public Label lblVacation;
    public Label lblNumbersOfCompany;
    public Pane Pane1;
    public Pane Pane2;
    public JFXButton btnClose;
    public JFXButton btnBack;
    public Label lblRecievedSalary;
    public JFXButton btnAttendance;
    private ManagerLoginController managerLoginController;
    private boolean flag ;
    private Employee employee;

    public void exit() {

        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to go out ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("WARNING");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent())
            if (result.get() == yes)
                System.exit(0);
    }
    public void back() {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to go back to the home screen? ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("WARNING");
        alert.setHeaderText(null);
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        alert.getButtonTypes().setAll(yes,no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            if (result.get() == yes) {

                Parent root;
                try {
                    Stage stage = (Stage) btnBack.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../loginPages/MainLogin.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root, 536, 383));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

    }

    public void settingCompanyName(String CompanyName, String CompanyType) {
        txtCompanyName.setText(CompanyName);
        txtCompanyType.setText(CompanyType);

    }

    public void loadHomePage(){
//        hidingThings();
        loadAnchorPane.setVisible(false);
        Pane1.setVisible(true);
        Pane2.setVisible(true);


//        loadAnchorPane.setVisible(true);
//        try {
//            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/EmployeeDashboard/FXMLs/HomePage.fxml"));
//            loadAnchorPane.getChildren().addAll(anchorPane);
//        } catch (IOException ex) {
//            System.out.println("Problem in loading");
//        }


    }
    public void loadSalaryPage(){
        hidingThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/EmployeeDashboard/FXMLs/SalaryPane.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
            ex.printStackTrace();
        }

    }


    public void loadAttendancePage(){
        hidingThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/EmployeeDashboard/FXMLs/Attendance.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }


    }

    public void hidingThings(){
        Pane1.setVisible(false);
        Pane2.setVisible(false);
    }
private void setPersonalInfo(){

        txtFirstName.setText(employee.getName());
        txtLastName.setText(employee.getLastName());
        txtJob.setText(employee.getEmployeeType().toString());
        txtBaseSalary.setText(employee.getBaseSalary()+"");
        lblOverTime.setText(employee.getSalaryInformation().getOverWorkTime()+"");
        lblVacation.setText(employee.getSalaryInformation().getVacationHour()+"");
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employee=EmployeeLoginController.employee;
        setPersonalInfo();
        managerLoginController =  new ManagerLoginController();
        settingCompanyName(managerLoginController.CName, managerLoginController.CType);

    }
}
