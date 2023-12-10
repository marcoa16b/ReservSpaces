package persistencia;

import Entities.Espacio;
import Entities.Reserva;
import Entities.Reservacion;
import java.util.List;

/**
 * Esta es la clase controladora de persistencia para todas las entidades el proyecto
 * @author 
 */
public class ControladoraPersistencia {
    ReservaJpaController reservaJPA = new ReservaJpaController(); 
    EspacioJpaController espacioJPA = new EspacioJpaController();
    ReservacionJpaController reservacionJPA = new ReservacionJpaController();
    
    public ControladoraPersistencia(){
    }
    
    public void crearReserva(Reserva resv) {
        reservaJPA.create(resv);  
    }
    
    public List<Reserva> obtenerReservas(){
        return reservaJPA.findReservaEntities();
    }
    
    // Espacios
    public void crearEspacio(Espacio espacio) {
        espacioJPA.create(espacio);  
    }
    
    public List<Espacio> obtenerEspacios(){
        return espacioJPA.findEspacioEntities();
    }
    
    // Reservaciones
    public void crearReservacion(Reservacion reservacion) {
        reservacionJPA.create(reservacion);  
    }
    
    public List<Reservacion> obtenerReservacion(){
        return reservacionJPA.findReservacionEntities();
    }
}
