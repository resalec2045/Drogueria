package com.example.proyectodrogueria.dao;

import com.example.proyectodrogueria.modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {

    private Connection con;

    public PersonaDao(Connection con) {
        this.con = con;
    }

    public List<Persona> listarPersonas() {
        List<Persona> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM persona";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Persona(
                                resultSet.getInt("idpersona"),
                                resultSet.getString("nombre"),
                                resultSet.getString("primerapellido"),
                                resultSet.getString("segundoapellido"),
                                resultSet.getString("dirección"),
                                resultSet.getString("correoelectronico")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
