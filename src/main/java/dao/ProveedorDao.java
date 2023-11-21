package dao;

import Models.Reportes.ProveedorCompania;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {

    private Connection con;

    public ProveedorDao(Connection con) {
        this.con = con;
    }

    public List<ProveedorCompania> ListarProveedoresCategoriaMasVendida() {

        List<ProveedorCompania> resultado = new ArrayList<>();

        try {
            String sql = "SELECT p.nombrecompañía AS nombreCompania \n" +
                    "FROM proveedor p \n" +
                    "   INNER JOIN pedido pe ON p.persona_idpersona = pe.proveedor_persona_idpersona\n" +
                    "   INNER JOIN pedidoproducto pp ON pe.codcompra = pp.pedido_codcompra\n" +
                    "   INNER JOIN producto pro ON pp.producto_codproducto = pro.codproducto\n" +
                    "   INNER JOIN productocategoria pc ON pro.codproducto = pc.producto_codproducto\n" +
                    "   INNER JOIN categoría c ON pc.categoría_codcategoria = c.codcategoria \n" +
                    "WHERE c.nombrecategoria = (  SELECT nombre FROM ( \n" +
                    "   SELECT c.nombrecategoria AS nombre ,COUNT(*) AS cantida \n" +
                    "   FROM categoría c \n" +
                    "   INNER JOIN productocategoria pc ON c.codcategoria= pc.categoría_codcategoria \n" +
                    "    GROUP BY c.nombrecategoria ORDER BY cantida DESC LIMIT 1 ) AS subConsulta)";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new ProveedorCompania(
                                resultSet.getString("nombreCompania")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
