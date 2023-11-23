package Controller;

import Models.Reportes.Factura;
import Utils.ModelFactoryController;
import daoController.FacturaController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;

public class FacturaCardViewCrearController {

    ModelFactoryController modelFactoryController;
    FacturaController facturaController = new FacturaController();

    @FXML
    private ImageView image;
    @FXML
    private VBox contentImage;
    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField precio;
    @FXML
    private HBox idProducto;

    @FXML
    private Button btnCrear;

    @FXML
    void insertarFactura() throws IOException {
        facturaController.insertarFactura(new Factura(
                nombreProducto.getText(),
                descripcion.getText(),
                precio.getText()
        ));
        JOptionPane.showMessageDialog(null, "Factura insertada");

    }


}
