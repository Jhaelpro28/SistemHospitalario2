package Modelo.personas;
import Modelo.abstracto.Empleado;
import Modelo.enums.*;
import java.time.LocalDate;
public abstract class Enfermero extends Empleado {
    private Turno turno;
    private String areaAsignada;
    private int pacientesACargo;

    public Enfermero(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo,
            Turno turno, String areaAsignada, int pacientesACargo) {
        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.turno = turno;
        this.areaAsignada = areaAsignada;
        this.pacientesACargo = pacientesACargo;
    }
        @Override
    public double calcularSalario() {
        double bono = switch (turno) {
            case MANANA -> 50;
            case NOCHE -> 200;
            case TARDE -> 100;
            default -> 50;
        };
        return getsalarioBase() + bono;
    }
    @Override
    public int calcularEdad(){
        return LocalDate.now().getYear() - getfechaNacimiento().getYear();
    }
    @Override
    public String obtenerTipo(){
        return "Enfermero";
    }
    public void asistirCirugia(){
        System.out.println("El enfermero esta asistiendo la cirugia en :" + areaAsignada);
    }

    public Turno getTurno() {
        return turno;
    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public int getPacientesACargo() {
        return pacientesACargo;
    }
    public void setTurno(Turno turno) { this.turno = turno; }

    public void setAreaAsignada(String area) { this.areaAsignada = area; }

    public void setPacientesACargo(int cantidad) {
        if (cantidad >= 0) this.pacientesACargo = cantidad;
    }
}