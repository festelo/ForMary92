package Helpers.Products;

import DB.Database;
import Helpers.Products.SingleProduct.SingleProduct;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Controller {
    public TableView<Product> tableView;

    @FXML
    public void initialize() {
        try {
            tableView.setItems(FXCollections.observableArrayList(Database.GetProducts()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddClick(ActionEvent actionEvent) throws IOException, SQLException {
        SingleProduct cl = new SingleProduct(new Stage());
        cl.showAndWait();
        List<Product> cat = Database.AddProducts(Collections.singletonList(cl.Product));
        tableView.getItems().add(cat.get(0));
    }

    public void ChangeClick(ActionEvent actionEvent) throws IOException, SQLException {
        Product cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        SingleProduct scl = new SingleProduct(new Stage());
        scl.Product = cl;
        scl.showAndWait();

        scl.Product.setID(cl.getID());
        Collections.replaceAll(tableView.getItems(), cl, scl.Product);
        Database.UpdateProducts(Collections.singletonList(scl.Product));
    }

    public void RemoveClick(ActionEvent actionEvent) throws SQLException {
        Product cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        tableView.getItems().remove(cl);
        Database.RemoveProducts(Collections.singletonList(cl));
    }
}
