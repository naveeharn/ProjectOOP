package pages.Start;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;

public class Mode_1_Controller {

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane PaneMode_1;

    @FXML
    private Rectangle HowToPlayButton;

    @FXML
    private Rectangle ConfirmButton;



    @FXML
    void clickedToHowToPlay(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1_HowToPlay.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1.getScene();

        root.translateYProperty().set(-scene.getWidth());

        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1);
            }
        });
        timeline.play();
    }

    @FXML
    void clickedToConfirm(MouseEvent event) throws IOException {
        PaneMode_1.setClip(new Rectangle(PaneMode_1.getWidth(),PaneMode_1.getHeight()));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1_Setting.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1.getScene();

        root.translateYProperty().set(scene.getWidth());
        stackPane.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1);
            }
        });
        timeline.play();
    }

}