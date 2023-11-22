package Controller;

import Models.Producto.Producto;
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
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;

public class FacturaCardViewController {

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
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentFacturas().getCodFactura());
        setFactura();
    }

    private void setFactura() {
        Factura factura = modelFactoryController.getCurrentFacturas();
        nombreProducto.setText(factura.getCodFactura());
        String path = "file:" + "src/main/resources/imagenes/caratulas/factura.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        descripcion.setText("" + factura.getFechaFacturacion());
        precio.setText("" + factura.getTotal());
    }

    @FXML
    void eliminarFactura() throws IOException {
        facturaController.deleteFactura(Integer.parseInt(idProducto.getId()));
        JOptionPane.showMessageDialog(null, "Factura eliminada");
    }

    @FXML
    void actualizarFactura() throws IOException {
        facturaController.updateFactura(new Factura(
                nombreProducto.getText(),
                descripcion.getText(),
                precio.getText()
        ));
        JOptionPane.showMessageDialog(null, "Factura actualizado");
    }



}
