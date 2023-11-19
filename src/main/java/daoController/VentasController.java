package daoController;

import Models.Reportes.InformeVentas;
import Models.Reportes.VentasMes;
import dao.VentasDao;
import factory.ConnectionFactory;

import java.util.List;

public class VentasController {

    private VentasDao ventasDao;

    public VentasController() {
        var factory = new ConnectionFactory();
        this.ventasDao = new VentasDao(factory.recuperaConexion());
    }

    public List<VentasMes> listarVentasPorMes () {
        return this.ventasDao.listarVentasPorMes();
    }

    public List<InformeVentas> listarInformesVentas() {
        return this.ventasDao.listarInformeVentas();
    }

}
