package Models.Song.ArtistSongs;

import Models.Song.Song;

public class NodeSong {
    private Song data;
    private NodeSong prev;
    private NodeSong next;

    public NodeSong() { }

    public NodeSong(Song data) {
        this.data = data;
    }

    public void setPrev(NodeSong prev) {
        this.prev = prev;
    }

    public NodeSong getNext() {
        return next;
    }

    public void setNext(NodeSong next) {
        this.next = next;
    }

    public Song getData() {
        return data;
    }

}
