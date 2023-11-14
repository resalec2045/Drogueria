package Models.Song.UserSongs;

import Models.Song.Producto;

import java.io.Serializable;

public class CircularNodeSong implements Serializable {
    public static final long serialVersionUID = 1L;
    private Producto song;
    private CircularNodeSong next;
    public CircularNodeSong() {}

    public CircularNodeSong(Producto song) {
        this.song = song;
        this.next = null;
    }

    public Producto getSong() {
        return song;
    }

    public void setSong(Producto song) {
        this.song = song;
    }

    public CircularNodeSong getNext() {
        return next;
    }

    public void setNext(CircularNodeSong next) {
        this.next = next;
    }
}
