package org.yashgamerx.radar;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class RadarView extends AnchorPane {

    private final Color bgSlate800_40 = Color.rgb(30, 41, 59, 0.4f);


    public RadarView() {
        makeHorizontalLine();
        makeVerticalLine();
    }

    public void makeHorizontalLine(){
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

    public void makeVerticalLine(){
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
