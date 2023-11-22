package Controller;


import Models.Producto.Producto;
import Models.Storify;
import Utils.ModelFactoryController;
import daoController.ProductoController;
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

public class ProductCardViewController {

    ModelFactoryController modelFactoryController;
    ProductoController productoController = new ProductoController();

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
    private TextField codProducto;
    @FXML
    private HBox idProducto;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnActualizar;

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
        descripcion.setText("" + product.getDescripcion());
        precio.setText("" + product.getPrecio());
        codProducto.setText("" + product.getCodproducto());
    }

    @FXML
    void eliminarProducto() throws IOException {
        productoController.deleteProduct(Integer.parseInt(idProducto.getId()));
        JOptionPane.showMessageDialog(null, "Producto eliminado");
    }

    @FXML
    void actualizarProducto() throws IOException {
        productoController.updateProduct(new Producto(Integer.parseInt(idProducto.getId()), nombreProducto.getText(), descripcion.getText(), Double.parseDouble(precio.getText())));
        JOptionPane.showMessageDialog(null, "Producto actualizado");
    }



}
