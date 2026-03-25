
package Modelo.abstracto;
import java.time.LocalDate;

public abstract class Empleado extends Persona{
    private String legajo;
    private LocalDate fechaContratacion;
    public double salarioBase;
    private boolean activo;

    public Empleado(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo) {
        super(id, nombre, apellido, fechaNacimiento, email);
        this.legajo = legajo;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
        this.activo = true;
    }
    public abstract double calcularSalario();
        public int antiguedad() {
        return LocalDate.now().getYear() - fechaContratacion.getYear();
    }
        public double getsalarioBase(){
            return salarioBase;
        }
        public void setsalarioBase(double salarioBase){
            if(salarioBase <= 0){
                throw new IllegalArgumentException("Salario invalido");
            }
            this.salarioBase = salarioBase;
            
        }

    public String getLegajo() {
        return legajo;
    }
    public void setLegajo(String legajo) { this.legajo = legajo; }


    public double getSalarioBase() {
        return salarioBase;
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) { this.activo = activo; } 
        
        
}
