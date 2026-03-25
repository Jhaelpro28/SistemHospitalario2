
package Modelo.hospital;
import Modelo.personas.Paciente;
import Modelo.personas.Medico;
import Modelo.enums.*;

import java.time.LocalDateTime;
public class Citamedica {
    private String id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;
    private double costo;
    private String diagnostico;
    
    public Citamedica(String id, Paciente paciente, Medico medico, LocalDateTime fechaHora,
            String motivo, EstadoCita estado, double costo, String diagnostico){
        this.id = id;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
        this.costo = costo;
        this.diagnostico = diagnostico;
    }
    public double calcularCosto(){
        if(costo <= 0){
            this.costo= costo;
        }
        return medico.getEspecialidad().getCostoConsulta();
    }
    public void completar(){
        estado = EstadoCita.Completada;
    }
    public void cancelada(){
        estado = EstadoCita.Cancelada;
    }
    public void asignarDiagnostico(String d){
        this.diagnostico = d;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        if(this.estado == EstadoCita.Cancelada){
            System.out.println("No puede modificar una cita candelada");
        }
        this.estado = estado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        if(fechaHora.isBefore(LocalDateTime.now())){
            System.out.println("ERROR: No se puede poner fecha pasada");
        }
        this.fechaHora = fechaHora;
    }

    public void setCosto(double costo) {
        if(costo <= 0){
        this.costo = costo;
        }
    }
    
    
}