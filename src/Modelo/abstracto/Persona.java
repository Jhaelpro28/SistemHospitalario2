
package Modelo.abstracto;
import java.time.LocalDate;
public abstract class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;
    
    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        
    }
    public abstract int calcularEdad();
    public abstract String obtenerTipo();
    public LocalDate getfechaNacimiento(){
        return fechaNacimiento;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre != null && !nombre.isEmpty()) this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido){
        if(apellido != null && !apellido.isEmpty()) this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        if(email != null && email.contains("@")) this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if(fechaNacimiento.isAfter(LocalDate.now())){
            System.out.println("No puede ser una fecha futura");
        }
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
