package dao;

import Models.Producto.Producto;
import Models.Reportes.Domicilio;
import Utils.ModelFactoryController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDao {

    private Connection con;
    ModelFactoryController modelFactoryController;

    public DomicilioDao(Connection con) {
        this.con = con;
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<Domicilio> listarDomicilios() {
        List<Domicilio> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "   coddomicilio, horaenvio, direccion, fechafacturacion, total " +
                    "FROM\n" +
                    "    ordendomicilio" +
                    "    INNER JOIN factura ON ordendomicilio.factura_codfactura = factura.codfactura" +
                    "    INNER JOIN cliente ON factura.cliente_persona_idpersona = cliente.persona_idpersona";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Domicilio(
                                resultSet.getString("coddomicilio"),
                                resultSet.getString("horaenvio"),
                                resultSet.getString("direccion"),
                                resultSet.getString("fechafacturacion"),
                                resultSet.getString("total")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void eliminarDomicilio(String id) {
        try {
            String sql1 = "DELETE FROM factura WHERE codfactura = ?;";
            String sql2 = "DELETE FROM ordendomicilio WHERE factura_codfactura = ?;";

            final PreparedStatement statement1 = con.prepareStatement(sql1);
            final PreparedStatement statement2 = con.prepareStatement(sql2);

            try (statement1) {
                statement1.setString(1, id);
                statement2.setString(1, id);
                statement1.execute();
                statement2.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizarDomicilio(Domicilio domicilio) {
        try {
            String sql = "UPDATE ordendomicilio SET horaenvio = ?, direccion = ? WHERE coddomicilio = ?";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                statement.setString(1, domicilio.getHoraenvio());
                statement.setString(2, domicilio.getDireccion());
                statement.setInt(3, Integer.parseInt(domicilio.getCoddomicilio()));
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Domicilio> BuscarDomicilioPorId(String coddomicilio) {

        List<Domicilio> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM ordendomicilio WHERE coddomicilio LIKE '%" +  coddomicilio + "%'";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(
                                new Domicilio(
                                        resultSet.getString("coddomicilio"),
                                        resultSet.getString("horaenvio"),
                                        resultSet.getString("direccion")
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
