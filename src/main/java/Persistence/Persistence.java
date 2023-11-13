package Persistence;

import Exceptions.UserExceptions;
import Models.*;
import Models.Artist.Artist;
import Models.Person.Administrator;
import Models.Person.User;
import Models.Song.Genre;
import Models.Song.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistence {
    public static final String ROUTE_FILE_USERS = "src/main/resources/Persistence/Users.txt";
    public static final String ROUTE_FILE_ADMINISTRATOR = "src/main/resources/Persistence/Administrator.txt";
    public static final String ROUTE_FILE_SONGS = "src/main/resources/Persistence/Songs.txt";
    public static final String ROUTE_FILE_SONGSUSER = "src/main/resources/Persistence/SongListUser.txt";
    public static final String ROUTE_FILE_ARTIST = "src/main/resources/Persistence/Artist.txt";
    public static final String ROUTE_FILE_STORIFY = "src/main/resources/Persistence/Storify.xml";

    public static ArrayList<Administrator> loadAdministrator() throws FileNotFoundException, IOException {
        ArrayList<Administrator> administrators =new ArrayList<Administrator>();
        ArrayList<String> content = UtilFile.readFile(ROUTE_FILE_ADMINISTRATOR);
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);
            Administrator administrator = new Administrator();
            administrator.setUsername(line.split("@@")[0]);
            administrator.setPassword(line.split("@@")[1]);
            administrators.add(administrator);
            administrators.add(administrator);
        }
        return administrators;
    }

    public static ArrayList<User> loadUsers() throws FileNotFoundException, IOException {
        ArrayList<User> users =new ArrayList<User>();
        ArrayList<String> content = UtilFile.readFile(ROUTE_FILE_USERS);
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);
            User user = new User();
            user.setUsername(line.split("@@")[0]);
            user.setPassword(line.split("@@")[1]);
            user.setEmail(line.split("@@")[2]);
            users.add(user);
        }
        return users;
    }

    public static ArrayList<Song> loadSongs() throws FileNotFoundException, IOException {
        ArrayList<Song> songs =new ArrayList<>();
        ArrayList<String> content = UtilFile.readFile(ROUTE_FILE_SONGS);
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);
            Song song = new Song();
            song.setId(line.split("@@")[0]);
            song.setName(line.split("@@")[1]);
            song.setAlbumName(line.split("@@")[2]);
            song.setAnio(Integer.parseInt(line.split("@@")[3]));
            song.setDuration(Double.parseDouble(line.split("@@")[4]));
            song.setGenre(Genre.valueOf(line.split("@@")[5]));
            song.setUrl(line.split("@@")[6]);
            song.setCaratula(new File(line.split("@@")[7]));
            song.setNameArtist(line.split("@@")[8]);
            songs.add(song);
        }
        return songs;
    }

    public static ObservableList<Song> loadSongsUser() throws FileNotFoundException, IOException {
        ObservableList<Song> songs = FXCollections.observableArrayList();
        ArrayList<String> content = UtilFile.readFile(ROUTE_FILE_SONGSUSER);
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);
            Song song = new Song();
            song.setId(line.split("@@")[0]);
            song.setName(line.split("@@")[1]);
            song.setAlbumName(line.split("@@")[2]);
            song.setAnio(Integer.parseInt(line.split("@@")[3]));
            song.setDuration(Double.parseDouble(line.split("@@")[4]));
            song.setGenre(Genre.valueOf(line.split("@@")[5]));
            song.setUrl(line.split("@@")[6]);
            song.setCaratula(new File(line.split("@@")[7]));
            songs.add(song);
        }
        return songs;
    }

    public static void saveUser(ArrayList<User> users) throws IOException, UserExceptions {
        String content = "";
        for(User user: users) {
            content+= user.getUsername() + "@@" + user.getPassword() + "@@" +
                    user.getEmail() + "@@" + user.getSongsUserList() + "\n";
        }
        UtilFile.saveFile(ROUTE_FILE_USERS, content, false);
    }

    public static void saveAdministrator(ArrayList<Administrator> administrators) throws IOException, UserExceptions {
        String content = "";
        for(Administrator administrator: administrators) {
            content+= administrator.getUsername() + "@@" + administrator.getPassword() + "@@";
        }
        UtilFile.saveFile(ROUTE_FILE_ADMINISTRATOR, content, false);
    }

    public static void saveSongs(ArrayList<Song> songs) throws IOException, UserExceptions {
        String content = "";
        for(Song song: songs) {
            content+= song.getId() + "@@" + song.getName() + "@@" + song.getAlbumName() + "@@"
                    + song.getAnio() + "@@" + song.getDuration() + "@@" + song.getGenre() + "@@"
                    + song.getUrl() + "@@" + song.getCaratula() + "@@" + song.getNameArtist();
            content += "\n";
        }
        UtilFile.saveFile(ROUTE_FILE_SONGS, content, false);
    }

    public static void saveSongUser(ObservableList<Song> songs) throws IOException, UserExceptions {
        String content = "";


        for(Song song: songs) {
            content+= song.getId() + "@@" + song.getName() + "@@" + song.getAlbumName() + "@@"
                    + song.getAnio() + "@@" + song.getDuration() + "@@" + song.getGenre() + "@@"
                    + song.getUrl() + "@@" + song.getCaratula() + "@@" + song.getNameArtist();
            content += "\n";
        }

        UtilFile.saveFile(ROUTE_FILE_SONGSUSER, content, false);
    }

    public static void saveArtists(ArrayList<Artist> artists) throws IOException, UserExceptions {
        String content = "";
        for(Artist artist: artists) {
            content += artist.getId() + "@@" + artist.getName() + "@@" + artist.getNationality() + "@@"
                    + artist.getSongsList() + "@@" + artist.isGroup() + "@@" + artist.getCounter();
            content += "\n";
        }
        UtilFile.saveFile(ROUTE_FILE_ARTIST, content, false);
    }

    public static ArrayList<Artist> loadArtist() throws FileNotFoundException, IOException {
        ArrayList<Artist> artists = new ArrayList<>();
        ArrayList<String> content = UtilFile.readFile(ROUTE_FILE_ARTIST);
        String line = "";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);
            Artist artist = new Artist();
            artist.setId(line.split("@@")[0]);
            artist.setName(line.split("@@")[1]);
            artist.setNationality(line.split("@@")[2]);
            artist.setSongsList(null);
            artist.setGroup(Boolean.valueOf(line.split("@@")[4]));
            artist.setCounter(Integer.parseInt(line.split("@@")[5]));
            artists.add(artist);
        }
        return artists;
    }


}