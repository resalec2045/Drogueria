package com.example.proyectodrogueria.pruebas;


import com.example.proyectodrogueria.controller.PersonaController;
import com.example.proyectodrogueria.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
