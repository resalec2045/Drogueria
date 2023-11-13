package Models.Song;

import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.Serializable;

public class Song extends FXMLLoader implements Serializable {
    public static final long serialVersionUID = 1L;
    private String nameArtist;
    private String albumName;
    private double duration;
    private File caratula;
    private Genre genre;
    private String name;
    private String url;
    private String id;
    private int anio;

    public Song() { }

    public Song(String id, String name, String albumName, File caratula, int anio, double duration, Genre genre, String url,
                String nameArtist) {
        this.id = id;
        this.name = name;
        this.albumName = albumName;
        this.caratula = caratula;
        this.anio = anio;
        this.duration = duration;
        this.genre = genre;
        this.url = url;
        this.nameArtist = nameArtist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public File getCaratula() {
        return caratula;
    }

    public void setCaratula(File caratula) {
        this.caratula = caratula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }
}
