package Controller;


import Models.Producto.Producto;
import Utils.ModelFactoryController;
import daoController.ProductoController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;

public class ProductCardViewCrearController {

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
    void insertarProducto() throws IOException {
        productoController.insertarProducto(new Producto(
                Integer.parseInt(codProducto.getText()),
                nombreProducto.getText(),
                descripcion.getText(),
                Double.parseDouble(precio.getText())
        ));
        JOptionPane.showMessageDialog(null, "Producto insertado");

    }



}
