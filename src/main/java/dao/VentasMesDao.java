package dao;

import Models.Reportes.InformeCliente;
import Models.Reportes.VentasMes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasMesDao {

    private Connection con;

    public  VentasMesDao(Connection con) {
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
}
