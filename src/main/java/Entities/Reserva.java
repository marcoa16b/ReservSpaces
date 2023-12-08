
package Entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author 
 */

@Entity   
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int id;
    private String usuario;
    private String sala;
    private String fecha;

    public Reserva() {
    }
    
    public Reserva(int id, String usuario, String sala, String fecha)  {
        this.id = id;
        this.usuario = usuario;
        this.sala = sala;
        this.fecha = fecha;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSala() {
        return this.sala;
    }
    
    public void setSala(String sala) {
        this.sala = sala;
    }
    
    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 
}
