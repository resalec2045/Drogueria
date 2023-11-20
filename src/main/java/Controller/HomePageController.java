package Controller;
import Models.Producto.Producto;
import Models.Reportes.*;
import Utils.ModelFactoryController;
import Utils.NavBar;
import Utils.PdfGenerator;
import Utils.TiposInformes;
import daoController.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomePageController {

    ModelFactoryController modelFactoryController;
    @FXML
    private Button btnAllSongs;
    @FXML
    private Button btnArtists;
    @FXML
    private Button btnDomicilio;
    @FXML
    private Button btnInformes;
    @FXML
    private Button btnBuscar;
    @FXML
    public VBox containerCards;
    @FXML
    private ChoiceBox choiceInforme;

    ProductoController productoController = new ProductoController();
    FacturaController facturaController = new FacturaController();
    DomicilioController domicilioController = new DomicilioController();
    ClienteController clienteController = new ClienteController();
    EmpleadoController empleadoController = new EmpleadoController();
    PersonaController personaController = new PersonaController();
    VentasController ventasController = new VentasController();


    List<Producto> productos = productoController.listarProductos();
    List<Factura> facturas = facturaController.listarFacturas();
    List<Domicilio> domicilios = domicilioController.listarDomicilios();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";
    ObservableList<FXMLLoader> arrayListProducts = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayFacturas = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayDomicilio = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayInformes = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        modelFactoryController = ModelFactoryController.getInstance();

        productos = productoController.listarProductos();

        btnAllSongs.setStyle(pressedStyle);
        modelFactoryController.sectionCurrent = "Canciones";

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);
        choiceInforme.setItems(FXCollections.observableArrayList(TiposInformes  .values()));

        addCardsToView();
    }

    @FXML
    void showDomicilio() {

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);

        modelFactoryController.sectionCurrent = "Artistas";
        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < facturas.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DomiciliosCard-view.fxml"));
            arrayDomicilio.add(i, loader);
            modelFactoryController.setCurrentDomilicio(domicilios.get(i));
            try {
                containerCards.getChildren().add(arrayDomicilio.get(i).load());
            } catch (IOException e) {
            }
        }

        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnInformes.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle(pressedStyle);
    }

    @FXML
    public void showFactura() {

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);

        modelFactoryController.sectionCurrent = "Artistas";
        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < facturas.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FacturaCard-view.fxml"));
            arrayFacturas.add(i, loader);
            modelFactoryController.setCurrentFacturas(facturas.get(i));
            try {
                containerCards.getChildren().add(arrayFacturas.get(i).load());
            } catch (IOException e) {
            }
        }

        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnInformes.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnArtists.setStyle(pressedStyle);

    }

    @FXML
    void showProducts() {

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);

        modelFactoryController.isArtist = new SimpleBooleanProperty(false);
        modelFactoryController.sectionCurrent = "Canciones";
        containerCards.getChildren().removeAll(containerCards.getChildren());
        if (containerCards.getChildren().size() != 0) {
            arrayListProducts.removeAll();
            addCardsToView();
        } else {
            addCardsToView();
        }

        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnInformes.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnAllSongs.setStyle(pressedStyle);

    }

    @FXML
    public void showInformes() {

        containerCards.getChildren().removeAll(containerCards.getChildren());

        choiceInforme.setVisible(true);
        btnBuscar.setVisible(true);

        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnInformes.setStyle(pressedStyle);

    }

    @FXML
    public void buscarInforme() {

        String informe = choiceInforme.getValue().toString();

        switch (informe) {
            case "listarInformesPorEstado":
                List<Object> l1 = Collections.singletonList(clienteController.listarInformesPorEstado("pendiente"));
                addlistarInformes(l1);
                break;
            case "listarInformesTrabajoPorHorasEmpleados":
                List<Object> l2 = Collections.singletonList(empleadoController.listarInformesTrabajoPorHorasEmpleados());
                addlistarInformes(l2);
                break;
            case "listarEmpleadoSalario":
                List<Object> l3 = Collections.singletonList(empleadoController.listarEmpleadoSalario());
                PdfGenerator.generarPdf((List<Object>) l3.get(0), "listarEmpleadoSalario", "Empleado", "Salario");
                addlistarInformes(l3);
                break;
            case "listarInformesVentas":
                List<Object> l4 = Collections.singletonList(ventasController.listarInformesVentas());
                addlistarInformes(l4);
                break;
            case "listarInventarioPorProducto":
                //        TODO: REVISAR EL LISTARINVENTARIOPORPRODUCTO
                List<Object> l5 = Collections.singletonList(productoController.listarInventarioPorProducto());
                addlistarInformes(l5);
                break;
            case "listarCantidadProductoStock":
                List<Object> l6 = Collections.singletonList(productoController.listarCantidadProductoStock());
                PdfGenerator.generarPdf((List<Object>) l6.get(0), "listarCantidadProductoStock", "Productos", "Stock");
                addlistarInformes(l6);
                break;
            case "listarVentasPorMes":
                List<Object> l7 = Collections.singletonList(ventasController.listarVentasPorMes());
                PdfGenerator.generarPdf((List<Object>) l7.get(0), "listarVentasPorMes", "Mes", "Ventas");
                addlistarInformes(l7);
                break;
            case "ELEMENTO_8":
                System.out.println("ELEMENTO_8");
                break;
            case "ELEMENTO_9":
                System.out.println("ELEMENTO_9");
                break;
            case "ELEMENTO_10":
                System.out.println("ELEMENTO_10");
                break;
            default:
                System.out.println("No se ha seleccionado un informe");
                break;
        }

    }

    public void addlistarInformes(List<Object> informe) {
        containerCards.getChildren().removeAll(containerCards.getChildren());
        arrayInformes.removeAll();

        ArrayList arrayList = (ArrayList) informe.get(0);

        for (int i = 0; i < arrayList.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VariableCard-view.fxml"));
            arrayInformes.add(i, loader);
            modelFactoryController.setCurrentInforme(arrayList.get(i));
            try {
                containerCards.getChildren().add(arrayInformes.get(i).load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void addCardsToView() {

        containerCards.getChildren().removeAll(containerCards.getChildren());
        arrayListProducts.removeAll();

        for (int i = 0; i < productos.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductCard-view.fxml"));
            arrayListProducts.add(i, loader);
            modelFactoryController.setCurrentProduct(productos.get(i));
            try {
                containerCards.getChildren().add(arrayListProducts.get(i).load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void navToLogin() {
        NavBar navBar = new NavBar();
        navBar.navigateToLogin();
    }

//    LISTAR INFORMES


}
