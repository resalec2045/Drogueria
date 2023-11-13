package daoController;

import dao.PersonaDao;
import factory.ConnectionFactory;
import modelo.Persona;

import java.util.List;

public class PersonaController {

    private PersonaDao personaDao;

    public PersonaController() {
        var factory = new ConnectionFactory();
        this.personaDao = new PersonaDao(factory.recuperaConexion());
    }

    public List<Persona> listarPersonas() {
        return this.personaDao.listarPersonas();
    }

    public Persona verificarLogin(String nombre, String contrasenia) {
        return this.personaDao.traerDatosPersona(nombre, contrasenia);
    }

}
