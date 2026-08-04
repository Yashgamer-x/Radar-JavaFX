package org.yashgamerx.radar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RadarApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        var radarView = new RadarView();
        Scene scene = new Scene(radarView, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Radar Sweep");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}