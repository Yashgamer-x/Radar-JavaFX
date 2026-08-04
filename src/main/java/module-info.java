module org.yashgamerx.radar {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;

    opens org.yashgamerx.radar to javafx.fxml;
    exports org.yashgamerx.radar;
}