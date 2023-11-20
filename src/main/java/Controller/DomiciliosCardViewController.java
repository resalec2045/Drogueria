package Controller;

import Models.Reportes.Domicilio;
import Models.Reportes.Factura;
import Models.Storify;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class DomiciliosCardViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private ImageView image;

    @FXML
    private VBox contentImage;

    @FXML
    private HBox idProducto;

    @FXML
    private Text coddomicilio;
    @FXML
    private Text horaenvio;
    @FXML
    private Text direccion;
    @FXML
    private Text fechafacturacion;
    @FXML
    private Text total;


    Storify storify = ModelFactoryController.getInstance().getStorify();

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentDomilicio());
        setDomicilio();
    }

    private void setDomicilio() {
        Domicilio domicilio = modelFactoryController.getCurrentDomilicio();
        coddomicilio.setText(domicilio.getCoddomicilio());
        String path = "file:" + "src/main/resources/imagenes/caratulas/envio.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        horaenvio.setText("Hora de envio: " + domicilio.getHoraenvio());
        direccion.setText("Direccion: " + domicilio.getDireccion());
        fechafacturacion.setText("Fecha: " + domicilio.getFechafacturacion());
        total.setText("Total: " + domicilio.getTotal());
    }

}
