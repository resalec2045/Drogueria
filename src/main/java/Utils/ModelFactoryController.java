package Utils;

//import Models.Artist.Artist;
//import Models.Song.Producto;
import Models.Producto.Producto;
import Models.Storify;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelFactoryController {
    private Storify storify;

    private Producto currentSong;

//    private Artist currentArtist;

    private ObservableList<Producto> favoriteSongs = FXCollections.observableArrayList();

//    ObservableList<Artist> arrayListArtist = FXCollections.observableArrayList();

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

    public Producto getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(Producto currentSong) {
        this.currentSong = currentSong;
    }


    public ObservableList<Producto> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(ObservableList<Producto> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

//    public Artist getCurrentArtist() {
//        return currentArtist;
//    }
//
//    public void setCurrentArtist(Artist currentArtist) {
//        this.currentArtist = currentArtist;
//    }

}
