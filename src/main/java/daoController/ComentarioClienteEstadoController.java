package daoController;

import Models.Reportes.ComentarioClienteEstado;
import Models.Reportes.EmpleadoSalario;
import dao.ComentarioClienteEstadoDao;
import dao.EmpleadoSalarioDao;
import factory.ConnectionFactory;

import java.util.List;

public class ComentarioClienteEstadoController {
    private ComentarioClienteEstadoDao comentarioClienteEstadoDao;

    public ComentarioClienteEstadoController() {
        var factory = new ConnectionFactory();
        this.comentarioClienteEstadoDao = new ComentarioClienteEstadoDao(factory.recuperaConexion());
    }

    public List<ComentarioClienteEstado> listarComentarios() {
        return this.comentarioClienteEstadoDao.listarComentarios();
    }
}
