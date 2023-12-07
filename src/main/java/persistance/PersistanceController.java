package persistance;

import Entities.Reserva;
import java.util.List;

/**
 *
 * @author 
 */
public class PersistanceController {
    
    ReservaJpaController ResJpa = new ReservaJpaController (); 
    
    // OPERACIÓN CREATE  
    public void CreateReservation (Reserva resv) {
        ResJpa.create(resv);
    }
    
    // OPERACIÓN READ
    public List<Reserva> GetReservations () {
        return ResJpa.findReservaEntities();
    }
    
}
