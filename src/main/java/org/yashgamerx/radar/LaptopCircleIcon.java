package org.yashgamerx.radar;

import javafx.beans.property.DoubleProperty;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.kordamp.ikonli.javafx.FontIcon;

public class LaptopCircleIcon extends StackPane {

    private final Circle circle = new Circle();
    private final FontIcon icon = new FontIcon("fas-laptop");

    public LaptopCircleIcon() {
        circle.setFill(Color.DODGERBLUE);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.35));
        shadow.setRadius(12);
        shadow.setOffsetY(3);
        shadow.setSpread(0.15);
        circle.setEffect(shadow);

        icon.setIconColor(Color.WHITE);
        icon.iconSizeProperty().bind(circle.radiusProperty().multiply(0.5));

        getChildren().addAll(circle, icon);
    }

    public DoubleProperty radiusProperty() {
        return circle.radiusProperty();
    }

    public void setRadius(double radius) {
        circle.setRadius(radius);
    }

    public double getRadius() {
        return circle.getRadius();
    }
}