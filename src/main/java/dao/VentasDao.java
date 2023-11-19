package dao;

import Models.Reportes.Venta;
import Models.Reportes.VentasMes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasDao {

    private Connection con;

    public VentasDao(Connection con) {
        this.con = con;
    }


    public List<VentasMes> listarVentasPorMes() {

        List<VentasMes> resultado = new ArrayList<>();

        try {
            String sql = "SELECT MONTH(f.fechafacturacion) AS mes, SUM(f.total) AS total_ventas\n" +
                    "FROM factura f\n" +
                    "GROUP BY mes";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new VentasMes(
                                resultSet.getString("mes"),
                                resultSet.getString("total_ventas")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<Venta> listarInformeVentas() {

        List<Venta> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "    p.codproducto,\n" +
                    "    p.nombre AS producto,\n" +
                    "    c.nombrecategoria AS categoria,\n" +
                    "    SUM(pf.cantidad) AS cantidad_vendida,\n" +
                    "    SUM(pf.cantidad * p.precio) AS total_venta\n" +
                    "FROM\n" +
                    "    productofactura pf\n" +
                    "    JOIN productodrogueria pd ON pf.productodrogueria_producto_codproducto = pd.producto_codproducto\n" +
                    "    JOIN categoría c ON pd.producto_codproducto = c.codcategoria\n" +
                    "    JOIN producto p ON pd.producto_codproducto = p.codproducto\n" +
                    "GROUP BY\n" +
                    "    p.codproducto, c.nombrecategoria\n" +
                    "ORDER BY\n" +
                    "    c.nombrecategoria, p.codproducto";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Venta(
                                resultSet.getInt("codproducto"),
                                resultSet.getString("producto"),
                                resultSet.getString("categoria"),
                                resultSet.getInt("cantidad_vendida"),
                                resultSet.getInt("total_venta"
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
