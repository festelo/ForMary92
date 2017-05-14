package Helpers.Categories;

import DB.Database;
import Helpers.Categories.SingleCategory.SingleCategory;
import Model.Category;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Controller {
    public TableView<Category> tableView;

    @FXML
    public void initialize() {
        try {
            tableView.setItems(FXCollections.observableArrayList(Database.GetCategories()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddClick(ActionEvent actionEvent) throws IOException, SQLException {
        SingleCategory cl = new SingleCategory(new Stage());
        cl.showAndWait();
        List<Category> cat = Database.AddCategories(Collections.singletonList(cl.Category));
        tableView.getItems().add(cat.get(0));
    }

    public void ChangeClick(ActionEvent actionEvent) throws IOException, SQLException {
        Category cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        SingleCategory scl = new SingleCategory(new Stage());
        scl.Category = cl;
        scl.showAndWait();

        scl.Category.setID(cl.getID());
        Collections.replaceAll(tableView.getItems(), cl, scl.Category);
        Database.UpdateCategories(Collections.singletonList(scl.Category));
    }

    public void RemoveClick(ActionEvent actionEvent) throws SQLException {
        Category cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        tableView.getItems().remove(cl);
        Database.RemoveCategories(Collections.singletonList(cl));
    }
}
