package Helpers.Couriers;

import DB.Database;
import Helpers.Couriers.SingleCourier.SingleCourier;
import Model.Courier;
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
    public TableView<Courier> tableView;

    @FXML
    public void initialize() {
        try {
            tableView.setItems(FXCollections.observableArrayList(Database.GetCouriers()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddClick(ActionEvent actionEvent) throws IOException, SQLException {
        SingleCourier cl = new SingleCourier(new Stage());
        cl.showAndWait();
        List<Courier> cat = Database.AddCouriers(Collections.singletonList(cl.Courier));
        tableView.getItems().add(cat.get(0));
    }

    public void ChangeClick(ActionEvent actionEvent) throws IOException, SQLException {
        Courier cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        SingleCourier scl = new SingleCourier(new Stage());
        scl.Courier = cl;
        scl.showAndWait();

        scl.Courier.setID(cl.getID());
        Collections.replaceAll(tableView.getItems(), cl, scl.Courier);
        Database.UpdateCouriers(Collections.singletonList(scl.Courier));
    }

    public void RemoveClick(ActionEvent actionEvent) throws SQLException {
        Courier cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        tableView.getItems().remove(cl);
        Database.RemoveCouriers(Collections.singletonList(cl));
    }
}
