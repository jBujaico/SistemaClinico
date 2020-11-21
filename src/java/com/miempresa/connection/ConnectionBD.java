
package com.miempresa.connection;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * @author BUJAICO PACHECO JERSON KEVIN
 */
public class ConnectionBD {
    /* PATRON SINGLETON */
    private static ConnectionBD instance = null;
    /*HACIENDO USO DE LA API JDBC */
    private static Connection con;
    /*DEFINIENDO LOS PARAMETROS DE CONEXION A LA BD*/
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=bdclinica";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "sa";
    private static final String PASS = "alumno";

    /* CONSTRUCTOR PRIVADO */
    private ConnectionBD() {
        try {
            //REGISTRAR EL DRIVER DE CONEXION A LA BD
            Class.forName(DRIVER).newInstance();
            //REALIZAR LA CONEXION
            con = DriverManager.getConnection(URL, USER, PASS);
            //con = DriverManager.getConnection(URL);
            System.out.println("Conexion establecida correctamente");
            System.out.println(""+con.toString());
        } catch (Exception ex) {
            System.out.println("Error de conexion" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public synchronized static ConnectionBD newConnection() {
        if (instance == null) {
            instance = new ConnectionBD();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        instance = null;
    }

    public static class newConnection {

        public newConnection() {
        }
    }


}
