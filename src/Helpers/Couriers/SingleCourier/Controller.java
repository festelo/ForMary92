package Helpers.Couriers.SingleCourier;

import Model.Courier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {

    public TextField nameField;
    public TextField phoneField;
    public ComboBox<String> workingBox;

    private SingleCourier courier;

    public Controller(SingleCourier client){
        this.courier = client;
    }

    @FXML
    public void initialize() {
        nameField.setText(courier.Courier.getName());
        phoneField.setText(courier.Courier.getPhone());

        workingBox.getItems().add("Да");
        workingBox.getItems().add("Нет");

        workingBox.getSelectionModel().select(courier.Courier.getWorkingText());
    }

    public void SaveClick(ActionEvent actionEvent) {
        Courier cl = new Courier();
        cl.setName(nameField.getText());
        cl.setPhone(phoneField.getText());

        if(workingBox.getSelectionModel().getSelectedItem() == "Да")
            cl.isWorking = true;

        courier.SaveClose(cl);
    }
}
