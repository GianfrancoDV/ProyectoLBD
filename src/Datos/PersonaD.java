// Creacion de metodos agregar-modificar-eliminar para Persona
package Datos;

import Entity.Persona;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gdars
 */
public class PersonaD {

    private String mensaje ="";
    
    public String agregarPersona(Connection con , Persona per) {
        
        PreparedStatement pst = null;
        String sql = "INSERT INTO PERSONA (cedula, nombre, direccion)" + "VALUES(?,?,?)";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, per.getCedula());
            pst.setString(2, per.getNombre());
            pst.setString(3, per.getDireccion());
            mensaje = "Datos guardados correctamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron guardar los datos\n" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarPersona(Connection con , Persona per ) {
        PreparedStatement pst = null;
        String sql = "UPDATE PERSONA SET nombre = ?, direccion = ?" + "WHERE cedula = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, per.getNombre());
            pst.setString(2, per.getDireccion());
            pst.setInt(3, per.getCedula());
            mensaje = "Datos actualizados correctamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron actualizar los datos\n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPersona(Connection con , int cedula) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PERSONA WHERE cedula = ?";
        
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, cedula);
            mensaje = "Datos eliminados exitosamente";
            pst.execute();
            pst.close();
        }catch (Exception e){
            mensaje = "No se lograron eliminar los datos\n" + e.getMessage();
        }
        return mensaje;
    }

    public void listarPersona(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"CEDULA", "NOMBRE", "DIRECCION"};
        model = new DefaultTableModel(null, columnas);

        String sql = "SELECT * FROM PERSONA ORDER BY cedula";
        String[] filas = new String[3];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                for (int i = 0; i < 3; i++){
                    filas[i] = rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
}