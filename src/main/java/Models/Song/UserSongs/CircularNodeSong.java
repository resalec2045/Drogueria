package Models.Song.UserSongs;

import Models.Song.Song;

import java.io.Serializable;

public class CircularNodeSong implements Serializable {
    public static final long serialVersionUID = 1L;
    private Song song;
    private CircularNodeSong next;
    public CircularNodeSong() {}

    public CircularNodeSong(Song song) {
        this.song = song;
        this.next = null;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public CircularNodeSong getNext() {
        return next;
    }

    public void setNext(CircularNodeSong next) {
        this.next = next;
    }
}
