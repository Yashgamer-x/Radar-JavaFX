package org.yashgamerx.radar;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class RadarView extends AnchorPane {

    private final Color bgSlate800 = Color.rgb(30, 41, 59);
    private final Color bgSlate900 = Color.rgb(15 ,23, 42);


    public RadarView() {
        defineBackgroundColor();
        makeHorizontalLine();
        makeVerticalLine();
        createFirstCircle();
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
        horizontalLine.setStroke(bgSlate800);

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
        verticalLine.setStroke(bgSlate800);

        verticalLine.setStrokeWidth(1);
        this.getChildren().add(verticalLine);
    }

    private void createFirstCircle() {
        var circle = new Circle();

        circle.centerXProperty().bind(widthProperty().divide(2));
        circle.centerYProperty().bind(heightProperty().divide(2));

        circle.radiusProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).divide(10)
        );

        circle.setStroke(bgSlate800);
        circle.setStrokeWidth(1);
        circle.setFill(Color.TRANSPARENT);

        getChildren().add(circle);
    }

}
