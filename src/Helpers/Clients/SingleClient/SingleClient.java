package Helpers.Clients.SingleClient;

import Model.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SingleClient {
    private boolean dialogResult;
    public boolean getDialogResult(){
        return  dialogResult;
    }

    public Client Client = new Client();
    private Stage currentStage;
    private Stage primaryStageMain;

    public SingleClient(Stage primaryStageMain)
    {
        this.primaryStageMain = primaryStageMain;
    }

    public void showAndWait() throws IOException {
        primaryStageMain.hide();
        currentStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("singleClient.fxml"));
        loader.setController(new Controller(this));
        Parent root = loader.load();
        currentStage.setScene(new Scene(root));
        currentStage.showAndWait();
    }

    void SaveClose(Client client){
        Client = client;
        dialogResult = true;
        currentStage.close();
    }
}
