package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    private RadioButton penRadio;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // If event coordinates are outside the drawing area, don't draw
        if (event.getX() >= 0 && event.getX() <= drawingAreaPane.getWidth() &&
            event.getY() >= 0 && event.getY() <= drawingAreaPane.getHeight()) {
            
            Color color = penRadio.isSelected() ? Color.BLACK : Color.WHITE;
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}
