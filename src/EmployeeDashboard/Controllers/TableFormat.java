package EmployeeDashboard.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;

public class TableFormat {
    private SimpleStringProperty serial;
    private SimpleStringProperty date;
    private JFXButton jfxButton;

    public String getSerial() {
        return serial.get();
    }

    public SimpleStringProperty serialProperty() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial.set(serial);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public JFXButton getJfxButton() {
        return jfxButton;
    }

    public void setJfxButton(JFXButton jfxButton) {
        this.jfxButton = jfxButton;
    }

    public TableFormat(String serial, String date, JFXButton jfxButton) {
        this.serial = new SimpleStringProperty(serial);
        this.date = new SimpleStringProperty(date);
        this.jfxButton = jfxButton;
    }
}
