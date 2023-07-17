// 
package BO;

import Database.DatabaseConnection;
import Datos.PersonaD;
import Entity.Persona;
import java.sql.Connection;

/**
 *
 * @author gdars
 */

public class PersonaBO {

    private String mensaje = "";
    private PersonaD pbo = new PersonaD();

    public String agregarPersona(Persona per) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = pbo.agregarPersona(conn, per);
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

    public String modificarPersona(Persona per) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = pbo.modificarPersona(conn, per);
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

    public String eliminarPersona(int cedula) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = pbo.eliminarPersona(conn, cedula);
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
