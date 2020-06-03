package ManagerDashbord;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManagerLoginController implements Initializable {
  //  public JFXComboBox comboCompanyType;
    private final String USER_NAME = "123456";
    private final String PASS_WORD = "123456";

    public TextField txtCompanyName;
    public JFXButton btnStartToCooperation;
    public Label lbl1;
    public static String CName ="Dadeh Gostar Gharb";
    public static String CType ="Private";
    public TextField txtUserName;
    public TextField txtPass;
    public JFXButton btnBack;
    public JFXButton btnClose;

    private void alert(String message, Label lbl, String color) {
        lbl.setText(message);
        lbl.setStyle("-fx-text-fill: " + color + ";");
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

    public  void loadDashBoard(){
        if(txtUserName.getText().equals("")||txtPass.getText().equals("")){
            alert("Fill the blanks",lbl1,"red");
        }

        else if(!txtUserName.getText().equals(USER_NAME)|| !txtPass.getText().equals(PASS_WORD)){

            alert("UserName or PassWord is wrong", lbl1 , "red");
        }
        else if(txtUserName.getText().equals(USER_NAME)&&txtPass.getText().equals(PASS_WORD)) {
         //   CName = txtCompanyName.getText();
       //     CType = comboCompanyType.getSelectionModel().getSelectedItem().toString();
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
    //    String[] items = {"Private","Governmental"};
   //     comboCompanyType.getItems().addAll(items);

    }
}
