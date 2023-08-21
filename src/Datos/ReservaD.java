package Datos;

import Entity.Reserva;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gdars
 */
public class ReservaD {

    private String mensaje = "";

    public String agregarReserva(Connection con, Reserva res) {

        PreparedStatement pst = null;
        String sql = "INSERT INTO RESERVA (id_habitacion, dias_estadia, ingreso, salida, cedula)" + "VALUES(?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, res.getId_Habitacion());
            pst.setInt(2, res.getDias_estadia());
            pst.setDate(3, (Date) res.getIngreso());
            pst.setDate(4, (Date) res.getSalida());
            pst.setInt(5, res.getCedula());
            mensaje = "Datos guardados correctamente";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se lograron guardar los datos\n" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarReserva(Connection con, Reserva res) {
        PreparedStatement pst = null;
        String sql = "UPDATE RESERVA SET id_habitacion = ?, dias_estadia = ?, ingreso = ?, salida = ?, cedula = ?" + "WHERE id_reserva = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, res.getId_Habitacion());
            pst.setInt(2, res.getDias_estadia());
            pst.setDate(3, (Date) res.getIngreso());
            pst.setDate(4, (Date) res.getSalida());
            pst.setInt(5, res.getCedula());
            pst.setInt(6, res.getId_Reserva());
            mensaje = "Datos actualizados correctamente";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se lograron actualizar los datos\n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarReserva(Connection con, int id_Reserva) {
        CallableStatement cst = null;

        try {
            cst = con.prepareCall("{? = call eliminar_reserva(?)}");
            cst.registerOutParameter(1, java.sql.Types.NUMERIC); // Tipo de dato de salida de la función
            cst.setInt(2, id_Reserva); // Configura el valor del parámetro de entrada

            cst.execute();

            int resultado = cst.getInt(1); // Obtén el valor de salida

            if (resultado == 1) {
                mensaje = "Datos eliminados exitosamente";
            } else if (resultado == 0) {
                mensaje = "La reserva no fue encontrada";
            }

        } catch (Exception e) {
            mensaje = "No se lograron eliminar los datos\n" + e.getMessage();
        } finally {
            // Cerrar el statement
            try {
                if (cst != null) {
                    cst.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return mensaje;
    }

    public void listarReserva(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "HABITACION", "ESTADIA", "INGRESO", "SALIDA", "CEDULA"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM RESERVA ORDER BY id_reserva";
        String[] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
}
