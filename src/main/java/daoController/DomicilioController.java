package daoController;

import Models.Reportes.Domicilio;
import Models.Reportes.InformeCliente;
import dao.ClienteDao;
import dao.DomicilioDao;
import factory.ConnectionFactory;

import java.util.List;

public class DomicilioController {

    private DomicilioDao domicilioDao;

    public DomicilioController() {
        var factory = new ConnectionFactory();
        this.domicilioDao = new DomicilioDao(factory.recuperaConexion());
    }

    public List<Domicilio> listarDomicilios() {
        return this.domicilioDao.listarDomicilios();
    }

    public void eliminarDomicilio(String id) {
        this.domicilioDao.eliminarDomicilio(id);
    }

    public void actualizarDomicilio(Domicilio domicilio) {
        this.domicilioDao.actualizarDomicilio(domicilio);
    }

    public List<Domicilio> buscarDomicilioPorID(String id) {
        return this.domicilioDao.BuscarDomicilioPorId(id);
    }

    public void insertarDomicilio(Domicilio domicilio) {
        this.domicilioDao.insertDomicilio(domicilio);
    }

}
