// Codigo para la conexion a la base de datos en Oracle SQL Developer

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gdars
 */

public class DatabaseConnection {

    private static Connection conn = null;
    private static String usuario = "Empleado"; //Nombre del usuario creado en la BD
    private static String password = "emp123"; //Contraseña asignada al usuario
    private static String DB = "jdbc:oracle:thin:@localhost:1521:orcl"; //Direccion a la BD

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(DB, usuario, password);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.print("CONEXION EXITOSA A LA BASE DE DATOS\n");
            } else {
                System.out.print("CONEXION NO EXITOSA A LA BASE DE DATOS");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "CONEXION ERRONEA" + e.getMessage());
        }
        return conn;
    }
    
    public void desconexion() {
        try{
            conn.close();
        } catch (Exception e){
            System.out.println("Error al desconectar" + e.getMessage());
        }
    }
}
