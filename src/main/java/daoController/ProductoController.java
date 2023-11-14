package daoController;

import Models.Person.Persona;
import Models.Products.Producto;
import dao.PersonaDao;
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

}
