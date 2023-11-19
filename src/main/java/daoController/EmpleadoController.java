package daoController;

import Models.Reportes.ComentarioClienteEstado;
import Models.Reportes.EmpleadoSalario;
import Models.Reportes.InformeTrabajoEmpleados;
import dao.EmpleadoDao;
import factory.ConnectionFactory;

import java.util.List;

public class EmpleadoController {

    private EmpleadoDao empleadoDao;

    public EmpleadoController() {
        var factory = new ConnectionFactory();
        this.empleadoDao = new EmpleadoDao(factory.recuperaConexion());
    }

    public List<InformeTrabajoEmpleados> listarInformesTrabajoPorHorasEmpleados() {
        return this.empleadoDao.listarInformeTrabajo();
    }

    public List<EmpleadoSalario> listarEmpleadoSalario() {
        return this.empleadoDao.listarEmpleadoSalario();
    }
}
