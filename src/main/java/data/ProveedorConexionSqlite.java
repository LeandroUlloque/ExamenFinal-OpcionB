package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProveedorConexionSqlite {

    private static Connection conexion;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("Error: No se encuentra el driver de conexión...");
            System.exit(-1);
        }

    }

    public static Connection conectar(String nombreArchivo){

        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreArchivo);

            }
        }
        catch (SQLException ex) {
            System.err.println("Error: no se puede conectar a la base de datos...");
            System.exit(-1);
        }

        return conexion;

    }

}
