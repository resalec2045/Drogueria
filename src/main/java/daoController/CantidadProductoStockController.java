package daoController;

import Models.Reportes.CantidadProductoStock;
import Models.Reportes.EmpleadoSalario;
import dao.CantidadProductoStockDao;
import dao.EmpleadoSalarioDao;
import factory.ConnectionFactory;

import java.util.List;

public class CantidadProductoStockController {

    private CantidadProductoStockDao cantidadProductoStockDao;

    public CantidadProductoStockController() {
        var factory = new ConnectionFactory();
        this.cantidadProductoStockDao = new CantidadProductoStockDao(factory.recuperaConexion());
    }

    public List<CantidadProductoStock> listarEmpleadoSalario() {
        return this.cantidadProductoStockDao.listarCantidadProductoStock();
    }
}
