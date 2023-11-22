package daoController;

import Models.Reportes.Domicilio;
import Models.turnos.Turnos;
import dao.DomicilioDao;
import dao.TurnosDao;
import factory.ConnectionFactory;

import java.util.List;

public class TurnosController {
    private TurnosDao turnosDao;

    public TurnosController() {
        var factory = new ConnectionFactory();
        this.turnosDao = new TurnosDao(factory.recuperaConexion());
    }

    public List<Turnos> listarTurnos() {
        return this.turnosDao.ListarTurnos();
    }
    public void eliminarTurnos(String id) {
        this.turnosDao.eliminarTurnos(id);
    }

    public void actualizarDomicilio(Turnos domicilio) {
        this.turnosDao.actualizarTurnos(domicilio);
    }

    public List<Turnos> buscarDomicilioPorID(String id) {
        return this.turnosDao.BuscarTurnosPorId(id);
    }

}
