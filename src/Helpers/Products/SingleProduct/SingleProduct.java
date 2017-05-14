package Helpers.Products.SingleProduct;

import Model.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SingleProduct {
    private boolean dialogResult;
    public boolean getDialogResult(){
        return  dialogResult;
    }

    public Product Product = new Product();
    private Stage currentStage;
    private Stage primaryStageMain;

    public SingleProduct(Stage primaryStageMain)
    {
        this.primaryStageMain = primaryStageMain;
    }

    public void showAndWait() throws IOException {
        primaryStageMain.hide();
        currentStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("singleProduct.fxml"));
        loader.setController(new Controller(this));
        Parent root = loader.load();
        currentStage.setScene(new Scene(root));
        currentStage.showAndWait();
    }

    void SaveClose(Product product){
        Product = product;
        dialogResult = true;
        currentStage.close();
    }
}
