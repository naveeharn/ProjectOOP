package pages.Setting;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Setting_Controller {

    @FXML
    private Rectangle MainMenuButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void clickedToMainMenu(MouseEvent event) throws IOException {
        fxmlLoadStage(event,"../MainMenu/MainMenu.fxml");
    }

    public void fxmlLoadStage(MouseEvent event,String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
