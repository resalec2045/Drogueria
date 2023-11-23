package Controller;

import Models.Reportes.Domicilio;
import Utils.ModelFactoryController;
import Utils.getStage;
import daoController.DomicilioController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class DomiciliosCardViewCrearController {

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
    private Button btnCrear;

    @FXML
    void insertarDomicilio() throws IOException {
        domicilioController.insertarDomicilio(new Domicilio(
                coddomicilio.getText(),
                horaenvio.getText(),
                direccion.getText()
        ));
        JOptionPane.showMessageDialog(null, "Domicilio insertado");

        //Obtener el Stage de la ventana actual
        Stage stage = (Stage) getStage.stage.getScene().getWindow();
        //Cerrar la ventana
        stage.close();
    }


}
