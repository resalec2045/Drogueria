package dao;

import Models.Reportes.ComentarioClienteEstado;
import Models.Reportes.EmpleadoHorario;
import Models.Reportes.EmpleadoSalario;
import Models.Reportes.InformeTrabajoEmpleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {

    private Connection con;

    public EmpleadoDao(Connection con) {
        this.con = con;
    }


    public List<InformeTrabajoEmpleados> listarInformeTrabajo () {

        List<InformeTrabajoEmpleados> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "    e.persona_idpersona,\n" +
                    "    CONCAT(p.nombre, ' ', p.primerapellido) AS nombre_empleado,\n" +
                    "    e.horastrabajadas AS horas_trabajadas\n" +
                    "FROM\n" +
                    "    empleado e\n" +
                    "    JOIN persona p ON e.persona_idpersona = p.idpersona\n" +
                    "ORDER BY\n" +
                    "    e.persona_idpersona ASC";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new InformeTrabajoEmpleados(
                                resultSet.getInt("persona_idpersona"),
                                resultSet.getString("nombre_empleado"),
                                resultSet.getInt("horas_trabajadas"
                        )));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
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

    public List<EmpleadoHorario> ListarEmleadoConMasHoras () {
        List<EmpleadoHorario> resultado = new ArrayList<>();

        try {
            String sql = "SELECT  p.nombre ,te.tipohorario \n" +
                    "FROM empleado e \n" +
                    "    INNER JOIN turnoempleado te ON e.empleado_persona_idpersona = te.empleado_persona_idpersona\n" +
                    "    INNER JOIN cargo c ON e.cargo_codcargo = c.codcargo\n" +
                    "    INNER JOIN persona p ON e.persona_idpersona = p.idpersona\n" +
                    "WHERE e.empleado_persona_idpersona = ( \n" +
                    "   SELECT id FROM (SELECT id, MAX(total) AS maximo_total FROM ( \n" +
                    "       SELECT e.empleado_persona_idpersona AS id, SUM(e.horastrabajadas) AS total \n" +
                    "      FROM empleado e \n" +
                    "      INNER JOIN turnoempleado te ON e.empleado_persona_idpersona = te.empleado_persona_idpersona \n" +
                    "   GROUP BY id) AS PersonaMaxCant) AS idPersona);";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(
                                new EmpleadoHorario(
                                        resultSet.getString("nombre"),
                                        resultSet.getString("tipohorario")
                                )
                        );
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
