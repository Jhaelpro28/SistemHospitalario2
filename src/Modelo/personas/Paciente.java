
package Modelo.personas;
import Modelo.abstracto.Persona;
import Modelo.hospital.Citamedica;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public abstract class Paciente extends Persona{
    private String historiaClinica;
    private String grupoSanguineo;
    private ArrayList<String> alergias;
    private ArrayList<Citamedica> citas;

    public Paciente(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
            String historiaClinica, String grupoSanguineo) {
        super(id, nombre, apellido, fechaNacimiento, email);
        this.historiaClinica = historiaClinica;
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = new ArrayList<>();
        this.citas = new ArrayList<>();
    }
    @Override
    public int calcularEdad(){
        return LocalDate.now().getYear() - getfechaNacimiento().getYear();
    }
    @Override
    public String obtenerTipo(){
        return "Medico";
    }
    public void agregarAlergia(String alergia){
        alergias.add(alergia);
    }
    public List<Citamedica> obtenerHistorial(){
        return new ArrayList<>(citas);
    }
     public String getGrupoSanguineo() { return grupoSanguineo; }

    public List<String> getAlergias() {
        return new ArrayList<>(alergias);
    }
        public void setGrupoSanguineo(String grupo) {
        this.grupoSanguineo = grupo;
    }

    public void setHistoriaClinicaId(String id) {
        this.historiaClinica = id;
    }
    
    
}
