package daoController;

import Models.Reportes.ProveedorCompania;
import dao.ProveedorDao;
import factory.ConnectionFactory;

import java.util.List;

public class ProveedorController {

    private ProveedorDao proveedorDao;

    public ProveedorController() {
        var factory = new ConnectionFactory();
        this.proveedorDao = new ProveedorDao(factory.recuperaConexion());
    }

    public List<ProveedorCompania> ListarProveedoresCategoriaMasVendida() {
        return this.proveedorDao.ListarProveedoresCategoriaMasVendida();
    }

}
