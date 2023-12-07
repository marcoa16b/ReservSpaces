package dev.reservaespacios;

import Entities.Reserva;
import java.util.List;
import persistance.PersistanceController;

/**
 * Controlador de la capa de logica de la aplicación
 * @author 
 */
public class Controller {
    
    PersistanceController persCont = new PersistanceController ();
    
    // OPERACIÓN CREATE  
    public void CreateReservation (Reserva resv) {
        persCont.CreateReservation(resv);
    }
    
    // OPERACIÓN READ
    public List<Reserva> GetReservations () {
        return persCont.GetReservations();
    }

}
