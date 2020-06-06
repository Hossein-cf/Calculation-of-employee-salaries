package loginPages;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainLoginController implements Initializable {


    public JFXComboBox comboUseCase;
    public JFXButton btnGo;
    public Label lbl1;
    public JFXButton btnClose;

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
            alert("Choose one of the Use Cases",lbl1,"red");

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../EmployeeDashboard/FXMLs/EmployeeLogin.fxml"));
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
