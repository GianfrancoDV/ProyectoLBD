package Datos;

import Entity.Reserva;
import java.sql.*;
import javax.swing.JTable;

/**
 *
 * @author gdars
 */
public class ReservaD {
    
    private String mensaje = "";
    
    public String agregarReserva(Connection con , Reserva res) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO RESERVA (id_reserva, id_habitacion, dias_estadia, ingreso, salida, cedula)" + "VALUES(RESERVA_SEQ.NEXTVAL,?,?,?,?,?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, res.getId_Habitacion());
            pst.setInt(2, res.getDias_estadia());
            pst.setDate(3, (Date) res.getIngreso());
            pst.setDate(4, (Date) res.getSalida());
            pst.setInt(5, res.getCedula());
            mensaje = "Datos guardados correctamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron guardar los datos\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarReserva(Connection con , Reserva res ) {
        PreparedStatement pst = null;
        String sql = "UPDATE RESERVA SET id_habitacion = ?, dias_estadia = ?, ingreso = ?, salida = ?, cedula = ?" + "WHERE id_reserva = ?";
        
        try{
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
        }catch (Exception e){
            mensaje = "No se lograron actualizar los datos\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarReserva(Connection con , int id_Reserva) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM RESERVA WHERE id_reserva = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_Reserva);
            mensaje = "Datos eliminados exitosamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron eliminar los datos\n" + e.getMessage();
        }
        return mensaje;
    }

    public void listarReserva(Connection con, JTable tabla) {

    }
}
