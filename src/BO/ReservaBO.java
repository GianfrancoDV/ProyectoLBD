package BO;

import Database.DatabaseConnection;
import Datos.ReservaD;
import Entity.Reserva;
import java.beans.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gdars
 */
public class ReservaBO {

    private String mensaje = "";
    private ReservaD rd = new ReservaD();

    public String agregarReserva(Reserva res) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            mensaje = rd.agregarReserva(conn, res);
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
            mensaje = rd.modificarReserva(conn, res);
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
            mensaje = rd.eliminarReserva(conn, id_Reserva);
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

    public void listarReserva(JTable tabla) {
        Connection conn = DatabaseConnection.getConnection();
        rd.listarReserva(conn, tabla);
        try{
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
