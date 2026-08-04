module org.yashgamerx.radar {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome6;

    opens org.yashgamerx.radar to javafx.fxml;
    exports org.yashgamerx.radar;
}