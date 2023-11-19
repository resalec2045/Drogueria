package daoController;

import Models.Reportes.InformeCliente;
import Models.Reportes.InformeVentas;
import dao.InformeClientesDao;
import dao.InformeVentasDao;
import factory.ConnectionFactory;

import java.util.List;

public class InformeVentasController {

    private InformeVentasDao informeVentasDao;

    public InformeVentasController() {
        var factory = new ConnectionFactory();
        this.informeVentasDao = new InformeVentasDao(factory.recuperaConexion());
    }

    public List<InformeVentas> listarInformesVentas() {
        return this.informeVentasDao.listarInformeVentas();
    }
}
