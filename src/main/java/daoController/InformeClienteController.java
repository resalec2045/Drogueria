package daoController;

import Models.Person.Persona;
import Models.Reportes.InformeCliente;
import dao.InformeClientesDao;
import dao.PersonaDao;
import factory.ConnectionFactory;

import java.util.List;

public class InformeClienteController {

    private InformeClientesDao informeClientesDao;

    public InformeClienteController() {
        var factory = new ConnectionFactory();
        this.informeClientesDao = new InformeClientesDao(factory.recuperaConexion());
    }

    public List<InformeCliente> listarInformesPorEstado(String estado) {
        return this.informeClientesDao.listarInformesCLientes(estado);
    }

}
