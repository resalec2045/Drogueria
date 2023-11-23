package Controller;

import Models.turnos.Turnos;
import Utils.ModelFactoryController;
import Utils.NavBar;
import daoController.TurnosController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.io.IOException;

public class TurnosCardCrearVIewController {
    ModelFactoryController modelFactoryController;
    TurnosController turnosController = new TurnosController();

    @FXML
    private ImageView image;
    @FXML
    private VBox contentImage;
    @FXML
    private HBox idProducto;
    @FXML
    private TextField codturno;
    @FXML
    private TextField tipohorario;
    @FXML
    private TextField empleado_persona_idpersona;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnCrear;

    @FXML
    private Button btnCrear1;

    @FXML
    void insertarTurno() throws IOException {
        turnosController.insertarTurnos(new Turnos(
                Integer.parseInt(codturno.getText()),
                tipohorario.getText(),
                Integer.parseInt(empleado_persona_idpersona.getText())
        ));
        JOptionPane.showMessageDialog(null, "Turno insertado");

        NavBar navBar = new NavBar();
        navBar.navigateToHomePage();

    }
    @FXML
    void cancelar() throws IOException {

        NavBar navBar = new NavBar();
        navBar.navigateToHomePage();

    }
}
