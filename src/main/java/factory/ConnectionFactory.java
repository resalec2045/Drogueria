package factory;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private Connection connection;
    private String url = "jdbc:mysql://localhost/drogueria?useTimeZone=true&serverTimeZone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";;

    public ConnectionFactory() {

        try {
            Class.forName(driver);

            connection = DriverManager.getConnection(url, "root", "");

//            if ( connection != null ) {
//                System.out.println("Conexión exitosa");
//            }

        } catch (Exception e) {
            System.out.println("Conexión fallida");
        }

    }

    public Connection recuperaConexion() {
        try {
            return this.connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
