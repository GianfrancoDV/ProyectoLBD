// Creacion de la entidad Habitacion y el encapsulamiento de sus datos
package Entity;

/**
 *
 * @author gdars
 */

public class Habitacion {
    private int idHabitacion;
    private String descripcion;
    
    public Habitacion(){
    }

    public Habitacion(int idHabitacion, String descripcion) {
        this.idHabitacion = idHabitacion;
        this.descripcion = descripcion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion=" + idHabitacion + ", descripcion=" + descripcion + "}";
    }
}
