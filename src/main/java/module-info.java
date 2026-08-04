module org.yashgamerx.radar {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.yashgamerx.radar to javafx.fxml;
    exports org.yashgamerx.radar;
}