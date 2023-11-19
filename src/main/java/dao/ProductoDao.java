package dao;

import Models.Producto.Producto;
import Models.Reportes.CantidadProductoStock;
import Models.Reportes.InventarioProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {


    private Connection con;

    public ProductoDao(Connection con) {
        this.con = con;
    }

    public List<Producto> listarProductos() {
        List<Producto> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM producto";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Producto(
                                resultSet.getInt("codproducto"),
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"),
                                resultSet.getDouble("precio")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<Producto> BuscarProductoPorNombre(String nombre) {

        List<Producto> resultado = new ArrayList<>();

        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%" +  nombre + "%'";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Producto(
                                resultSet.getInt("codproducto"),
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"),
                                resultSet.getDouble("precio")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
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

    public List<CantidadProductoStock> listarCantidadProductoStock() {

        List<CantidadProductoStock> resultado = new ArrayList<>();

        try {

//        TODO: Segun yo la consulta que deberia ir
            String sql = "SELECT\n" +
                    "    i.codinventario,\n" +
                    "    p.nombre AS producto,\n" +
                    "    ip.cantidad AS cantidad_en_stock\n" +
                    "FROM\n" +
                    "    inventarioproducto ip " +
                    "INNER JOIN" +
                    "    inventario i ON i.codinventario = ip.inventario_codinventario " +
                    "INNER JOIN" +
                    "    producto p ON p.codproducto = ip.producto_codproducto " +
                    "ORDER BY\n" +
                    "    cantidad_en_stock ASC";

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
