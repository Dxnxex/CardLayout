module cz.cardlayout {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens cz.cardlayout to javafx.fxml;
    exports cz.cardlayout;
}