// Creacion de la entidad Persona y el encapsulamiento de sus datos
package Entity;

/**
 *
 * @author gdars
 */

public class Persona {
    private int cedula;
    private String nombre;
    private String direccion;
    
    public Persona (){
    }
    
    public Persona(int cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + "}";
    }
    
}
