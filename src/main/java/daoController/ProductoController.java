package daoController;

import Models.Producto.Producto;
import Models.Reportes.CantidadProductoStock;
import Models.Reportes.InventarioProducto;
import dao.ProductoDao;
import factory.ConnectionFactory;

import java.util.List;

public class ProductoController {

    ProductoDao productoDao;

    public ProductoController() {
        var factory = new ConnectionFactory();
        this.productoDao = new ProductoDao(factory.recuperaConexion());
    }

    public List<Producto> listarProductos() {
        return this.productoDao.listarProductos();
    }

    public List<Producto> BuscarProductoPorNombre(String nombre) {
        return this.productoDao.BuscarProductoPorNombre(nombre);
    }

    public List<InventarioProducto> listarInventarioPorProducto() {
        return this.productoDao.listarInventario();
    }

    public List<CantidadProductoStock> listarCantidadProductoStock() {
        return this.productoDao.listarCantidadProductoStock();
    }

}
