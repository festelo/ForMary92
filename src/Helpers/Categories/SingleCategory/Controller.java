package Helpers.Categories.SingleCategory;

import Model.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    public TextField nameField;

    private SingleCategory client;

    public Controller(SingleCategory client){
        this.client = client;
    }

    @FXML
    public void initialize() {
        nameField.setText(client.Category.getName());
    }

    public void SaveClick(ActionEvent actionEvent) {
        Category cl = new Category();
        cl.setName(nameField.getText());
        client.SaveClose(cl);
    }
}
