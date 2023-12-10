package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author 
 */

@Entity
@Table(name = "reservas")
public class Reservacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_espacio")
    Espacio espacio;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    

    // Constructores
    public Reservacion() {
    }
    
    public Reservacion(int id, Espacio espacio, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.espacio = espacio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters (métodos para acceder y modificar los atributos)
    // Getters
    public int getId() {
        return id;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
