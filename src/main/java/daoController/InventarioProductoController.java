package daoController;

import Models.Reportes.InformeCliente;
import Models.Reportes.InventarioProducto;
import dao.InformeClientesDao;
import dao.InventarioProductoDao;
import factory.ConnectionFactory;

import java.util.List;

public class InventarioProductoController {

    private InventarioProductoDao inventarioProductoDao;

    public InventarioProductoController() {
        var factory = new ConnectionFactory();
        this.inventarioProductoDao = new InventarioProductoDao(factory.recuperaConexion());
    }

    public List<InventarioProducto> listarInventarioPorProducto() {
        return this.inventarioProductoDao.listarInventario();
    }
}
