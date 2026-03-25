
package Modelo.personas;
import  Modelo.abstracto.*;
import Modelo.hospital.*;
import Modelo.enums.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public abstract class Medico extends Empleado{
    private int numeroLicencia;
    private Especialidad especialidad;
    private List<Paciente> pacientesAsignados;
    private List<Citamedica> citasAsignadas;
    private Turno turno;

    public Medico(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo, Especialidad especialidad, Turno turno) {
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
        this.pacientesAsignados = new ArrayList<>();
        this.citasAsignadas = new ArrayList<>();
        this.turno = turno;
    }
    @Override
    public double calcularSalario(){
        double base = getsalarioBase();
        double bonoTurno = this.turno.getBono();
        
        double bonoAntiguedad = (base*0.05)*antiguedad();
        return base + bonoTurno + bonoAntiguedad;
    }
    @Override
    public String obtenerTipo(){
        return "Medico";
    }
    @Override
    public int calcularEdad(){
        return LocalDate.now().getYear() - getfechaNacimiento().getYear();
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

        public void atenderPaciente(Paciente paciente, Citamedica cita) {
        if (!pacientesAsignados.contains(paciente)) {
            pacientesAsignados.add(paciente);
        }
        citasAsignadas.add(cita);
        
    }
            public List<Paciente> getPacientesAsignados() {
        return new ArrayList<>(pacientesAsignados);
    }

    public List<Citamedica> getCitasAtendidas() {
        return new ArrayList<>(citasAsignadas);
    }
        public void setNumeroLicencia(String licencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroLicencia() {
        return numeroLicencia;
    }

        

}