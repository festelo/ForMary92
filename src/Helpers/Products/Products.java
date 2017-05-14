package Helpers.Products;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Products {

    public Products(Stage primaryStageMain) throws IOException
    {
        primaryStageMain.hide();
        Stage currentStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("products.fxml"));
        Parent root = loader.load();
        currentStage.setScene(new Scene(root));
        currentStage.showAndWait();
    }
}
