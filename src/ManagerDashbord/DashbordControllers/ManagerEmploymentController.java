package ManagerDashbord.DashbordControllers;

import ManagerDashbord.DashBordNewController;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagerEmploymentController implements Initializable {

    public AnchorPane loadAnchorPane;

    public void loadForm(){
        try {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../DashbordFXMLs/Employment/SubmitPane.fxml"));
            loadAnchorPane.getChildren().addAll(anchorPane);
        } catch (IOException ex) {
            System.out.println("Problem in loading");
        }


   }
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
