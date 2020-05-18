package ManagerDashbord;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerLoginController implements Initializable {
    public JFXComboBox comboCompanyType;
    public TextField txtCompanyName;
    public JFXButton btnStartToCooperation;
    public Label lbl1;
    public static String CName ="";
    public static String CType ="";

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
    }

    public  void loadDashBoard(){
        if(comboCompanyType.getSelectionModel().getSelectedIndex()==-1||txtCompanyName.getText().equals("")){
            alert("Fill the blanks",lbl1,"red");
        }
        else {
            CName = txtCompanyName.getText();
            CType = comboCompanyType.getSelectionModel().getSelectedItem().toString();
            Parent root;
            try {
                Stage stage = (Stage) btnStartToCooperation.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("./DshbordNew.fxml"));
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


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] items = {"Private","Governmental"};
        comboCompanyType.getItems().addAll(items);

    }
}
