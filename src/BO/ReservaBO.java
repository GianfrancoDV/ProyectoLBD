package BO;

import Database.DatabaseConnection;
import Datos.ReservaD;
import Entity.Reserva;
import java.sql.Connection;

/**
 *
 * @author gdars
 */
public class ReservaBO {
    
    private String mensaje = "";
    private ReservaD rbo = new ReservaD();

    public String agregarReserva(Reserva res) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = rbo.agregarReserva(conn, res);
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
    
    public String modificarReserva(Reserva res) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = rbo.modificarReserva(conn, res);
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
    
    public String eliminarReserva(int id_Reserva) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = rbo.eliminarReserva(conn, id_Reserva);
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
