package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 
 */

@Entity
@Table(name = "espacios")
public class Espacio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Relación One-to-Many con la clase Reserva
    @OneToMany(mappedBy = "espacio")
    private List<Reservacion> reservaciones;
    
    private String nombre;
    private String ubicacion;
    private int capacidad;

    // Constructores
    public Espacio() {
    }
    public Espacio(int id, String nombre, String ubicacion, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }
    
    // Getters y setters
    // Getters
    public int getId() {
        return id;
    }
    
    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setReservaciones(List<Reservacion> reservaciones){
        this.reservaciones = reservaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
