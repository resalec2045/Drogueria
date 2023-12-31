package Controller;
import Models.Producto.Producto;
import Models.Reportes.*;
import Models.turnos.Turnos;
import Utils.*;
import daoController.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;
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
    private Button btnTurnos;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnInformes;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnBuscarElemento;
    @FXML
    private TextField fieldElemento;
    @FXML
    public VBox containerCards;
    @FXML
    private ChoiceBox choiceInforme;

    private int paginaActual = 1;

    ProductoController productoController = new ProductoController();
    FacturaController facturaController = new FacturaController();
    DomicilioController domicilioController = new DomicilioController();
    TurnosController turnosController = new TurnosController();
    ClienteController clienteController = new ClienteController();
    EmpleadoController empleadoController = new EmpleadoController();
    PersonaController personaController = new PersonaController();
    VentasController ventasController = new VentasController();
    ProveedorController proveedorController = new ProveedorController();


    List<Producto> productos = productoController.listarProductos();
    List<Factura> facturas = facturaController.listarFacturas();
    List<Domicilio> domicilios = domicilioController.listarDomicilios();
    List<Turnos> turnos = turnosController.listarTurnos();

    String pressedStyle = "-fx-border-color: purple;  -fx-border-width: 2px;  -fx-border-radius: 2px;";
    ObservableList<FXMLLoader> arrayListProducts = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayFacturas = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayDomicilio = FXCollections.observableArrayList();
    ObservableList<FXMLLoader> arrayTurnos = FXCollections.observableArrayList();
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

        paginaActual = 3;
        btnBuscarElemento.setVisible(true);
        fieldElemento.setVisible(true);
        btnCrear.setVisible(true);

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);

        modelFactoryController.sectionCurrent = "Artistas";
        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < domicilios.size(); i++) {
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
        btnTurnos.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
    }

    @FXML
    void showTurnos() {

        paginaActual = 4;
        btnBuscarElemento.setVisible(true);
        fieldElemento.setVisible(true);
        btnCrear.setVisible(true);

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);

        modelFactoryController.sectionCurrent = "Artistas";
        modelFactoryController.isArtist = new SimpleBooleanProperty(true);
        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < turnos.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TurnosCard-view.fxml"));
            arrayTurnos.add(i, loader);
            modelFactoryController.setCurrentTurno(turnos.get(i));
            try {
                containerCards.getChildren().add(arrayTurnos.get(i).load());
            } catch (IOException e) {
            }
        }

        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnInformes.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnTurnos.setStyle(pressedStyle);
    }

    @FXML
    public void showFactura() {

        paginaActual = 2;
        btnBuscarElemento.setVisible(true);
        fieldElemento.setVisible(true);
        btnCrear.setVisible(true);

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
        btnTurnos.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");

    }

    @FXML
    void showProducts() {

        paginaActual = 1;
        btnBuscarElemento.setVisible(true);
        fieldElemento.setVisible(true);

        choiceInforme.setVisible(false);
        btnBuscar.setVisible(false);
        btnCrear.setVisible(true);

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
        btnTurnos.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");

    }

    @FXML
    public void showInformes() {

        paginaActual = 5;
        btnBuscarElemento.setVisible(false);
        fieldElemento.setVisible(false);
        btnCrear.setVisible(false);

        containerCards.getChildren().removeAll(containerCards.getChildren());

        choiceInforme.setVisible(true);
        btnBuscar.setVisible(true);

        btnArtists.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnAllSongs.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnDomicilio.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");
        btnInformes.setStyle(pressedStyle);
        btnTurnos.setStyle("-fx-border-color: none;  -fx-border-width: none;  -fx-border-radius: none;");

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
    void crearElemento() throws IOException {


        switch (paginaActual){
            case 1:
                abrirVistaCrear("productCardCrear-view.fxml");
                break;
            case 2:
                abrirVistaCrear("FacturaCardCrear-view.fxml");
                break;
            case 3:
                abrirVistaCrear("DomiciliosCardCrear-view.fxml");
                break;
            case 4:
                abrirVistaCrear("TurnosCardCrear-view.fxml");
                break;
            default:
                System.out.println("No se ha seleccionado una pagina");
                break;
        }
    }

    void abrirVistaCrear(String vista){
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource(vista));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 584, 255);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getStage.stage.setTitle(null);
        getStage.stage.setScene(scene);
        getStage.stage.centerOnScreen();
        getStage.stage.show();
    }
    @FXML
    void buscarElemento() throws IOException {

        if (paginaActual == 1) {
            productos = productoController.BuscarProductoPorNombre(fieldElemento.getText());

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
        } else if (paginaActual == 2) {

            facturas = facturaController.searchFactura(fieldElemento.getText());

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
        } else if (paginaActual == 3) {

            domicilios = domicilioController.buscarDomicilioPorID(fieldElemento.getText());

            containerCards.getChildren().removeAll(containerCards.getChildren());

            for (int i = 0; i < domicilios.size(); i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DomiciliosCard-view.fxml"));
                arrayDomicilio.add(i, loader);
                modelFactoryController.setCurrentDomilicio(domicilios.get(i));
                try {
                    containerCards.getChildren().add(arrayDomicilio.get(i).load());
                } catch (IOException e) {
                }
            }
        } else if (paginaActual == 4) {

        turnos = turnosController.buscarDomicilioPorID(fieldElemento.getText());

        containerCards.getChildren().removeAll(containerCards.getChildren());

        for (int i = 0; i < turnos.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TurnosCard-view.fxml"));
            arrayTurnos.add(i, loader);
            modelFactoryController.setCurrentTurno(turnos.get(i));
            try {
                containerCards.getChildren().add(arrayTurnos.get(i).load());
            } catch (IOException e) {
            }
        }
    }

    }


    @FXML
    public void navToLogin() {
        NavBar navBar = new NavBar();
        navBar.navigateToLogin();
    }

//    LISTAR INFORMES

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
            case "ListarClienteConMasComprasPrimerSemestre":
                List<Object> l8 = Collections.singletonList(clienteController.ListarClienteConMasComprasPrimerSemestre());
                addlistarInformes(l8);
                break;
            case "ListarProveedoresCategoriaMasVendida":
                List<Object> l9 = Collections.singletonList(proveedorController.ListarProveedoresCategoriaMasVendida());
                addlistarInformes(l9);
                break;
            case "ListarEmleadoConMasHoras":
                List<Object> l10 = Collections.singletonList(empleadoController.ListarEmleadoConMasHoras());
                addlistarInformes(l10);
                break;
            default:
                System.out.println("No se ha seleccionado un informe");
                break;
        }

    }

}
