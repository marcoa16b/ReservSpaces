package dev;

import Entities.Reserva;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 * Esta es la clase de la capa de logica
 * @author 
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearReserva(String usuario, String sala, String fecha) {
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setSala(sala);
        reserva.setFecha(fecha);
        controlPersis.crearReserva(reserva);
    }
    
    public List<Reserva> obtenerReservas() {
        return controlPersis.obtenerReservas();
    }
}
