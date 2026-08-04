package org.yashgamerx.radar;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class RadarView extends Pane {

    // Colors
    private final Color bgSlate800 = Color.rgb(30, 41, 59);
    private final Color bgSlate900 = Color.rgb(15 ,23, 42);
    private final Color emerald = Color.rgb(16, 185, 129, 0.2f);
    private final Color bgBlue600 = Color.rgb(37, 99, 235);

    //Bindings
    private final DoubleBinding centerXProperty;
    private final DoubleBinding centerYProperty;


    public RadarView() {
        this.centerXProperty = this.widthProperty().divide(2);
        this.centerYProperty = this.heightProperty().divide(2);

        defineBackgroundColor();
        makeHorizontalLine();
        makeVerticalLine();
        createLaptopIcon();
        createFirstCircle();
        createSecondCircle();
        createRadarPulse(Duration.ZERO);
        createRadarPulse(Duration.seconds(2));
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
        horizontalLine.startYProperty().bind(centerYProperty);
        horizontalLine.endYProperty().bind(centerYProperty);

        // Setting Color
        horizontalLine.setStroke(bgSlate800);

        horizontalLine.setStrokeWidth(1);
        this.getChildren().add(horizontalLine);
    }

    public void makeVerticalLine() {
        var verticalLine = new Line();

        // X Coordinates
        verticalLine.startXProperty().bind(centerXProperty);
        verticalLine.endXProperty().bind(centerXProperty);

        // Y Coordinates
        verticalLine.setStartY(0);
        var bottomMostYCoordinateBinding = this.heightProperty();
        verticalLine.endYProperty().bind(bottomMostYCoordinateBinding);

        // Setting Color
        verticalLine.setStroke(bgSlate800);

        verticalLine.setStrokeWidth(1);
        this.getChildren().add(verticalLine);
    }

    private void createLaptopIcon() {
        LaptopCircleIcon laptop = new LaptopCircleIcon();
        laptop.setManaged(false);
        laptop.radiusProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).divide(20)
        );
        laptop.layoutXProperty().bind(centerXProperty);
        laptop.layoutYProperty().bind(centerYProperty);
        getChildren().add(laptop);
    }

    private void createFirstCircle() {
        var circle = new Circle();

        circle.centerXProperty().bind(centerXProperty);
        circle.centerYProperty().bind(centerYProperty);

        circle.radiusProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).divide(10)
        );

        circle.setStroke(bgSlate800);
        circle.setStrokeWidth(1);
        circle.setFill(Color.TRANSPARENT);

        getChildren().add(circle);
    }

    private void createSecondCircle() {
        var circle = new Circle();


        circle.centerXProperty().bind(centerXProperty);
        circle.centerYProperty().bind(centerYProperty);

        circle.radiusProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).divide(5)
        );

        circle.setStroke(bgSlate800);
        circle.setStrokeWidth(1);
        circle.setFill(Color.TRANSPARENT);

        getChildren().add(circle);
    }

    private void createRadarPulse(Duration delay) {
        Circle pulse = new Circle();

        pulse.centerXProperty().bind(centerXProperty);
        pulse.centerYProperty().bind(centerYProperty);

        pulse.radiusProperty().bind(
                Bindings.min(widthProperty(), heightProperty()).divide(3.75)
        );

        pulse.setStroke(emerald);
        pulse.setStrokeWidth(2);
        pulse.setFill(Color.TRANSPARENT);
        pulse.setOpacity(0);

        getChildren().add(pulse);

        ScaleTransition scale = new ScaleTransition(Duration.seconds(4), pulse);
        scale.setFromX(1.0);
        scale.setFromY(1.0);
        scale.setToX(1.5);
        scale.setToY(1.5);

        FadeTransition fade = new FadeTransition(Duration.seconds(4), pulse);
        fade.setFromValue(0.8);
        fade.setToValue(0.0);

        ParallelTransition animation = new ParallelTransition(scale, fade);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.setDelay(delay);
        animation.play();
    }

}
