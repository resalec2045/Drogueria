package dao;

import Models.Reportes.ComentarioClienteEstado;
import Models.Reportes.InformeCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private Connection con;

    public ClienteDao(Connection con) {
        this.con = con;
    }


    public List<InformeCliente> listarInformesCLientes(String estado) {
        List<InformeCliente> resultado = new ArrayList<>();

        try {
            String sql = "SELECT c.*, cc.estado, cc.descripcion\n" +
                    "FROM cliente c\n" +
                    "LEFT JOIN comentariocliente cc ON c.persona_idpersona = cc.cliente_persona_idpersona\n" +
                    "WHERE cc.estado = '" + estado + "'";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new InformeCliente(
                                resultSet.getInt("persona_idpersona"),
                                resultSet.getString("fecharegistro"),
                                resultSet.getString("estado"),
                                resultSet.getString("descripcion")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<ComentarioClienteEstado> listarComentarios () {

        List<ComentarioClienteEstado> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "    cc.codticket,\n" +
                    "    cc.estado,\n" +
                    "    cc.descripcion,\n" +
                    "    cc.solucion,\n" +
                    "    p.idpersona AS id_cliente,\n" +
                    "    CONCAT(p.nombre, ' ', p.primerapellido) AS nombre_cliente\n" +
                    "FROM\n" +
                    "    comentariocliente cc\n" +
                    "    JOIN cliente c ON cc.cliente_persona_idpersona = c.persona_idpersona\n" +
                    "    JOIN persona p ON c.persona_idpersona = p.idpersona\n" +
                    "ORDER BY\n" +
                    "    cc.codticket";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new ComentarioClienteEstado(
                                resultSet.getInt("codticket"),
                                resultSet.getString("estado"),
                                resultSet.getString("descripcion"),
                                resultSet.getString("solucion"),
                                resultSet.getInt("id_cliente"),
                                resultSet.getString("nombre_cliente"
                                )
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

