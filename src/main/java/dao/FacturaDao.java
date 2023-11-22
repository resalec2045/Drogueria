package dao;

import Models.Producto.Producto;
import Models.Reportes.Factura;
import Utils.ModelFactoryController;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDao {

    private Connection con;
    ModelFactoryController modelFactoryController;

    public FacturaDao(Connection con) {
        this.con = con;
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<Factura> listarFacturas() {
        List<Factura> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "   factura.*, cliente.*" +
                    "FROM\n" +
                    "    factura" +
                    "    INNER JOIN cliente ON factura.cliente_persona_idpersona = cliente.persona_idpersona";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Factura(
                                resultSet.getString("codFactura"),
                                resultSet.getString("fechaFacturacion"),
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


    public void deleteFactura(int id) {

        try {
            String sql1 = "DELETE FROM ordendomicilio WHERE factura_codfactura = ?;";
            String sql2 = "DELETE FROM productofactura WHERE factura_codfactura = ?;";
            String sql3 = "DELETE FROM factura WHERE codfactura = ?;";

            final PreparedStatement statement1 = con.prepareStatement(sql1);
            final PreparedStatement statement2 = con.prepareStatement(sql2);
            final PreparedStatement statement3 = con.prepareStatement(sql3);

            statement1.setInt(1, id);
            statement2.setInt(1, id);
            statement3.setInt(1, id);

            statement1.executeUpdate();
            statement2.executeUpdate();
            statement3.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFactura(Factura factura) {

        try {
            String sql = "UPDATE factura SET codFactura = ?, fechaFacturacion = ?, total = ? WHERE codFactura = ?;";

            final PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, factura.getCodFactura());
            statement.setString(2, factura.getFechaFacturacion());
            statement.setString(3, factura.getTotal());
            statement.setString(4, factura.getCodFactura());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Factura> BuscarFacturaPorNombre(String codFactura) {

        List<Factura> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM factura WHERE codFactura LIKE '%" +  codFactura + "%'";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Factura(
                                resultSet.getString("codFactura"),
                                resultSet.getString("fechaFacturacion"),
                                resultSet.getString("total")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
