package Controller;
import Exceptions.StorifyExceptions;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;

public class ArtistCardViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private Text duration;

    @FXML
    private ImageView image;


    @FXML
    private Text nameSong;

    @FXML
    private Text nameAlbum;

    @FXML
    private Text genre;

    @FXML
    private Text anio;

    @FXML
    private HBox idArtist;

    @FXML
    private Text counterReproduction;

    @FXML
    void initialize() throws IOException, StorifyExceptions {
        modelFactoryController = ModelFactoryController.getInstance();
        idArtist.setId(modelFactoryController.getCurrentArtist().getId());
        if (modelFactoryController.isArtist.getValue()) {
            setArtist();
        } else {
            setSong();
        }
    }

    private void setArtist() {
//        Artist artist = modelFactoryController.getCurrentArtist();
//        nameSong.setText("Nombre: " + artist.getName());
//        image.setImage(new Image("file:" + "src/main/resources/imagenes/icono.png"));
//        nameAlbum.setText("Nacionalidad: " + artist.getNationality());
//        counterReproduction.setText("Número de reproducciones: " + artist.getCounter());
//        if (artist.isGroup()) {
//            genre.setText("El artista pertenece a un grupo.");
//        } else {
//            genre.setText("El artista no pertenece a un grupo.");
//        }
    }

    private void setSong() {
//        Song song = modelFactoryController.getCurrentSong();
//        nameSong.setText(song.getName());
//        String path = "file:" + song.getCaratula().getAbsolutePath();
//        Image image1 = new Image(path);
//        image.setImage(image1);
//        nameAlbum.setText("Nombre del álbum: " + song.getAlbumName());
//        genre.setText("Género de la canción: " + song.getGenre().toString());
//        anio.setText("Año de salida: " + song.getAnio() + "");
//        duration.setText("Duración: " + song.getDuration() + "minutos");
    }
}
