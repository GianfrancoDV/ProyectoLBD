// Creacion de metodos agregar-modificar-eliminar para Habitacion
package Datos;

import Entity.Habitacion;
import java.sql.*;
import javax.swing.JTable;

/**
 *
 * @author gdars
 */

public class HabitacionD {
    
    private String mensaje ="";
    
    public String agregarHabitacion(Connection con , Habitacion hab) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO HABITACION (id_habitacion, descripcion)" + "VALUES(?,?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, hab.getIdHabitacion());
            pst.setString(2, hab.getDescripcion());
            mensaje = "Datos guardados correctamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron guardar los datos\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarHabitacion(Connection con , Habitacion hab ) {
        PreparedStatement pst = null;
        String sql = "UPDATE HABITACION SET descripcion = ?" + "WHERE id_habitacion = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, hab.getDescripcion());
            pst.setInt(2, hab.getIdHabitacion());
            mensaje = "Datos actualizados correctamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron actualizar los datos\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarHabitacion(Connection con , int idHabitacion) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM HABITACION WHERE id_habitacion = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, idHabitacion);
            mensaje = "Datos eliminados exitosamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron eliminar los datos\n" + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarHabitacion(Connection con, JTable tabla) {

    }
}
