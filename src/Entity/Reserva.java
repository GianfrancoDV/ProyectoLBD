package Entity;

import java.util.Date;

/**
 *
 * @author gdars
 */

public class Reserva {
    private int id_Reserva;
    private int id_Habitacion;
    private int dias_estadia;
    private Date ingreso;
    private Date salida;
    private int cedula;
    
    public Reserva() {
    }

    public Reserva(int id_Reserva, int id_Habitacion, int dias_estadia, Date ingreso, Date salida, int cedula) {
        this.id_Reserva = id_Reserva;
        this.id_Habitacion = id_Habitacion;
        this.dias_estadia = dias_estadia;
        this.ingreso = ingreso;
        this.salida = salida;
        this.cedula = cedula;
    }

    public int getId_Reserva() {
        return id_Reserva;
    }

    public void setId_Reserva(int id_Reserva) {
        this.id_Reserva = id_Reserva;
    }

    public int getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(int id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    public int getDias_estadia() {
        return dias_estadia;
    }

    public void setDias_estadia(int dias_estadia) {
        this.dias_estadia = dias_estadia;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
}
