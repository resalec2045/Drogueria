package Models;
import Models.Artist.Artist;
import Models.Person.Administrator;
import Models.Person.User;
import Models.Song.Producto;
import Models.Person.Persona;

import java.io.Serializable;
import java.util.ArrayList;

public class Storify implements Serializable {
    public static final long serialVersionUID = 1L;

    public static int globalId = 0;
    public static int viewArtistId = 1;
    private boolean isUser;
    private boolean isAministrator;
    private Persona user;
    private Administrator administrator;
    private ArrayList<User> users =  new ArrayList<>();
    private ArrayList<Administrator> administrators = new ArrayList<>();
    private ArrayList<Artist> artists = new ArrayList<>();
    private ArrayList<Producto> songs = new ArrayList<>();

    public Storify() { }


    public ArrayList<Producto> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Producto> song) {
        this.songs = song;
    }

    public void setSong(Producto song) {
        this.songs.add(song);
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtist(Artist artist) {
        this.artists.add(artist);
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public void setAministrator(boolean aministrator) {
        isAministrator = aministrator;
    }


    public void setUser(Persona user) {
        this.user = user;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(ArrayList<Administrator> administrators) {
        this.administrators = administrators;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }
}
