package Helpers.Clients;

import DB.Database;
import Helpers.Clients.SingleClient.SingleClient;
import Resources.Category;
import Resources.Client;
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
    public TableView<Client> tableView;

    @FXML
    public void initialize() {
        try {
            tableView.setItems(FXCollections.observableArrayList(Database.GetClients()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddClick(ActionEvent actionEvent) throws IOException, SQLException {
        SingleClient cl = new SingleClient(new Stage());
        cl.showAndWait();
        List<Client> cat = Database.AddClients(Collections.singletonList(cl.Client));
        tableView.getItems().add(cat.get(0));
    }

    public void ChangeClick(ActionEvent actionEvent) throws IOException, SQLException {
        Client cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        SingleClient scl = new SingleClient(new Stage());
        scl.Client = cl;
        scl.showAndWait();

        scl.Client.setID(cl.getID());
        Collections.replaceAll(tableView.getItems(), cl, scl.Client);
        Database.UpdateClients(Collections.singletonList(scl.Client));
    }

    public void RemoveClick(ActionEvent actionEvent) throws SQLException {
        Client cl = tableView.getSelectionModel().getSelectedItem();
        if(cl == null)
            return;

        tableView.getItems().remove(cl);
        Database.RemoveClients(Collections.singletonList(cl));
    }
}
