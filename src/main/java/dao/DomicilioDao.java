package dao;

import Models.Reportes.Domicilio;
import Utils.ModelFactoryController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDao {

    private Connection con;
    ModelFactoryController modelFactoryController;

    public DomicilioDao(Connection con) {
        this.con = con;
        modelFactoryController = ModelFactoryController.getInstance();
    }


    public List<Domicilio> listarDomicilios() {
        List<Domicilio> resultado = new ArrayList<>();

        try {
            String sql = "SELECT\n" +
                    "   coddomicilio, horaenvio, direccion, fechafacturacion, total " +
                    "FROM\n" +
                    "    ordendomicilio" +
                    "    INNER JOIN factura ON ordendomicilio.factura_codfactura = factura.codfactura" +
                    "    INNER JOIN cliente ON factura.cliente_persona_idpersona = cliente.persona_idpersona" +
                    "    WHERE " + modelFactoryController.getStorify().getUser().getId() + " = cliente.persona_idpersona";

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Domicilio(
                                resultSet.getString("coddomicilio"),
                                resultSet.getString("horaenvio"),
                                resultSet.getString("direccion"),
                                resultSet.getString("fechafacturacion"),
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
