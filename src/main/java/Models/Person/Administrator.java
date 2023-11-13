package Models.Person;

import Exceptions.SongsExceptions;
import Exceptions.UserExceptions;
import Models.Song.Genre;
import Models.Song.Song;
import Services.IAdministratorService;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Administrator implements Serializable, IAdministratorService {
    public ArrayList<Song> songs =  new ArrayList<>();
    public static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public Administrator() { }

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Song createSong(String id, String name, String albumName, File caratula, int anio,
                           double duration, Genre genre, String url, String nameAritst) throws SongsExceptions {
        Song newSong = new Song(id, name, albumName, caratula, anio, duration, genre, url, nameAritst);
        this.songs.forEach(song -> {
            if(song.getName().equals(newSong.getName())) {
                try {
                    throw new UserExceptions("La canción ya existe.");
                } catch (UserExceptions e) { throw new RuntimeException(e); }
            }
        });
        return newSong;
    }
}
