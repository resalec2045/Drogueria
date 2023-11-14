package Controller;
import Exceptions.StorifyExceptions;
import Models.Artist.BinaryNode;
import Models.Artist.BinarySearchTree;
import Models.Products.Producto;
import Models.Song.ArtistSongs.SongsArtistList;
import Models.Song.UserSongs.SongsUserList;
import Utils.ModelFactoryController;
import Utils.NavBar;
import daoController.ProductoController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;


public class HomePageController {

    ModelFactoryController modelFactoryController;
    @FXML
    private TextField searchField;
    @FXML
    private Button btnAllSongs;
    @FXML
    private Button btnArtists;
    @FXML
    private Button btnFavorites;
    @FXML
    public VBox containerCards;

    ProductoController productoController = new ProductoController();

    List<Producto> productos = productoController.listarProductos();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";

    ObservableList<FXMLLoader> arrayListProducts = FXCollections.observableArrayList();

//    BinarySearchTree binarySearchTree = new BinarySearchTree();
//
//    SongsUserList songsUserList = new SongsUserList();
//
//    SongsArtistList songsArtistList = new SongsArtistList();
//
//    BinaryNode binaryNode;

    @FXML
    void initialize() throws IOException, StorifyExceptions {
//
        modelFactoryController = ModelFactoryController.getInstance();

        productos = productoController.listarProductos();

//        for (int i = 0; i < modelFactoryController.getStorify().getArtists().size(); i++) {
//            binaryNode = new BinaryNode(modelFactoryController.getStorify().getArtists().get(i));
//            binarySearchTree.arrayToBinaryTree(binaryNode, modelFactoryController.getStorify().getArtists());
//        }

        btnAllSongs.setStyle(pressedStyle);
        modelFactoryController.sectionCurrent = "Canciones";

        addCardsToView();
    }

    public void addCardsToView() throws IOException, StorifyExceptions {

//        modelFactoryController.isArtist = new SimpleBooleanProperty(false);

        containerCards.getChildren().removeAll(containerCards.getChildren());
        arrayListProducts.removeAll();

        for (int i = 0; i < productos.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductCard-view.fxml"));
            arrayListProducts.add(i, loader);
            modelFactoryController.setCurrentSong(productos.get(i));
            try {
                containerCards.getChildren().add(arrayListProducts.get(i).load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void handleClickBuscador() throws Exception {
//        modelFactoryController.isArtist.setValue(true);
//        boolean search = false;
//
//        for (int i = 0; i < modelFactoryController.getStorify().getArtists().size() && !search; i++) {
//            binaryNode = new BinaryNode(modelFactoryController.getStorify().getArtists().get(i));
//
//            search = binarySearchTree.searchBinary(binaryNode,searchField.getText());
//
//            if (search) {
//                showSongsOfArtist(searchField.getText());
//            }
//        }
//
//        if (!search) {
//            containerCards.getChildren().removeAll(containerCards.getChildren());
//            arrayListSongs.removeAll();
//            Label label = new Label("No se han encontrado artistas que coincidan con el nombre ingresado en la búsqueda.");
//            label.setPrefWidth(containerCards.getPrefWidth());
//            label.setPrefHeight(50);
//            containerCards.getChildren().add(label);
//        }
    }

    private void showSongsOfArtist(String search) {
//        modelFactoryController.isArtist = new SimpleBooleanProperty(false);
//        containerCards.getChildren().removeAll(containerCards.getChildren());
//        arrayListSongs.removeAll();
//        songsUserList = songsUserList.searchSongByArtistName(search);
//        for (int i = 0; i < songsUserList.getSize(); i++) {
//            songsArtistList.add(songsUserList.circularToArray().get(i));
//        }
//
//        if (songsArtistList != null) {
//            for (int i = 0; i < songsArtistList.getSize(); i++) {
//
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductCard-view.fxml"));
//                    arrayListSongs.add(i, loader);
//                    modelFactoryController.setCurrentSong(songsUserList.circularToArray().get(i));
//                    try {
//                        containerCards.getChildren().add(arrayListSongs.get(i).load());
//                    } catch (IOException ignored) {
//                    }
//        }
//        }
    }

    @FXML
    void showFavorites() throws StorifyExceptions, IOException {
//        modelFactoryController.isArtist = new SimpleBooleanProperty(false);
//        modelFactoryController.sectionCurrent = "Favoritos";
//        containerCards.getChildren().removeAll(containerCards.getChildren());
//        if (containerCards.getChildren().size() != 0) {
//            arrayListSongs.removeAll();
//            showFavoritesSong();
//        } else {
//            showFavoritesSong();
//        }
//        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
//        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
//        btnFavorites.setStyle(pressedStyle);
    }

    private void showFavoritesSong() {
//        modelFactoryController.isArtist = new SimpleBooleanProperty(false);
//        for (int i = 0; i < modelFactoryController.getFavoriteSongs().size(); i++) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductCard-view.fxml"));
//            arrayListSongs.add(i, loader);
//            try {
//                modelFactoryController.setCurrentSong(modelFactoryController.getFavoriteSongs().get(i));
//                containerCards.getChildren().add(i, arrayListSongs.get(i).load());
//            } catch (IOException e) {
//            }
//        }
    }

    @FXML
    public void showArtists() {
//        modelFactoryController.sectionCurrent = "Artistas";
//        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
//        containerCards.getChildren().removeAll(containerCards.getChildren());
//        arrayListSongs.removeAll();
//        for (int i = 0; i < modelFactoryController.getStorify().getArtists().size(); i++) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("ArtisCard-view.fxml"));
//            arrayListSongs.add(i, loader);
//            modelFactoryController.setCurrentArtist(modelFactoryController.getStorify().getArtists().get(i));
//            try {
//                containerCards.getChildren().add(arrayListSongs.get(i).load());
//            } catch (IOException e) {
//            }
//        }
//
//        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
//        btnFavorites.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
//        btnArtists.setStyle(pressedStyle);

    }

    @FXML
    void showSongs() throws StorifyExceptions, IOException {

        modelFactoryController.isArtist = new SimpleBooleanProperty(false);
        modelFactoryController.sectionCurrent = "Canciones";
        containerCards.getChildren().removeAll(containerCards.getChildren());
        if (containerCards.getChildren().size() != 0) {
            arrayListProducts.removeAll();
            addCardsToView();
        } else {
            addCardsToView();
        }

        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnFavorites.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnAllSongs.setStyle(pressedStyle);

    }

    @FXML
    public void navToLogin() {
        NavBar navBar = new NavBar();
        navBar.navigateToLogin();
    }
}
