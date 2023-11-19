package daoController;

import Models.Reportes.EmpleadoSalario;
import Models.Reportes.InformeCliente;
import dao.EmpleadoSalarioDao;
import dao.InformeClientesDao;
import factory.ConnectionFactory;

import java.util.List;

public class EmpleadoSalarioController {

    private EmpleadoSalarioDao empleadoSalarioDao;

    public EmpleadoSalarioController() {
        var factory = new ConnectionFactory();
        this.empleadoSalarioDao = new EmpleadoSalarioDao(factory.recuperaConexion());
    }

    public List<EmpleadoSalario> listarEmpleadoSalario() {
        return this.empleadoSalarioDao.listarEmpleadoSalario();
    }
}
