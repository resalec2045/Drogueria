package Models.Song.ArtistSongs;

import Models.Song.Producto;

public class NodeSong {
    private Producto data;
    private NodeSong prev;
    private NodeSong next;

    public NodeSong() { }

    public NodeSong(Producto data) {
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

    public Producto getData() {
        return data;
    }

}
