package daoController;

import Models.Producto.Producto;
import Models.Reportes.Factura;
import dao.FacturaDao;
import factory.ConnectionFactory;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.IOException;
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

    public void deleteFactura(int codFactura) {
        this.facturaDao.deleteFactura(codFactura);
    }

    public void updateFactura(Factura factura) {
        this.facturaDao.updateFactura(factura);
    }

    public List<Factura> searchFactura(String factura) {
        return this.facturaDao.BuscarFacturaPorNombre(factura);
    }

}
