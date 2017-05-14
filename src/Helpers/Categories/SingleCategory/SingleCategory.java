package Helpers.Categories.SingleCategory;

import Resources.Category;
import Resources.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SingleCategory {
    private boolean dialogResult;
    public boolean getDialogResult(){
        return  dialogResult;
    }

    public Category Category = new Category();
    private Stage currentStage;
    private Stage primaryStageMain;

    public SingleCategory(Stage primaryStageMain)
    {
        this.primaryStageMain = primaryStageMain;
    }

    public void showAndWait() throws IOException {
        primaryStageMain.hide();
        currentStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("singleCategory.fxml"));
        loader.setController(new Controller(this));
        Parent root = loader.load();
        currentStage.setScene(new Scene(root));
        currentStage.showAndWait();
    }

    void SaveClose(Category category){
        Category = category;
        dialogResult = true;
        currentStage.close();
    }
}
