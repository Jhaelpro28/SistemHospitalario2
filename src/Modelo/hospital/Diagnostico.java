
package Modelo.hospital;
import Modelo.personas.Medico;
import java.time.LocalDate;
public class Diagnostico {
      private int id;
      private String descripcion;
      private String receta;
      private LocalDate fecha;
      private Medico medico;
      
      public Diagnostico(int id, String descripcion, String receta, LocalDate fecha, Medico medico){
          this.id = id;
          this.descripcion = descripcion;
          this.receta = receta;
          this.fecha = LocalDate.now();
          this.medico = medico;
      }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
      
}
