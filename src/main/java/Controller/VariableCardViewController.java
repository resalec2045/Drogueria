package Controller;

import Models.Producto.Producto;
import Models.Reportes.*;
import Models.Storify;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class VariableCardViewController {

    ModelFactoryController modelFactoryController;

    @FXML
    private ImageView image;
    @FXML
    private VBox contentImage;
    @FXML
    private HBox idProducto;

    @FXML
    private Text var1;
    @FXML
    private Text var2;
    @FXML
    private Text var3;
    @FXML
    private Text var4;
    @FXML
    private Text var5;
    @FXML
    private Text var6;

    Storify storify = ModelFactoryController.getInstance().getStorify();

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        idProducto.setId(""+modelFactoryController.getCurrentInforme());
        setInforme();
    }

    private void setInforme() {
        Object informe = modelFactoryController.getCurrentInforme();

        if (informe instanceof InformeCliente) {
            System.out.println(informe);
            var1.setText(((InformeCliente) informe).getDescripcion());
            var2.setText(((InformeCliente) informe).getEstado());
            var3.setText(((InformeCliente) informe).getFecharegistro());
        } else if ( informe instanceof InformeTrabajoEmpleados ) {
            var1.setText(((InformeTrabajoEmpleados) informe).getPersona_idpersona() + "");
            var2.setText(((InformeTrabajoEmpleados) informe).getNombre_empleado());
            var3.setText(((InformeTrabajoEmpleados) informe).getHoras_trabajadas() + "");
        } else if ( informe instanceof EmpleadoSalario ) {
            var1.setText(((EmpleadoSalario) informe).getPersona_idpersona() + "");
            var2.setText(((EmpleadoSalario) informe).getCargo_codcargo() + "");
            var3.setText(((EmpleadoSalario) informe).getHorastrabajadas() + "");
            var4.setText(((EmpleadoSalario) informe).getSalario() + "");
        } else if ( informe instanceof Venta ) {
            var1.setText(((Venta) informe).getCodproducto() + "");
            var2.setText(((Venta) informe).getProducto() + "");
            var3.setText(((Venta) informe).getCantidad_vendida() + "");
            var4.setText(((Venta) informe).getTotal_venta() + "");
        } else if ( informe instanceof InventarioProducto) {
            var1.setText(((InventarioProducto) informe).getCodinventario() + "");
            var2.setText(((InventarioProducto) informe).getNombreproducto() + "");
            var3.setText(((InventarioProducto) informe).getFecha() + "");
            var4.setText(((InventarioProducto) informe).getResponsable() + "");
            var5.setText(((InventarioProducto) informe).getNombre() + "");
            var6.setText(((InventarioProducto) informe).getCantidad() + "");
        } else if (informe instanceof CantidadProductoStock ){
            var1.setText(((CantidadProductoStock) informe).getCodinventario() + "");
            var2.setText(((CantidadProductoStock) informe).getProducto() + "");
            var3.setText(((CantidadProductoStock) informe).getCantidad_en_stock() + "");
        } else if (informe instanceof VentasMes) {
            var1.setText(((VentasMes) informe).getMes() + "");
            var2.setText(((VentasMes) informe).getTotalVentas() + "");
        }

    }

}
