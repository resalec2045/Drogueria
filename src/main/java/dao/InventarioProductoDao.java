package dao;

import Models.Person.Persona;
import Models.Reportes.InventarioProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioProductoDao {

    private Connection con;

    public InventarioProductoDao(Connection con) {
        this.con = con;
    }


    public List<InventarioProducto> listarInventario() {

        List<InventarioProducto> resultado = new ArrayList<>();

        try {
            String sql = "SELECT i.*, p.nombre, pd.cantidad\n" +
                    "FROM inventario i\n" +
                    "JOIN inventarioproducto pd ON i.codinventario = pd.inventario_codinventario\n" +
                    "JOIN producto p ON pd.producto_codproducto = p.codproducto";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new InventarioProducto(
                                resultSet.getInt("codinventario"),
                                resultSet.getInt("cantidadstock"),
                                resultSet.getString("nombreproducto"),
                                resultSet.getString("fecha"),
                                resultSet.getString("responsable"),
                                resultSet.getString("nombre"),
                                resultSet.getInt("cantidad"
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
