package loginPages;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainLoginController implements Initializable {


    public JFXComboBox comboUseCase;
    public JFXButton btnGo;
    public Label lbl1;

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public void load() {
        if (comboUseCase.getSelectionModel().getSelectedIndex() == 0) {
            loadManagerPage();
        }
        if (comboUseCase.getSelectionModel().getSelectedIndex() == 1) {
            loadEmployeePage();
        }
        if (comboUseCase.getSelectionModel().getSelectedIndex() == -1)
            alert("Choose the Use Case",lbl1,"red");

    }

    public void loadManagerPage() {

        Parent root;
        try {
            Stage stage = (Stage) btnGo.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../ManagerDashbord/Managerlogin.fxml"));
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

    }

    public void loadEmployeePage() {

        Parent root;
        try {
            Stage stage = (Stage) btnGo.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../EmployeeDashbord/FXMLs/EmployeeLogin.fxml"));
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

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] str = {"As a Employment Manager", "As a Company Employee"};
        comboUseCase.getItems().addAll(str);
    }
}
