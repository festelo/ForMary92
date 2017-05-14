package Main;

import Helpers.Categories.Categories;
import Helpers.Clients.Clients;
import Helpers.Couriers.Couriers;
import Helpers.Products.Products;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    public void HelpersClick(ActionEvent actionEvent) throws IOException {
        String[] arr = new String[] {"Клиенты", "Курьеры", "Категории блюд", "Меню"};

        ChoiceDialog<String> dialog = new ChoiceDialog<>(arr[0], arr);
        dialog.setTitle("Открыть справочник");
        dialog.setHeaderText("Выберите справочник");

        Optional<String> result = dialog.showAndWait();
        if(!result.isPresent())
            return;


        switch (result.get()){
            case "Клиенты":
                new Clients(new Stage());
                break;
            case "Курьеры":
                new Couriers(new Stage());
                break;
            case "Категории блюд":
                new Categories(new Stage());
                break;
            case "Меню":
                new Products(new Stage());
                break;
        }
    }
}
