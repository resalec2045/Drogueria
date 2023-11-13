package Utils;

import Models.Artist.Artist;
import Models.Song.Song;
import Models.Storify;
import Services.IModelFactoryService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelFactoryController implements IModelFactoryService {
    private Storify storify;

    private Song currentSong;

    private Artist currentArtist;

    private ObservableList<Song> favoriteSongs = FXCollections.observableArrayList();

    ObservableList<Artist> arrayListArtist = FXCollections.observableArrayList();

    public SimpleBooleanProperty isArtist = new SimpleBooleanProperty(false);

    public String sectionCurrent = "Canciones";

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public Storify getStorify() {
        return storify;
    }

    public void setStorify(Storify storify) {
        this.storify = storify;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(Song currentSong) {
        this.currentSong = currentSong;
    }


    public ObservableList<Song> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(ObservableList<Song> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    public Artist getCurrentArtist() {
        return currentArtist;
    }

    public void setCurrentArtist(Artist currentArtist) {
        this.currentArtist = currentArtist;
    }

}
