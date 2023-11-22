package dao;

import Models.Reportes.Domicilio;
import Models.Reportes.ProveedorCompania;
import Models.turnos.Turnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurnosDao {

    private Connection con;

    public TurnosDao(Connection con) {
        this.con = con;
    }

    public List<Turnos> ListarTurnos() {

        List<Turnos> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM turnoempleado";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Turnos(
                                resultSet.getInt("codturno"),
                                resultSet.getString("tipohorario"),
                                resultSet.getInt("empleado_persona_idpersona")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void eliminarTurnos(String id) {
        try {
            String sql1 = "DELETE FROM turnoempleado WHERE empleado_persona_idpersona = ?;";

            final PreparedStatement statement1 = con.prepareStatement(sql1);

            try (statement1) {
                statement1.setString(1, id);
                statement1.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarTurnos(Turnos turnos) {
        try {
            String sql = "UPDATE turnoempleado SET codturno = ?, tipohorario = ? WHERE empleado_persona_idpersona = ?";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                statement.setString(1, "" + turnos.getCodturno());
                statement.setString(2, turnos.getTipohorario());
                statement.setInt(3, turnos.getEmpleado_persona_idpersona());
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Turnos> BuscarTurnosPorId(String codturno) {

        List<Turnos> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM turnoempleado WHERE codturno LIKE '%" +  codturno + "%'";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(
                                new Turnos(
                                        resultSet.getInt("codturno"),
                                        resultSet.getString("tipohorario"),
                                        resultSet.getInt("empleado_persona_idpersona")
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
