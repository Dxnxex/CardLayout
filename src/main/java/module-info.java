module cz.cardlayout.cardlayout {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens cz.cardlayout.cardlayout to javafx.fxml;
    exports cz.cardlayout.cardlayout;
}