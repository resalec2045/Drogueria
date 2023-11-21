package Controller;


import Models.Producto.Producto;
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

public class ProductCardViewController {

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
    private Text codProducto;
    @FXML
    private HBox idProducto;

    @FXML
    void initialize(){
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentProduct().getCodproducto());
        setProducto();
    }

    private void setProducto() {
        Producto product = modelFactoryController.getCurrentProduct();
        nombreProducto.setText(product.getNombre());
        String path = "file:" + "src/main/resources/imagenes/caratulas/producto.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        descripcion.setText("Codigo: " + product.getDescripcion());
        precio.setText("Precio: " + product.getPrecio() + "");
        codProducto.setText("Codigo del producto: " + product.getCodproducto() + "");
    }

}
