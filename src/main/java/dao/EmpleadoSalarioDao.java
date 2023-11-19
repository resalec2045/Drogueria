package dao;

import Models.Reportes.EmpleadoSalario;
import Models.Reportes.InformeCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoSalarioDao {

    private Connection con;

    public  EmpleadoSalarioDao(Connection con) {
        this.con = con;
    }


    public List<EmpleadoSalario> listarEmpleadoSalario () {
        List<EmpleadoSalario> resultado = new ArrayList<>();

        try {
            String sql = "SELECT e.*, c.salario\n" +
                    "FROM empleado e\n" +
                    "JOIN cargo c ON e.cargo_codcargo = c.codcargo";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new EmpleadoSalario(
                                resultSet.getInt("persona_idpersona"),
                                resultSet.getInt("cargo_codcargo"),
                                resultSet.getInt("horastrabajadas"),
                                resultSet.getInt("empleado_persona_idpersona"),
                                resultSet.getInt("salario")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}
