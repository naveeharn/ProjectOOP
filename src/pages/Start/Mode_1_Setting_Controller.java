package pages.Start;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Mode_1_Setting_Controller implements Initializable {

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane PaneMode_1_Setting;

    @FXML
    private Rectangle BackButton;

    @FXML
    private Rectangle StartGamePlayButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void clickedToBack(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1_Setting.getScene();

//        root.translateYProperty().set(-scene.getWidth());
//        stackPane.getChildren().add(root);

        PaneMode_1_Setting.translateYProperty().set(0);
        stackPane.getChildren().clear();
        stackPane.getChildren().add(root);
        stackPane.getChildren().add(PaneMode_1_Setting);

        Timeline timeline = new Timeline();


        KeyValue keyValue = new KeyValue(PaneMode_1_Setting.translateYProperty(),scene.getWidth(), Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1_Setting);
            }
        });
        timeline.play();
    }

    @FXML
    void clickedToGamePlay(MouseEvent event) {

    }



}

