package Controller;

import Models.Reportes.Factura;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FacturaCardViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private ImageView image;
    @FXML
    private VBox contentImage;
    @FXML
    private Text nombreProducto;
    @FXML
    private Text descripcion;
    @FXML
    private Text precio;
    @FXML
    private HBox idProducto;

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentFacturas());
        setFactura();
    }

    private void setFactura() {
        Factura factura = modelFactoryController.getCurrentFacturas();
        nombreProducto.setText(factura.getCodFactura());
        String path = "file:" + "src/main/resources/imagenes/caratulas/factura.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        descripcion.setText("Fecha: " + factura.getFechaFacturacion());
        precio.setText("Total: " + factura.getTotal());
    }

}
