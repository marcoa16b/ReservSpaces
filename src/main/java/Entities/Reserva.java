
package Entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 
 */

@Entity   
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int id;
    private String fecha;
    private String hora_inicio;
    // private String usuario;

    public Reserva(int id, String fecha, String hora)  {
        this.id = id;
        this.fecha = fecha;
        this.hora_inicio = hora;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return this.hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

//    public String getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }    
}
