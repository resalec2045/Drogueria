package dao;

import Models.Person.Persona;
import Models.Products.Producto;

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

}
