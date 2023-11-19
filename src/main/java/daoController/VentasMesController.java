package daoController;

import Models.Reportes.InformeCliente;
import Models.Reportes.VentasMes;
import dao.InformeClientesDao;
import dao.VentasMesDao;
import factory.ConnectionFactory;

import java.util.List;

public class VentasMesController {

    private VentasMesDao ventasMesDao;

    public VentasMesController() {
        var factory = new ConnectionFactory();
        this.ventasMesDao = new VentasMesDao(factory.recuperaConexion());
    }

    public List<VentasMes> listarVentasPorMes () {
        return this.ventasMesDao.listarVentasPorMes();
    }
}
