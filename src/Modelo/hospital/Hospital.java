
package Modelo.hospital;
import java.util.ArrayList;
import Modelo.abstracto.Empleado;
import Modelo.personas.Paciente;
import Modelo.enums.*;
import java.util.List;

public class Hospital  {
    private String nombre;
    private String direccion;
    private ArrayList<Empleado> empleado;
    private ArrayList<Paciente> paciente;
    private ArrayList<Citamedica> citas;
    private ArrayList<EstadoCita> Estado;
    
    public Hospital(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.empleado = new ArrayList<>();
        this.paciente = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.Estado = new ArrayList<>();
        
    }
    public void contratarEmpleado(Empleado e){
        this.empleado.add(e);
    }
    public void agregarPaciente(Paciente p){
        paciente.add(p);
    }
    public void agendarCitas(Citamedica c){
        citas.add(c);
    }
    public double calcularNominaTotal(){
        double total = 0;
        for(Empleado e : empleado){
            String tipoEmpleado = e.getClass().getSimpleName();
        System.out.println("---------------------------------------");
        System.out.println("ID: " + e.getId() + " | Tipo: " + tipoEmpleado);
        System.out.println("Nombre: " + e.getNombre());
        System.out.println("Salario con Bonos: $" + e.calcularSalario());
        total += e.calcularSalario();
    }
        System.out.println("\n>>> TOTAL NÓMINA HOSPITAL: $" + total);
        return total;
    }
        public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleado);
    }

    public List<Paciente> getPacientes() {
        return this.paciente;
    }

    public List<Citamedica> getCitas() {
        return new ArrayList<>(citas);
    }
    public Empleado buscarEmpleado(String id){
        for (Empleado e : empleado){
            if(e.getId().equals(id)){
                return e;
            }
        }
        return null;
    }
    public Paciente buscarPaciente(String id) {
    // 'pacientes' debe ser el nombre de tu ArrayList en Hospital
    for (Paciente p : paciente) { 
        if (p.getId().equals(id)) {
            return p;
        }
    }
    return null;
}
    public void registrarPaciente(Paciente nuevo) {
        this.paciente.add(nuevo);
    }

    public ArrayList<EstadoCita> getEstado() {
        return Estado;
    }

    public void setEstado(ArrayList<EstadoCita> Estado) {
        this.Estado = Estado;
    }
    
}

