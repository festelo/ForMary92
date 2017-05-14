package Helpers.Couriers.SingleCourier;

import Model.Courier;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SingleCourier {
    private boolean dialogResult;
    public boolean getDialogResult(){
        return  dialogResult;
    }

    public Courier Courier = new Courier();
    private Stage currentStage;
    private Stage primaryStageMain;

    public SingleCourier(Stage primaryStageMain)
    {
        this.primaryStageMain = primaryStageMain;
    }

    public void showAndWait() throws IOException {
        primaryStageMain.hide();
        currentStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("singleCourier.fxml"));
        loader.setController(new Controller(this));
        Parent root = loader.load();
        currentStage.setScene(new Scene(root));
        currentStage.showAndWait();
    }

    void SaveClose(Courier courier){
        Courier = courier;
        dialogResult = true;
        currentStage.close();
    }
}
