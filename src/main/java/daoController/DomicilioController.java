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

}
