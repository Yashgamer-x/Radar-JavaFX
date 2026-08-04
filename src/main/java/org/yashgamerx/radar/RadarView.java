package org.yashgamerx.radar;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class RadarView extends AnchorPane {

    private final Color bgSlate800_40 = Color.rgb(30, 41, 59, 0.4f);
    private final Color bgSlate900 = Color.rgb(15 ,23, 42);


    public RadarView() {
        defineBackgroundColor();
        makeHorizontalLine();
        makeVerticalLine();
    }

    private void defineBackgroundColor() {
        this.setBackground(new Background(new BackgroundFill(bgSlate900, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void makeHorizontalLine() {
        var horizontalLine = new Line();

        // X Coordinates
        horizontalLine.setStartX(0);
        var rightMostXCoordinateBinding = this.widthProperty();
        horizontalLine.endXProperty().bind(rightMostXCoordinateBinding);

        // Y Coordinates
        var centerYBinding = this.heightProperty().divide(2);
        horizontalLine.startYProperty().bind(centerYBinding);
        horizontalLine.endYProperty().bind(centerYBinding);

        // Setting Color
        horizontalLine.setStroke(bgSlate800_40);

        horizontalLine.setStrokeWidth(1);
        this.getChildren().add(horizontalLine);
    }

    public void makeVerticalLine() {
        var verticalLine = new Line();

        // X Coordinates
        var centerXBinding = this.widthProperty().divide(2);
        verticalLine.startXProperty().bind(centerXBinding);
        verticalLine.endXProperty().bind(centerXBinding);

        // Y Coordinates
        verticalLine.setStartY(0);
        var bottomMostYCoordinateBinding = this.heightProperty();
        verticalLine.endYProperty().bind(bottomMostYCoordinateBinding);

        // Setting Color
        verticalLine.setStroke(bgSlate800_40);

        verticalLine.setStrokeWidth(1);
        this.getChildren().add(verticalLine);
    }

}
