package Utils;

//import Models.Artist.Artist;
//import Models.Song.Producto;
import Models.Producto.Producto;
import Models.Reportes.Domicilio;
import Models.Reportes.Factura;
import Models.Storify;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelFactoryController {
    private Storify storify;

    private Producto currentProduct;

    private Factura currentFacturas;
    private Domicilio currentDomilicio;

    private ObservableList<Producto> favoriteSongs = FXCollections.observableArrayList();


    public SimpleBooleanProperty isArtist = new SimpleBooleanProperty(false);

    public String sectionCurrent = "Canciones";

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public Storify getStorify() {
        return storify;
    }

    public void setStorify(Storify storify) {
        this.storify = storify;
    }

    public Producto getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Producto currentProduct) {
        this.currentProduct = currentProduct;
    }


    public ObservableList<Producto> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(ObservableList<Producto> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    public Factura getCurrentFacturas() {
        return currentFacturas;
    }

    public void setCurrentFacturas(Factura currentVentas) {
        this.currentFacturas = currentVentas;
    }

    public Domicilio getCurrentDomilicio() {
        return currentDomilicio;
    }

    public void setCurrentDomilicio(Domicilio currentDomilicio) {
        this.currentDomilicio = currentDomilicio;
    }
}
