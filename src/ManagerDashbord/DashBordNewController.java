package ManagerDashbord;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashBordNewController implements Initializable {

    public JFXButton btnHome;
    public JFXButton btnEmployment;
    public JFXButton btnSalary;
    public JFXButton btnMembers;
    public ImageView HomeImage;
    public Pane creditPane;
    public Pane TeamPane;
    public Pane Pane1;
    public Label lblCompanyName;
    public Label lblCompanyType;
    public AnchorPane loadAnchorPane;
    public JFXButton btnClose;
    public JFXButton btnBack;
    public ManagerLoginController managerLoginController;


    public void settingCompanyName(String CompanyName, String CompanyType) {
        lblCompanyName.setText(CompanyName);
        lblCompanyType.setText(CompanyType);

    }
    public void exit() {

        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to go out ", ButtonType.YES, ButtonType.NO);
        alert.setTitle("اخطار");
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
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to go back to the home screen?  ", ButtonType.YES, ButtonType.NO);
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
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../loginPages/MainLogin.fxml"));
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
    public void loadHomePage(){
//        hideThings();
        loadAnchorPane.setVisible(false);
        creditPane.setVisible(true);
        TeamPane.setVisible(true);
        Pane1.setVisible(true);
        HomeImage.setVisible(true);
//        try {
//            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("DashboardFXMLs/ManagerHome/MangerHome.fxml"));
//            loadAnchorPane.getChildren().addAll(anchorPane);
//        } catch (IOException ex) {
//            System.out.println("Problem in loading");
//        }

    }
    public void loadEmploymentPage(){
        hideThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("DashboardFXMLs/Employment/ManagerEmployment.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }

    }
    public void loadSalaryPage(){
        hideThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("DashboardFXMLs/Salary/ManagerSalaryPane.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }

    }
    public void loadMembersPage(){
        hideThings();
        loadAnchorPane.setVisible(true);
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("DashboardFXMLs/Members/ManagerMembersOfCompany.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }

    }
    public void hideThings(){
        creditPane.setVisible(false);
        TeamPane.setVisible(false);
        Pane1.setVisible(false);
        HomeImage.setVisible(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        managerLoginController =  new ManagerLoginController();
        settingCompanyName(managerLoginController.CName, managerLoginController.CType);
    }
}
