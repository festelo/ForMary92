package Helpers.Products.SingleProduct;

import DB.Database;
import Model.Category;
import Model.Extensions;
import Model.Measure;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public TextField nameField;
    public TextField priceField;
    public TextField consistField;
    public ComboBox<String> categoryBox;
    public ComboBox<String> measureBox;

    private SingleProduct client;
    private List<Category> categories;

    public Controller(SingleProduct client){
        this.client = client;
    }

    @FXML
    public void initialize() throws SQLException {
        if(client.Product != null){
            nameField.setText(client.Product.getName());
            priceField.setText(Double.toString(client.Product.getPrice()));
            consistField.setText(client.Product.getConsist());
        }

        categories = Database.GetCategories();
        List<String> categoryListString = new ArrayList<>();
        for(Category c : categories){
            categoryListString.add(c.getName());
        }
        categoryBox.setItems(FXCollections.observableArrayList(categoryListString));

        measureBox.setItems(FXCollections.observableArrayList(Extensions.getNames(Measure.class)));
    }

    public void SaveClick(ActionEvent actionEvent) {
        Product cl = new Product();
        try{
            cl.setPrice( Double.parseDouble(priceField.getText()));
        } catch (NumberFormatException e){
            Dialog d = new Dialog();
            d.setContentText("Проверьте корректность цены.");
            d.showAndWait();
            return;
        }
        if(measureBox.getValue() == null){
            Dialog d = new Dialog();
            d.setContentText("Мера не может быть пуста!");
            d.showAndWait();
            return;
        }
        cl.setMeasure(Measure.valueOf(measureBox.getValue()));

        if(categoryBox.getValue() == null){
            Dialog d = new Dialog();
            d.setContentText("Категория не может быть пустая!");
            d.showAndWait();
            return;
        }
        for(Category c : categories){
            if(c.getName() == categoryBox.getValue()){
                cl.setCategory(c);
                break;
            }
        }

        cl.setName(nameField.getText());
        cl.setConsist(consistField.getText());
        client.SaveClose(cl);
    }
}
