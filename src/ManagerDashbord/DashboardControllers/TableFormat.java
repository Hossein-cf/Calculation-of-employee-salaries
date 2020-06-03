package ManagerDashbord.DashboardControllers;

import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.property.SimpleStringProperty;

public class TableFormat {
   private SimpleStringProperty expertise ;
   private int row ;
   private JFXCheckBox jfxCheckBox;

    public String getExpertise() {
        return expertise.get();
    }

    public SimpleStringProperty expertiseProperty() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise.set(expertise);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public JFXCheckBox getJfxCheckBox() {
        return jfxCheckBox;
    }

    public void setJfxCheckBox(JFXCheckBox jfxCheckBox) {
        this.jfxCheckBox = jfxCheckBox;
    }

    public TableFormat(String  expertise, int row, JFXCheckBox jfxCheckBox) {
        this.expertise =new SimpleStringProperty( expertise);
        this.row = row;
        this.jfxCheckBox = jfxCheckBox;
    }
}
