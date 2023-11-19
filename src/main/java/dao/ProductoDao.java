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
                                resultSet.getInt("inventario"),
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
                                resultSet.getInt("inventario"),
                                resultSet.getDouble("precio")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

//    Lista inventario con producto
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
