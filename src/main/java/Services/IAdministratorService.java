package Services;

import Exceptions.SongsExceptions;
import Models.Song.Genre;
import Models.Song.Song;
import javafx.scene.image.Image;

import java.io.File;

public interface IAdministratorService {
    public Song createSong(String id, String name, String albumName, File caratula, int anio,
                           double duration, Genre genre, String url, String nameArtist) throws SongsExceptions;
}