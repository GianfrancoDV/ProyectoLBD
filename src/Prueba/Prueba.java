/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import BO.HabitacionBO;
import BO.PersonaBO;
import BO.ReservaBO;
import Entity.Habitacion;
import Entity.Persona;
import Entity.Reserva;
import java.text.SimpleDateFormat;

/**
 *
 * @author gdars
 */
public class Prueba {

    Persona per = new Persona();
    PersonaBO pbo = new PersonaBO();

    Habitacion hab = new Habitacion();
    HabitacionBO hbo = new HabitacionBO();

    Reserva res = new Reserva();
    ReservaBO rbo = new ReservaBO();

    String mensaje = "";

    //Metodos de prueba para insertar-modificar-eliminar datos en la tabla Persona
    public void insertarP() {
        per.setCedula(1233);
        per.setNombre("Maria");
        per.setDireccion("Panama");
        mensaje = pbo.agregarPersona(per);
        System.out.println(mensaje);
    }

    public void modificarP() {
        per.setCedula(1233);
        per.setNombre("Maria");
        per.setDireccion("Panama");
        mensaje = pbo.modificarPersona(per);
        System.out.println(mensaje);
    }

    public void eliminarP() {
        mensaje = pbo.eliminarPersona(1233);
        System.out.println(mensaje);
    }

    //Metodos de prueba para insertar-modificar-eliminar datos en la tabla Habitacion
    public void insertarH() {
        hab.setIdHabitacion(2);
        hab.setDescripcion("Sencilla");
        mensaje = hbo.agregarHabitacion(hab);
        System.out.println(mensaje);
    }

    public void modificarH() {
        hab.setIdHabitacion(1);
        hab.setDescripcion("Doble");
        mensaje = hbo.modificarHabitacion(hab);
        System.out.println(mensaje);
    }

    public void eliminarH() {
        mensaje = hbo.eliminarHabitacion(2);
        System.out.println(mensaje);
    }

    //Metodos de prueba para insertar-modificar-eliminar datos en la tabla Reserva
    public void insertarR() {

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

        res.setId_Habitacion(4);
        res.setDias_estadia(3);
        try {
            java.util.Date javaIngreso = date.parse("22-10-2023");
            java.sql.Date sqlIngreso = new java.sql.Date(javaIngreso.getTime());
            res.setIngreso(sqlIngreso);
        } catch (Exception e) {
        }
        try {
            java.util.Date javaSalida = date.parse("25-10-2023");
            java.sql.Date sqlSalida = new java.sql.Date(javaSalida.getTime());
            res.setSalida(sqlSalida);
        } catch (Exception e) {
        }
        res.setCedula(4321);
        mensaje = rbo.agregarReserva(res);
        System.out.println(mensaje);
    }
    
    public void modificarR() {
        
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        
        res.setId_Reserva(2);
        res.setId_Habitacion(1);
        res.setDias_estadia(7);
        try {
            java.util.Date javaIngreso = date.parse("20-02-2023");
            java.sql.Date sqlIngreso = new java.sql.Date(javaIngreso.getTime());
            res.setIngreso(sqlIngreso);
        } catch (Exception e) {
        }
        try {
            java.util.Date javaSalida = date.parse("27-02-2023");
            java.sql.Date sqlSalida = new java.sql.Date(javaSalida.getTime());
            res.setSalida(sqlSalida);
        } catch (Exception e) {
        }
        res.setCedula(1234);
        mensaje = rbo.modificarReserva(res);
        System.out.println(mensaje);
    }

    public void eliminarR() {
        mensaje = rbo.eliminarReserva(1);
        System.out.println(mensaje);
    }

    
    //General
    public static void main(String[] args) {
        Prueba prb = new Prueba();
        //prb.modificarR();
        prb.insertarR();
    }
}
