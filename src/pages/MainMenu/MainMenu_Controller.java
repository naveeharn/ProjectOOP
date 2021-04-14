package pages.MainMenu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import pages.Start.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class MainMenu_Controller implements Initializable {
    @FXML
    private AnchorPane sceneMainMenu;

    @FXML
    private Rectangle StartButton;

    @FXML
    private Rectangle SettingButton;

    @FXML
    private Rectangle ExitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Image image = new Image("");
    }

    @FXML
    private void clickedToStart(MouseEvent event) throws IOException {
        fxmlLoadStage(event,"../Start/Start.fxml");
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Start/Start.fxml"));
//        System.out.println("start");
//        root = fxmlLoader.load();
//        System.out.println("root");
//
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(new Scene(root));
//        stage.show();
    }

    @FXML
    private void clickedToSetting(MouseEvent event) throws IOException {
        fxmlLoadStage(event,"../Setting/Setting.fxml");
    }
    @FXML
    private void clickedToExit(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("You are about to exit");
        alert.setContentText("Do you want to exit?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) sceneMainMenu.getScene().getWindow();
//            System.out.println("successfully exit");
            stage.close();
        }
    }

    public void shapeFillImage(Shape shape, String pathImage) throws IOException{
//        shape.setFill(new ImagePattern(new Image(new FileInputStream(""))));
//        shape.setFill(new ImagePattern(new Image("")));
    }

    public void fxmlLoadStage(MouseEvent event,String pathFXML) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(pathFXML));
        root = fxmlLoader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
