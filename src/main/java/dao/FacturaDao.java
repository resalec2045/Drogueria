package dao;

import Models.Reportes.Factura;
import Utils.ModelFactoryController;

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
                    "    INNER JOIN cliente ON factura.cliente_persona_idpersona = cliente.persona_idpersona" +
                    "    WHERE " + modelFactoryController.getStorify().getUser().getId() + " = cliente.persona_idpersona";

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


}
