package Controller;

import Models.Reportes.Domicilio;
import Models.Reportes.Factura;
import Utils.ModelFactoryController;
import daoController.DomicilioController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;

public class DomiciliosCardViewController {

    ModelFactoryController modelFactoryController;
    DomicilioController domicilioController = new DomicilioController();

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
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentDomilicio().getCoddomicilio());
        setDomicilio();
    }

    private void setDomicilio() {
        Domicilio domicilio = modelFactoryController.getCurrentDomilicio();
        coddomicilio.setText(domicilio.getCoddomicilio());
        String path = "file:" + "src/main/resources/imagenes/caratulas/envio.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        horaenvio.setText("" + domicilio.getHoraenvio());
        direccion.setText("" + domicilio.getDireccion());
    }

    @FXML
    void eliminarDomicilio() throws IOException {
        domicilioController.eliminarDomicilio(idProducto.getId());
        JOptionPane.showMessageDialog(null, "Domicilio eliminada");
    }

    @FXML
    void actualizarDomicilio() throws IOException {
        domicilioController.actualizarDomicilio(new Domicilio(
                coddomicilio.getText(),
                horaenvio.getText(),
                direccion.getText()
        ));
        JOptionPane.showMessageDialog(null, "Domicilio actualizado");
    }


}
