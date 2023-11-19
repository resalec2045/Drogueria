package daoController;

import Models.Reportes.Factura;
import dao.FacturaDao;
import factory.ConnectionFactory;

import java.util.List;

public class FacturaController {

    FacturaDao facturaDao;

    public FacturaController() {
        var factory = new ConnectionFactory();
        this.facturaDao = new FacturaDao(factory.recuperaConexion());
    }

    public List<Factura> listarFacturas() {
        return this.facturaDao.listarFacturas();
    }

}
