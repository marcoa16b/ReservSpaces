package persistencia;

import Entities.Reserva;
import java.util.List;

/**
 * Esta es la clase controladora de persistencia para todas las entidades el proyecto
 * @author 
 */
public class ControladoraPersistencia {
    ReservaJpaController reservaJPA = new ReservaJpaController(); 
    
    public ControladoraPersistencia(){
    }
    
    public void crearReserva(Reserva resv) {
        reservaJPA.create(resv);  
    }
    
    public List<Reserva> obtenerReservas(){
        return reservaJPA.findReservaEntities();
    }
}
