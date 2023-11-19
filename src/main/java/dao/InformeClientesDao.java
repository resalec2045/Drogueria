package dao;

import Models.Reportes.InformeCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformeClientesDao {

    private Connection con;

    public  InformeClientesDao(Connection con) {
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

}


