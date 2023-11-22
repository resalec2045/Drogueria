package dao;

import Models.Reportes.ClienteCompra;
import Models.Reportes.ComentarioClienteEstado;
import Models.Reportes.InformeCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private Connection con;

    public ClienteDao(Connection con) {
        this.con = con;
    }
    
    public List<InformeCliente> listarInformesCLientes(String estado) {
        List<InformeCliente> resultado = new ArrayList<>();

        try {
            String sql = "SELECT c.*, cc.estado, cc.descripcion\n" +
                    "FROM cliente c\n" +
                    "LEFT JOIN comentariocliente cc ON c.persona_idpersona = cc.cliente_persona_idpersona\n" +
                    "WHERE cc.estado = '" + estado + "'";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new InformeCliente(
                                resultSet.getInt("persona_idpersona"),
                                resultSet.getString("fecharegistro"),
                                resultSet.getString("estado"),
                                resultSet.getString("descripcion")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<ComentarioClienteEstado> listarComentarios () {

        List<ComentarioClienteEstado> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "    cc.codticket,\n" +
                    "    cc.estado,\n" +
                    "    cc.descripcion,\n" +
                    "    cc.solucion,\n" +
                    "    p.idpersona AS id_cliente,\n" +
                    "    CONCAT(p.nombre, ' ', p.primerapellido) AS nombre_cliente\n" +
                    "FROM\n" +
                    "    comentariocliente cc\n" +
                    "    JOIN cliente c ON cc.cliente_persona_idpersona = c.persona_idpersona\n" +
                    "    JOIN persona p ON c.persona_idpersona = p.idpersona\n" +
                    "ORDER BY\n" +
                    "    cc.codticket";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new ComentarioClienteEstado(
                                resultSet.getInt("codticket"),
                                resultSet.getString("estado"),
                                resultSet.getString("descripcion"),
                                resultSet.getString("solucion"),
                                resultSet.getInt("id_cliente"),
                                resultSet.getString("nombre_cliente"
                                )
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<ClienteCompra> ListarProductoMayorCompraClientePrimerSemestre() {

        List<ClienteCompra> resultado = new ArrayList<>();

        try {
            String sql = "SELECT c.persona_idpersona, p.nombre, COUNT(*) AS total_compras, productos.nombre AS productoNombre\n" +
                    "FROM cliente c\n" +
                    "INNER JOIN factura f ON c.persona_idpersona = f.cliente_persona_idpersona\n" +
                    "INNER JOIN persona p ON c.persona_idpersona = p.idpersona\n" +
                    "INNER JOIN productofactura pf ON f.codfactura = pf.factura_codfactura\n" +
                    "INNER JOIN productodrogueria pd ON pf.productodrogueria_drogueria_coddrogueria = pd.drogueria_coddrogueria\n" +
                    "INNER JOIN (SELECT * FROM producto WHERE nombre LIKE '%ina%' AND precio > 6000) productos ON pd.producto_codproducto = productos.codproducto\n" +
                    "WHERE YEAR(f.fechafacturacion) = YEAR(CURRENT_DATE) AND MONTH(f.fechafacturacion) BETWEEN 1 AND 6\n" +
                    "GROUP BY c.persona_idpersona, p.nombre\n" +
                    "ORDER BY total_compras DESC\n" +
                    "LIMIT 1;";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add( new ClienteCompra(
                                resultSet.getString("persona_idpersona"),
                                resultSet.getString("nombre"),
                                resultSet.getString("total_compras"),
                                resultSet.getString("productoNombre")
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


