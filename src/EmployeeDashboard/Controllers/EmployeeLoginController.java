package EmployeeDashboard.Controllers;

import com.jfoenix.controls.JFXButton;
import extras.DBHelper;
import extras.Employee;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EmployeeLoginController implements Initializable {


    public TextField txtUserName;
    public TextField txtPassWord;
    public JFXButton btnCheckProfile;
    public JFXButton btnClose;
    public JFXButton btnBack;
    public static Employee employee;
    public Label lblAlert;
    private static long employeeNumber;

    public static long getEmployeeNumber() {
        return employeeNumber;
    }

    public static void setEmployeeNumber(long employeeNumber) {
        EmployeeLoginController.employeeNumber = employeeNumber;
    }

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void loadDashBoard() {
        DBHelper dbHelper = new DBHelper();

        if (txtUserName.getText().equals("") || txtPassWord.getText().equals("")) {

            alert("fill the blanks" , lblAlert , "red");

        } else {
            employee = dbHelper.selectEmployee(Long.parseLong(txtUserName.getText()));
            System.out.println(employee.getNationalNumber()+"///////");
            System.out.println(employee.getNationalNumber());
            System.out.println(txtPassWord.getText());
            if (employee != null && (Long.parseLong(txtPassWord.getText())==employee.getNationalNumber())) {
                Parent root;
                setEmployeeNumber(Long.parseLong(txtUserName.getText()));
                try {
                    Stage stage = (Stage) btnCheckProfile.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXMLs/EmployeeDashbord.fxml"));
                    root = loader.load();
                    stage = new Stage();
                    Stage finalStage = stage;
                    finalStage.setResizable(false);
                    finalStage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("not found ");
                alert("not found" , lblAlert ,"red");
            }
        }
    }

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

        txtUserName.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(12));
        txtPassWord.addEventFilter(KeyEvent.KEY_TYPED, numeric_Validation(12));


    }
}
