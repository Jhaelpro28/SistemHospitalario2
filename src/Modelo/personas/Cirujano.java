
package Modelo.personas;
import Modelo.enums.Turno;
import Modelo.hospital.*;
import java.time.LocalDate;

public class Cirujano extends Medico {
    private int cirugiasRealizadas;
    private boolean disponibleEmergencia;

    public Cirujano(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo, int numeroLicencia,Especialidad esp, Turno turno, int cirugias, boolean disp) {
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo, esp, turno);
        this.cirugiasRealizadas = cirugiasRealizadas;
        this.disponibleEmergencia = disponibleEmergencia;
    }
    public void realizarCirugias(){
        cirugiasRealizadas++;
        System.out.println("Cirugia realizada. Total:" + cirugiasRealizadas);
    }
    public int calcularBono(){
        return cirugiasRealizadas * 50;
        
    }
    @Override
    public double calcularSalario(){
        return super.calcularSalario() +  calcularBono();
    }
    @Override
    public String obtenerTipo(){
        return "Cirujano";
    }

    public int getCirugiasRealizadas() {
        return cirugiasRealizadas;
    }
    public boolean isdisponibleEmergencia(){
        return disponibleEmergencia;
    }
}
