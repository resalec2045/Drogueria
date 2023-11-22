package Controller;

import Models.Reportes.Domicilio;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DomiciliosCardViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private ImageView image;
    @FXML
    private VBox contentImage;
    @FXML
    private HBox idProducto;
    @FXML
    private TextField coddomicilio;
    @FXML
    private TextField horaenvio;
    @FXML
    private TextField direccion;
    @FXML
    private TextField fechafacturacion;
    @FXML
    private TextField total;

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
