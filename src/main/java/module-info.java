module com.example.drogueria {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;

    opens Controller to javafx.fxml;
    exports Controller;
    exports Models;
    opens Models to javafx.fxml;
//    exports Models.Artist;
//    opens Models.Artist to javafx.fxml;
    exports Models.Person;
    opens Models.Person to javafx.fxml;
//    exports Models.Song;
//    opens Models.Song to javafx.fxml;
    exports Utils;
    opens Utils to javafx.fxml;
//    exports Models.Song.ArtistSongs;
//    opens Models.Song.ArtistSongs to javafx.fxml;
//    exports Models.Song.UserSongs;
//    opens Models.Song.UserSongs to javafx.fxml;
    exports Models.Reportes;
    opens Models.Reportes to javafx.fxml;
}