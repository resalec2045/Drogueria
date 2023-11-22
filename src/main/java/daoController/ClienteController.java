package daoController;

import Models.Reportes.ClienteCompra;
import Models.Reportes.ComentarioClienteEstado;
import Models.Reportes.InformeCliente;
import dao.ClienteDao;
import factory.ConnectionFactory;

import java.util.List;

public class ClienteController {

    private ClienteDao clienteDao;

    public ClienteController() {
        var factory = new ConnectionFactory();
        this.clienteDao = new ClienteDao(factory.recuperaConexion());
    }

    public List<InformeCliente> listarInformesPorEstado(String estado) {
        return this.clienteDao.listarInformesCLientes(estado);
    }

    public List<ComentarioClienteEstado> listarComentarios() {
        return this.clienteDao.listarComentarios();
    }

    public List<ClienteCompra> ListarClienteConMasComprasPrimerSemestre() {
        return this.clienteDao.ListarProductoMayorCompraClientePrimerSemestre();
    }

}
