package Models.Artist;

import Models.Song.ArtistSongs.SongsArtistList;

import java.io.Serializable;

public class Artist implements Serializable {
    public static final long serialVersionUID = 1L;
    private String nationality;
    private SongsArtistList songsList;
    private boolean isGroup;
    private String name;
    private String id;

    private int counter;

    public Artist() { }

    public Artist(String id, String name, String nationality, boolean isGroup, SongsArtistList songsList) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.isGroup = isGroup;
        this.songsList = songsList;
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public SongsArtistList getSongsList() {
        return songsList;
    }

    public void setSongsList(SongsArtistList songsList) {
        this.songsList = songsList;
    }
}
