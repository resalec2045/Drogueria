package pruebas;


import Models.Person.Persona;
import Models.Producto.Producto;
import Models.Reportes.*;
import daoController.*;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

        ClienteController clienteController = new ClienteController();
        EmpleadoController empleadoController = new EmpleadoController();
        PersonaController personaController = new PersonaController();
        ProductoController productoController = new ProductoController();
        VentasController ventasController = new VentasController();
        DomicilioController domicilioController = new DomicilioController();

        List<InformeCliente> l1 = clienteController.listarInformesPorEstado("pendiente");
        List<ComentarioClienteEstado> l2 = clienteController.listarComentarios();

        List<InformeTrabajoEmpleados> l3 = empleadoController.listarInformesTrabajoPorHorasEmpleados();
        List<EmpleadoSalario> l4 = empleadoController.listarEmpleadoSalario();

        List<Persona> l5 = personaController.listarPersonas();

        List<Producto> l6 = productoController.listarProductos();
        List<CantidadProductoStock> l7 = productoController.listarCantidadProductoStock();
        List<Producto> l8 = productoController.BuscarProductoPorNombre("Paracetamol");

//        TODO: REVISAR EL LISTARINVENTARIOPORPRODUCTO
        List<InventarioProducto> l9 = productoController.listarInventarioPorProducto();
        List<CantidadProductoStock> l12 = productoController.listarCantidadProductoStock();

        List<VentasMes> l10 = ventasController.listarVentasPorMes();
        List<Venta> l11 = ventasController.listarInformesVentas();

        List<Domicilio> l13 = domicilioController.listarDomicilios();

        for ( Domicilio i : l13 ) {
            System.out.println(i);
        }

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
