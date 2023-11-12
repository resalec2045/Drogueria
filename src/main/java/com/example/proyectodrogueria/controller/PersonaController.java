package com.example.proyectodrogueria.controller;

import com.example.proyectodrogueria.dao.PersonaDao;
import com.example.proyectodrogueria.factory.ConnectionFactory;
import com.example.proyectodrogueria.modelo.Persona;

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
        return this.personaDao.verificarLogin(nombre, contrasenia);
    }

}
