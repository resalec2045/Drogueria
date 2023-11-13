package Models.Artist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearchTree implements Serializable {
    public static final long serialVersionUID = 1L;
    BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insertar(Artist valor) {
        root = insertarValor(root, valor);
    }

    private BinaryNode insertarValor(BinaryNode actual, Artist valor) {
        if (actual == null) {
            return new BinaryNode(valor);
        }
        if (valor.getName().length() < actual.artist.getName().length()) {
            actual.left = insertarValor(actual.left, valor);
        } else if (valor.getName().length() > actual.artist.getName().length()) {
            actual.right = insertarValor(actual.right, valor);
        }
        return actual;
    }

    public void arrayToBinaryTree(BinaryNode node, ArrayList<Artist> artists) {
        Collections.sort(artists, new Comparator<Artist>() {
            @Override
            public int compare(Artist artist1, Artist artist2) {
                return artist1.getName().compareTo(artist2.getName());
            }
        });

        for (Artist artist : artists) {
            insertValue(node, artist);
        }
    }

    private void insertValue(BinaryNode node, Artist artist) {
        int comparison = artist.getName().compareTo(node.artist.getName());

        if (comparison < 0) {
            if (node.left == null) {
                node.left = new BinaryNode(artist);
            } else {
                insertValue(node.left, artist);
            }
        } else if (comparison > 0) {
            if (node.right == null) {
                node.right = new BinaryNode(artist);
            } else {
                insertValue(node.right, artist);
            }
        } else {
        }
    }


    public boolean searchBinary(BinaryNode nodo, String nameArtist) {

        if (nodo == null) {
            return false;
        }
        if (nameArtist.equals(nodo.getArtist().getName())) {
            return true;
        } else if (nameArtist.compareTo(nodo.getArtist().getName()) < 0) {
            return searchBinary(nodo.left, nameArtist);
        } else {
            return searchBinary(nodo.right, nameArtist);
        }
    }
    
}



