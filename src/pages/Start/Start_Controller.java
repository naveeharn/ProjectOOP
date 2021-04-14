package pages.Start;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;


public class Start_Controller {
    @FXML
    private Rectangle MainMenuButton;

    @FXML
    private Rectangle EasyButton;

    @FXML
    private Rectangle ClassicButton;

    @FXML
    private Label statusMode;

    @FXML
    private AnchorPane AnchorPaneMode;

    @FXML
    private StackPane StackPaneMode;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void chooseEasyMode(MouseEvent event) {
        statusMode.setText("Easy");
//        StackPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,new CornerRadii(50),null)));
        AnchorPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN,new CornerRadii(50),null)));

    }

    @FXML
    void chooseClassicMode(MouseEvent event) {
        statusMode.setText("Classic");
//        StackPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,new CornerRadii(50),null)));
        AnchorPaneMode.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK,new CornerRadii(50),null)));

    }

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
