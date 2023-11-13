package Models.Artist;

import java.io.Serializable;

public class  BinaryNode implements Serializable {
    public static final long serialVersionUID = 1L;
    Artist artist;
    BinaryNode left, right;

    public BinaryNode() {

    }

    public BinaryNode(Artist artist) {
        this.artist = artist;
        this.left = null;
        this.right = null;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
