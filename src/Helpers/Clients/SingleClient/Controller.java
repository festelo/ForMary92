package Helpers.Clients.SingleClient;

import Model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    public TextField nameField;
    public TextField phoneField;
    public TextField addressField;

    private SingleClient client;

    public Controller(SingleClient client){
        this.client = client;
    }

    @FXML
    public void initialize() {
        nameField.setText(client.Client.getName());
        phoneField.setText(client.Client.getPhone());
        addressField.setText(client.Client.getAddress());
    }

    public void SaveClick(ActionEvent actionEvent) {
        Client cl = new Client();
        cl.setName(nameField.getText());
        cl.setPhone(phoneField.getText());
        cl.setAddress(addressField.getText());
        client.SaveClose(cl);
    }
}
