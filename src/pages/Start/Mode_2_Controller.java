package pages.Start;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Mode_2_Controller {

    @FXML
    private Pane PaneMode_2;

    @FXML
    private Rectangle HowToPlayButton;

    @FXML
    private Rectangle ConfirmButton;

    @FXML
    void clickedToConfirm(MouseEvent event) {

    }

    @FXML
    void clickedToHowToPlay(MouseEvent event) {

    }
    
    @FXML
    void onMouseEntered(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.YELLOW);
        object.setStrokeWidth(4);
    }

    @FXML
    void onMouseExited(MouseEvent event) {
        Rectangle object = (Rectangle) event.getSource();
        object.setStroke(Color.BLACK);
        object.setStrokeWidth(1);
    }


}
