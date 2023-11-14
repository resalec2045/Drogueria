package Models.Song.UserSongs;

import Models.Song.Producto;
import Utils.ModelFactoryController;

import java.io.Serializable;
import java.util.ArrayList;

public class SongsUserList implements Serializable {
    public static final long serialVersionUID = 1L;
    public CircularNodeSong head;

    ModelFactoryController modelFactoryController;

    public SongsUserList() {
        this.head = null;
    }

    public void add(Producto song) {
        CircularNodeSong nuevoNodo = new CircularNodeSong(song);
        if (head == null) {
            head = nuevoNodo;
            nuevoNodo.setNext(head);
        } else {
            CircularNodeSong ultimo = head;
            while (ultimo.getNext() != head) {
                ultimo = ultimo.getNext();
            }
            nuevoNodo.setNext(head);
            ultimo.setNext(nuevoNodo);
        }
    }

    public void remove(Producto song) {
        if (head == null) {
            return;
        }
        CircularNodeSong current = head;
        CircularNodeSong prev = null;
        while (current.getNext() != head) {
            if (current.getSong().equals(song)) {
                break;
            }
            prev = current;
            current = current.getNext();
        }
        if (current.getSong().equals(song)) {
            if (prev == null) {
                head = current.getNext();
            } else {
                prev.setNext(current.getNext());
            }
            return;
        }
    }


    public void arrayToCircular(ArrayList<Producto> songs) {
        for (Producto song : songs) {
            add(song);
        }
    }

    //metodo de lista circular a arraylist
    public ArrayList<Producto> circularToArray() {
        ArrayList<Producto> songs = new ArrayList<>();
        CircularNodeSong current = head;
        do {
            songs.add(current.getSong());
            current = current.getNext();
        } while (current != head);
        return songs;
    }

    public SongsUserList searchSongByArtistName (String artistName){

        modelFactoryController = ModelFactoryController.getInstance();

        ArrayList<Producto> songs = modelFactoryController.getStorify().getSongs();

        SongsUserList songsUserList = new SongsUserList();

        arrayToCircular(songs);

            if (head == null) {
                return null;
            }

            CircularNodeSong current = head;

            do {
                if (current.getSong().getNameArtist().equals(artistName)) {
                    songsUserList.add(current.getSong());
                }
                current = current.getNext();
            } while (current != head);

            return songsUserList;
    }
    //metodo para saber el tamaño de la lista
    public int getSize() {
        int size = 0;
        CircularNodeSong current = head;
        do {
            size++;
            current = current.getNext();
        } while (current != head);
        return size;
    }

    public String searchVideo(String id){

        if (head == null) {
            return null;
        }

        CircularNodeSong current = head;

        do {
            if (current.getSong().getId().equals(id)) {
                return current.getSong().getUrl();
            }
            current = current.getNext();
        } while (current != head);

        return "No se encontró el video";
    }

    public Producto searchSong(String id){

        ArrayList<Producto> songs = new ArrayList<>();

        if (head == null) {
            return null;
        }

        CircularNodeSong current = head;

        do {
            if (current.getSong().getId().equals(id)) {
                return current.getSong();
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    public String searchNameArtist(String id){

        modelFactoryController = ModelFactoryController.getInstance();

        ArrayList<Producto> songs = modelFactoryController.getStorify().getSongs();

        arrayToCircular(songs);

        if (head == null) {
            return null;
        }

        CircularNodeSong current = head;

        do {
            if (current.getSong().getId().equals(id)) {
                return current.getSong().getNameArtist();
            }
            current = current.getNext();
        } while (current != head);


        return null;

    }

}
