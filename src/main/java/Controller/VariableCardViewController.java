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
            var1.setText( "Descripcion: " + ((InformeCliente) informe).getDescripcion());
            var2.setText( "Estado: " + ((InformeCliente) informe).getEstado());
            var3.setText( "Fecha De Registro: " + ((InformeCliente) informe).getFecharegistro());
        } else if ( informe instanceof InformeTrabajoEmpleados ) {
            var1.setText( "ID Persona: " +  ((InformeTrabajoEmpleados) informe).getPersona_idpersona() + "");
            var2.setText( "Nombre Empleado: " +  ((InformeTrabajoEmpleados) informe).getNombre_empleado());
            var3.setText( "Horas Trabajadas: " + ((InformeTrabajoEmpleados) informe).getHoras_trabajadas());
        } else if ( informe instanceof EmpleadoSalario ) {
            var1.setText( "ID Persona: " + ((EmpleadoSalario) informe).getPersona_idpersona());
            var2.setText( "ID Cargo: " + ((EmpleadoSalario) informe).getCargo_codcargo());
            var3.setText( "Horas Trabajadas: " + ((EmpleadoSalario) informe).getHorastrabajadas());
            var4.setText( "Salario: " + ((EmpleadoSalario) informe).getSalario());
        } else if ( informe instanceof Venta ) {
            var1.setText( "ID Producto: " + ((Venta) informe).getCodproducto());
            var2.setText( "Nombre Producto: " + ((Venta) informe).getProducto());
            var3.setText( "Cantidad Vendida: " + ((Venta) informe).getCantidad_vendida());
            var4.setText( "Total Venta: " + ((Venta) informe).getTotal_venta());
        } else if ( informe instanceof InventarioProducto) {
            var1.setText( "ID Inventario: " + ((InventarioProducto) informe).getCodinventario());
            var2.setText( "Nombre Producto: " + ((InventarioProducto) informe).getNombreproducto());
            var3.setText( "Fecha:" + ((InventarioProducto) informe).getFecha());
            var4.setText( "Responsable: " + ((InventarioProducto) informe).getResponsable());
            var5.setText( "Nombre: " + ((InventarioProducto) informe).getNombre());
            var6.setText( "Cantidad: " + ((InventarioProducto) informe).getCantidad());
        } else if (informe instanceof CantidadProductoStock ){
            var1.setText( "ID Inventario: " + ((CantidadProductoStock) informe).getCodinventario());
            var2.setText( "Nombre: " + ((CantidadProductoStock) informe).getProducto());
            var3.setText( "Cantidad en Stock: " + ((CantidadProductoStock) informe).getCantidad_en_stock());
        } else if (informe instanceof VentasMes) {
            var1.setText( "Mes: " + ((VentasMes) informe).getMes());
            var2.setText( "Total Ventas: " + ((VentasMes) informe).getTotalVentas());
        } else if (informe instanceof ClienteCompra) {
            var1.setText( "ID Persona: " + ((ClienteCompra) informe).getPersona_idpersona());
            var2.setText( "Nombre: " + ((ClienteCompra) informe).getNombre());
            var3.setText( "Total Compras: " + ((ClienteCompra) informe).getTotal_compras());
        } else if (informe instanceof  ProveedorCompania) {
            var1.setText( "Nombre Compania: " + ((ProveedorCompania) informe).getNombreCompania());
        } else if (informe instanceof  EmpleadoHorario) {
            var1.setText( "Nombre: " + ((EmpleadoHorario) informe).getNombre());
            var2.setText( "Tipo horario: " + ((EmpleadoHorario) informe).getTipohorario());
        }
    }

}
