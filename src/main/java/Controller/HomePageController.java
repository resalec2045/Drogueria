package Controller;
import Exceptions.StorifyExceptions;
import Models.Producto.Producto;
import Models.Reportes.Domicilio;
import Models.Reportes.Factura;
import Utils.ModelFactoryController;
import Utils.NavBar;
import daoController.DomicilioController;
import daoController.FacturaController;
import daoController.ProductoController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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
    private Button btnDomicilio;
    @FXML
    private Button btnInformes;
    @FXML
    public VBox containerCards;

    ProductoController productoController = new ProductoController();
    FacturaController facturaController = new FacturaController();
    DomicilioController domicilioController = new DomicilioController();

    List<Producto> productos = productoController.listarProductos();
    List<Factura> facturas = facturaController.listarFacturas();
    List<Domicilio> domicilios = domicilioController.listarDomicilios();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";
    ObservableList<FXMLLoader> arrayListProducts = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayFacturas = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayDomicilio = FXCollections.observableArrayList();


    @FXML
    void initialize() throws IOException, StorifyExceptions {

        modelFactoryController = ModelFactoryController.getInstance();

        productos = productoController.listarProductos();

        btnAllSongs.setStyle(pressedStyle);
        modelFactoryController.sectionCurrent = "Canciones";

        addCardsToView();
    }

    @FXML
    private void handleClickBuscador() throws Exception {

        productos = productoController.BuscarProductoPorNombre(searchField.getText());

        for (Producto p : productos) {
            System.out.println(p.getNombre());
        }

    }
    @FXML
    void showDomicilio() {
        modelFactoryController.sectionCurrent = "Artistas";
        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < facturas.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DomiciliosCard-view.fxml"));
            arrayDomicilio.add(i, loader);
            modelFactoryController.setCurrentDomilicio(domicilios.get(i));
            try {
                containerCards.getChildren().add(arrayDomicilio.get(i).load());
            } catch (IOException e) {
            }
        }

        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle(pressedStyle);
    }

    @FXML
    public void showFactura() {

        modelFactoryController.sectionCurrent = "Artistas";
        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < facturas.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FacturaCard-view.fxml"));
            arrayFacturas.add(i, loader);
            modelFactoryController.setCurrentFacturas(facturas.get(i));
            try {
                containerCards.getChildren().add(arrayFacturas.get(i).load());
            } catch (IOException e) {
            }
        }

        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnArtists.setStyle(pressedStyle);

    }

    @FXML
    void showProducts() throws StorifyExceptions, IOException {

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
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnAllSongs.setStyle(pressedStyle);

    }

    @FXML
    public void showInformes() {

    }

    public void addCardsToView() throws IOException, StorifyExceptions {

//        modelFactoryController.isArtist = new SimpleBooleanProperty(false);

        containerCards.getChildren().removeAll(containerCards.getChildren());
        arrayListProducts.removeAll();

        for (int i = 0; i < productos.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductCard-view.fxml"));
            arrayListProducts.add(i, loader);
            modelFactoryController.setCurrentProduct(productos.get(i));
            try {
                containerCards.getChildren().add(arrayListProducts.get(i).load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void navToLogin() {
        NavBar navBar = new NavBar();
        navBar.navigateToLogin();
    }


//    private void showSongsOfArtist(String search) {
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
//    }

//    private void showFavoritesSong() {
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
//    }


}
