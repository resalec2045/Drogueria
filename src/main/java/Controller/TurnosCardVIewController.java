package Controller;

import Models.Reportes.Domicilio;
import Models.turnos.Turnos;
import Utils.ModelFactoryController;
import daoController.DomicilioController;
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

public class TurnosCardVIewController {
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
    private Button btnActualizar;

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentTurno().getCodturno());
        setTurnos();
    }

    private void setTurnos() {
        Turnos turnos = modelFactoryController.getCurrentTurno();
        codturno.setText(turnos.getCodturno()+"");
        String path = "file:" + "src/main/resources/imagenes/caratulas/envio.png";
        Image image1 = new Image(path);
        image.setImage(image1);
        tipohorario.setText(turnos.getTipohorario());
        empleado_persona_idpersona.setText("" + turnos.getEmpleado_persona_idpersona());
    }

    @FXML
    void eliminarTurnos() throws IOException {
        turnosController.eliminarTurnos(idProducto.getId());
        JOptionPane.showMessageDialog(null, "turno eliminada");
    }

    @FXML
    void actualizarTurnos() throws IOException {
        turnosController.actualizarDomicilio(new Turnos(
                Integer.parseInt(codturno.getText()),
                tipohorario.getText(),
                Integer.parseInt(empleado_persona_idpersona.getText()
                )
        ));
        JOptionPane.showMessageDialog(null, "turnos actualizado");
    }
}
