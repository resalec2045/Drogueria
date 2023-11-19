package daoController;

import Models.Reportes.InformeCliente;
import Models.Reportes.InformeTrabajoEmpleados;
import dao.InformeClientesDao;
import dao.InformeTrabajoEmpleadoDao;
import factory.ConnectionFactory;

import java.util.List;

public class InformeTrabajoEmpleadoController {

    private InformeTrabajoEmpleadoDao informeTrabajoEmpleadoDao;

    public InformeTrabajoEmpleadoController() {
        var factory = new ConnectionFactory();
        this.informeTrabajoEmpleadoDao = new InformeTrabajoEmpleadoDao(factory.recuperaConexion());
    }

    public List<InformeTrabajoEmpleados> listarInformesTrabajoPorHorasEmpleados() {
        return this.informeTrabajoEmpleadoDao.listarInformeTrabajo();
    }
}
