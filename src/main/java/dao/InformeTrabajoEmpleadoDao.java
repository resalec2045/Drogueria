package dao;

import Models.Reportes.InformeCliente;
import Models.Reportes.InformeTrabajoEmpleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformeTrabajoEmpleadoDao {

    private Connection con;

    public  InformeTrabajoEmpleadoDao(Connection con) {
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
                    "    e.persona_idpersona";

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
}
