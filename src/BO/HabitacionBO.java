package BO;

import Database.DatabaseConnection;
import Datos.HabitacionD;
import Entity.Habitacion;
import java.sql.Connection;

/**
 *
 * @author gdars
 */

public class HabitacionBO {
    
    private String mensaje = "";
    private HabitacionD hbo = new HabitacionD();
    
    public String agregarHabitacion(Habitacion hab) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = hbo.agregarHabitacion(conn, hab);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String modificarHabitacion(Habitacion hab) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = hbo.modificarHabitacion(conn, hab);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarHabitacion(int idHabitacion) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = hbo.eliminarHabitacion(conn, idHabitacion);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void listarPersona() {

    }
}
