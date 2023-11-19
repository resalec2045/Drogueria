package dao;

import Models.Reportes.CantidadProductoStock;
import Models.Reportes.InventarioProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CantidadProductoStockDao {

    private Connection con;

    public CantidadProductoStockDao(Connection con) {
        this.con = con;
    }


    public List<CantidadProductoStock> listarCantidadProductoStock() {

        List<CantidadProductoStock> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "    i.codinventario,\n" +
                    "    i.nombreproducto AS producto,\n" +
                    "    i.cantidadstock AS cantidad_en_stock\n" +
                    "FROM\n" +
                    "    inventario i\n" +
                    "ORDER BY\n" +
                    "    i.codinventario";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new CantidadProductoStock(
                                resultSet.getInt("codinventario"),
                                resultSet.getString("producto"),
                                resultSet.getInt("cantidad_en_stock")

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
