package Models.Song.ArtistSongs;

import Models.Artist.Artist;
import Models.Song.Producto;

import java.io.Serializable;
import java.util.ArrayList;

public class SongsArtistList implements Serializable {

    public static final long serialVersionUID = 1L;
    private NodeSong headSong;
    private NodeSong tailSong;

    public int size;

    public SongsArtistList() { }

    public void add(Producto data) {
        NodeSong newNode = new NodeSong(data);
        if (tailSong == null) {
            headSong = tailSong = newNode;
        } else {
            newNode.setPrev(tailSong);
            tailSong.setNext(newNode);
            tailSong = newNode;
        }
        size ++;
    }

    //metodo para convertir un arraylist a una lista doblemente enlazada
    public void arrayToDoubleLinked(ArrayList<Producto> songs) {
        for (Producto song : songs) {
            add(song);
        }
    }

    //metodo para buscar las canciones de un artista, recibe su nombre y retorna un arraylist con las canciones
    public ArrayList<Producto> searchSongsByNameArtist (String nameArtist) {
        ArrayList<Producto> songs = new ArrayList<>();
        NodeSong current = headSong;
        while (current != null) {
            if (current.getData().getNameArtist().equals(nameArtist)) {
                songs.add(current.getData());
            }
            current = current.getNext();
        }
        return songs;
    }

    //metodo para buscar el nombre del artista mediante su id
    public String searchNameArtistById (String id, ArrayList<Artist> artists) {
        for (Artist artist : artists) {
            if (artist.getId().equals(id)) {
                return artist.getName();
            }
        }
        return "No se pudo encontrar el nombre mediante el id";
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
