package pages.Start;

import javafx.animation.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Mode_1_HowToPlay_Controller implements Initializable{

    @FXML
    private StackPane stackPane;

    @FXML
    private Pane PaneMode_1_HowToPlay;

    @FXML
    private HBox imageContainer;

    @FXML
    private Rectangle PreviousButton;

    @FXML
    private Rectangle NextButton;

    @FXML
    private Rectangle BackButton;

    @FXML
    private final ImageView[] imageViews = {
            new ImageView("assets/MainMenu/mainmenu01.jpeg"),
            new ImageView("assets/MainMenu/mainmenu02.jpeg"),
            new ImageView("assets/MainMenu/slideImage01.jpeg")
    };

    private final Rectangle clipRectangle = new Rectangle();
    private final List<KeyFrame> keyFrames = new ArrayList<>();
    private int numberOfPage = 1;
    private Date date = new Date();
    private long pastTime = date.getTime();

    @FXML
    void clickedToNext(MouseEvent event) {
        date = new Date();
        long nowTime = date.getTime();

        if (nowTime - pastTime > 850 && numberOfPage < imageViews.length) {
            pastTime = date.getTime();
            numberOfPage++;
            NextButton.setVisible(numberOfPage < imageViews.length);
            PreviousButton.setVisible(numberOfPage > 1);
            EventHandler<ActionEvent> nextAction = (ActionEvent actionEvent) -> {
                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.75),imageContainer);
                translateTransition.setByX(-PaneMode_1_HowToPlay.getWidth());
                translateTransition.setInterpolator(Interpolator.EASE_BOTH);
                translateTransition.play();
            };
            keyFrames.add(new KeyFrame(Duration.seconds(0.1),nextAction));
//        keyFrames.add(new KeyFrame(Duration.seconds(2),nextAction));
//        keyFrames.add(new KeyFrame(Duration.seconds(3),nextAction));

            Timeline animation = new Timeline(keyFrames.toArray(new KeyFrame[1]));

            animation.play();
        }
    }

    @FXML
    void clickedToPrevious(MouseEvent event) {
        date = new Date();
        long nowTime = date.getTime();
        if (nowTime - pastTime > 850 && numberOfPage > 1) {
            pastTime = date.getTime();
            numberOfPage--;
            PreviousButton.setVisible(numberOfPage > 1);
            NextButton.setVisible(numberOfPage < imageViews.length);
            EventHandler<ActionEvent> backAction = (ActionEvent actionEvent) -> {
                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.75),imageContainer);
                translateTransition.setByX(PaneMode_1_HowToPlay.getWidth());
                translateTransition.setInterpolator(Interpolator.EASE_BOTH);
                translateTransition.play();
            };

            keyFrames.add(new KeyFrame(Duration.seconds(0.1),backAction));
//        keyFrames.add(new KeyFrame(Duration.seconds(2),nextAction));
//        keyFrames.add(new KeyFrame(Duration.seconds(3),nextAction));

            Timeline animation = new Timeline(keyFrames.toArray(new KeyFrame[1]));

            animation.play();

        }
    }

    @FXML
    void clickedToBack(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Mode_1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = PaneMode_1_HowToPlay.getScene();

//        root.translateYProperty().set(-scene.getWidth());
//        stackPane.getChildren().add(root);

        PaneMode_1_HowToPlay.translateYProperty().set(0);
        stackPane.getChildren().clear();
        stackPane.getChildren().add(root);
        stackPane.getChildren().add(PaneMode_1_HowToPlay);

        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(PaneMode_1_HowToPlay.translateYProperty(),-scene.getWidth(), Interpolator.EASE_OUT);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),keyValue);
        timeline.getKeyFrames().add(keyFrame);

        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().remove(PaneMode_1_HowToPlay);
            }
        });
        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set invisible PreviousButton
        PreviousButton.setVisible(numberOfPage > 1);

        //set Clip Rectangle
        clipRectangle.setWidth(800);
        clipRectangle.setHeight(680);
        clipRectangle.setArcHeight(100);
        clipRectangle.setArcWidth(100);

        //set Max size Pane
        PaneMode_1_HowToPlay.setMaxSize(800,680);
        PaneMode_1_HowToPlay.setClip(clipRectangle);

        //set size Image if not 800x680
        imageViews[0].setFitWidth(800);
        imageViews[0].setFitHeight(680);
        imageViews[1].setFitWidth(800);
        imageViews[1].setFitHeight(680);
        imageViews[2].setFitWidth(800);
        imageViews[2].setFitHeight(680);

        imageContainer.getChildren().addAll(imageViews);
//        PaneMode_1_HowToPlay.getChildren().add(imageContainer);
//        stackPane.getChildren().add(PaneMode_1_HowToPlay);
    }
}

