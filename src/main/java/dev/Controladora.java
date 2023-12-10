package dev;

import Entities.Espacio;
import Entities.Reserva;
import Entities.Reservacion;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 * Esta es la clase de la capa de logica
 * @author 
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    /*public void crearReserva(String usuario, String sala, String fecha) {
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setSala(sala);
        reserva.setFecha(fecha);
        controlPersis.crearReserva(reserva);
    }
    
    public List<Reserva> obtenerReservas() {
        return controlPersis.obtenerReservas();
    }*/
    
    /**
     * Metodo para crear un nuevo espacio.
     * 
     * @param nombre Nombre del espacio (Ej: Sala de reuniones. )
     * @param ubicacion Ubicacion del espacio (Ej: Tercer piso. Edificio London Doe. )
     * @param capacidad Capacidad maxima de la sala.
     */
    public void crearEspacio(String nombre, String ubicacion, int capacidad) {
        Espacio espacio = new Espacio();
        espacio.setNombre(nombre);
        espacio.setUbicacion(ubicacion);
        espacio.setCapacidad(capacidad);
        controlPersis.crearEspacio(espacio);
    }
    
    /**
     * Metodo para obtener una lista con los espacios.
     * 
     * @return Una lista de objetos Espacio con los espacios disponibles.
     */
    public List<Espacio> obtenerEspacios() {
        return controlPersis.obtenerEspacios();
    }
    
    public void crearReserva(Espacio espacio, Date fechaInicio, Date fechaFin) {
        Reservacion reservacion = new Reservacion();
        reservacion.setEspacio(espacio);
        reservacion.setFechaInicio(fechaInicio);
        reservacion.setFechaFin(fechaFin);
        controlPersis.crearReservacion(reservacion);
    }
    
    public List<Reservacion> obtenerReservaciones() {
        return controlPersis.obtenerReservacion();
    }
}
