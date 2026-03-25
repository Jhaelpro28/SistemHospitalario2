
package Principal;

import Modelo.abstracto.*;
import Modelo.enums.*;
import Modelo.hospital.*;
import Modelo.personas.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class SistemaHospitalDemo {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital("","");
    int opcion;
    
    do{
        System.out.println("\n Sistema Hospitalario");
        System.out.println("1. Gestion de pacientes");
        System.out.println("2. Gestion de Personal");
        System.out.println("3. Gestion citas");
        
        System.out.println("Seleccione una opcion:");
        opcion = sc.nextInt();
        sc.nextLine();
        
        switch(opcion){
            case 1 -> menuPaciente(sc, hospital);
            case 2 -> menuPersonal(sc, hospital);
            
            case 3 -> menuCitas(sc, hospital);
        }
    }while(opcion!=0);
    //=========== Recepcionista============
    
        
    }
    static void menuPaciente(Scanner sc, Hospital hospital){
        int op1;
        do{
            System.out.println("\n Recepcionista");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar alergias");
            System.out.println("3. Consultar historial de citas medicas");
            System.out.println("Seleccione una opcion");
            op1 = sc.nextInt();
            sc.nextLine();
            
            switch(op1){
                case 1:
                    System.out.println("\n Registro de paciente");
                    System.out.println("ID: "); String id = sc.nextLine();
                    System.out.println("Nombre: ");String nombre = sc.nextLine();
                    System.out.println("Apellido: "); String apellido = sc.nextLine();
                    System.out.println("Email: ");String email = sc.nextLine();
                    System.out.println("Grupo sanguineo: "); String grupoSanguineo = sc.nextLine();
                    
                    Paciente p = new Paciente(id, nombre, apellido, LocalDate.of(1999, 1,1), nombre+"@mail.com", "",grupoSanguineo) {};
                    p.setId(id);
                    p.setNombre(nombre);
                    p.setApellido(apellido);
                    p.setEmail(email);
                    hospital.getPacientes().add(p);
                    System.out.println("Paciente registrado");
                    break;
                case 2:
                    System.out.println("\n ==== Registrar Alergia====");
                    System.out.println("Ingres el ID del paciente:  ");
                    String idBusqueda = sc.nextLine();
                    
                    
                    Paciente pacienteEncontrado = null;
                    for(Paciente paciente: hospital.getPacientes()){
                        if(paciente.getId().equalsIgnoreCase(idBusqueda)){
                            pacienteEncontrado = paciente;
                            break;
                        }
                    }
                    if(pacienteEncontrado != null){
                        System.out.println("Ingrese la alergia a añadir para: " +
                                pacienteEncontrado.getNombre() + ":");
                        String nuevaAlergia = sc.nextLine();
                        pacienteEncontrado.agregarAlergia(nuevaAlergia);
                        System.out.println("Alergia añadida");
                    }else{
                        System.out.println("ERROR: No exite un paciente con ese id");
                    }
                case 3:
                    System.out.println("Historial clinico");
                    break;
                

            }
        }while(op1 !=0);
    }
    static void menuPersonal(Scanner sc, Hospital hospital){
        int op2;
       do {
        System.out.println("\n === Registro de Personal ===");
        System.out.println("1. Registrar Medico");
        System.out.println("2. Registrar Cirujano");
        System.out.println("3. Registrar Enfermero");
        System.out.println("4. Calcular Salario Total");
        System.out.println("5. Lista de personal contratado");
        System.out.print("Seleccione una opción: ");
        op2 = sc.nextInt();
        sc.nextLine(); // Limpieza crucial después de nextInt()

        if (op2 >= 1 && op2 <= 3) {
            // --- 1. VALIDACIÓN DE ID ---
            System.out.print("Ingrese ID: ");
            String id = sc.nextLine();

            if (hospital.buscarEmpleado(id) != null) {
                System.out.println("❌ ERROR: Empleado con ID [" + id + "] ya está en el sistema.");
                continue; // Regresa al inicio del menú sin pedir más datos
            }

            // --- 2. DATOS COMUNES ---
            System.out.print("Nombre: "); String nombre = sc.nextLine();
            System.out.print("Apellido: "); String apellido = sc.nextLine();
            System.out.print("Email: "); String email = sc.nextLine();
            System.out.print("Legajo: "); String legajo = sc.nextLine();
            System.out.print("Salario Base: "); double salarioBase = sc.nextDouble();
            sc.nextLine(); // Limpieza tras nextDouble()
            

            System.out.println("Turno: 1. Mañana / 2. Tarde / 3. Noche");
            int opT = sc.nextInt();
            sc.nextLine(); // Limpieza tras nextInt()
            
            // Lógica simple para el turno (ajusta según tus Enums)
            Turno turnoSel = (opT == 2) ? Turno.TARDE : (opT == 3) ? Turno.NOCHE : Turno.MANANA;

            // --- 3. DATOS ESPECÍFICOS Y CREACIÓN ---
            if (op2 == 1) { // MÉDICO
                System.out.print("Número de Licencia: "); String nLicencia = sc.nextLine();
                System.out.print("Nombre Especialidad: "); String nEsp = sc.nextLine();
                System.out.print("Costo Consulta: "); double costo = sc.nextDouble();
                sc.nextLine(); 

                // Creamos la especialidad y luego el médico
                Especialidad esp = new Especialidad("E01", nEsp, "General", costo);
                Medico nuevoMedico = new Medico(id, nombre, apellido, LocalDate.now(), email, legajo, LocalDate.now(), salarioBase, true, esp, turnoSel) {};
                nuevoMedico.setId(id);
                nuevoMedico.setNombre(nombre);
                nuevoMedico.setApellido(apellido);
                nuevoMedico.setFechaNacimiento(LocalDate.MIN);
                nuevoMedico.setEmail(email);
                
                nuevoMedico.setsalarioBase(salarioBase);
                
                // ¡IMPORTANTE! Guardar en el hospital
                hospital.contratarEmpleado(nuevoMedico);
                System.out.println("✅ Médico registrado correctamente.");

            } else if (op2 == 2) { // CIRUJANO
                System.out.print("Nombre Especialidad: "); String nEspc = sc.nextLine();
                System.out.print("Número de Licencia: "); int nLicenciac = sc.nextInt();
                System.out.print("Cirugías realizadas: "); int cirugias = sc.nextInt();
                System.out.print("Costo Consulta: "); double costoc = sc.nextDouble();
                System.out.println("Disponible Emergencia: ");boolean disp = sc.nextBoolean();
                sc.nextLine();
                Especialidad espc = new Especialidad("E01", nEspc, "General", costoc);
                Cirujano nuevoCirujano = new Cirujano(id, nombre, apellido, LocalDate.now(), email, legajo, LocalDate.now(), salarioBase, true, nLicenciac, espc,turnoSel, cirugias,disp);
                nuevoCirujano.setId(id);
                nuevoCirujano.setNombre(nombre);
                nuevoCirujano.setApellido(apellido);
                nuevoCirujano.setFechaNacimiento(LocalDate.MIN);
                nuevoCirujano.setsalarioBase(salarioBase);
                nuevoCirujano.setEmail(email);
                hospital.contratarEmpleado(nuevoCirujano);
                System.out.println("✅ Cirujano registrado correctamente.");

            } else if (op2 == 3) { // ENFERMERO
                System.out.print("¿Tiene disponibilidad? (true/false): "); boolean disp = sc.nextBoolean();
                sc.nextLine();

                Enfermero nuevoEnfermero = new Enfermero(id, nombre, apellido, LocalDate.now(), email, legajo, LocalDate.now(), salarioBase, true,turnoSel,"",0) {};
                
                hospital.contratarEmpleado(nuevoEnfermero);
                System.out.println("✅ Enfermero registrado correctamente.");
            }

        } else if (op2 == 4) {
            System.out.println("? La nómina total es: $" + hospital.calcularNominaTotal());
        }else if (op2 == 5) {
    System.out.println("\n--- PERSONAL EN SISTEMA ---");
    
    if (hospital.getEmpleados().isEmpty()) {
        System.out.println("No hay empleados registrados.");
    } else {
        for (Empleado e : hospital.getEmpleados()) {
            System.out.println("------------------------------------");
            System.out.println("ID: " + e.getId());
            System.out.println("Nombre: " + e.getNombre() + " " + e.getApellido());
            System.out.println("Legajo: " + e.getLegajo());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Salario Base: $" + e.getSalarioBase());
            
            // Si el empleado es un Medico, mostramos sus datos extra
            if (e instanceof Medico) {
                Medico m = (Medico) e; // Casting para acceder a métodos de Medico
                System.out.println("Cargo: Médico");
                System.out.println("Licencia: " + m.getNumeroLicencia());
                System.out.println("Especialidad: " + m.getEspecialidad().getNombre());
            } 
            
            // Si es un Cirujano, mostramos sus datos extra
            if (e instanceof Cirujano) {
                Cirujano c = (Cirujano) e;
                System.out.println("Cargo: Cirujano");
                System.out.println("Cirugías realizadas: " + c.getCirugiasRealizadas());
            }
            
            System.out.println("------------------------------------");
        }
    }

    } 
    
}while (op2 != 7);
    
    }
    static void menuCitas(Scanner sc, Hospital hospital){
        int op3;
do {
        System.out.println("\n Gestion de cita");
        System.out.println("1. Agendar Cita (Validar Médico y Costo)");
        System.out.println("2. Ver Citas y Cambiar Estados");
        System.out.println("3. Registrar Diagnóstico y Receta");
        System.out.println("4. Volver al Menú Principal");
        System.out.print(" Seleccione una opción: ");
        
        op3 = sc.nextInt();
        sc.nextLine(); // Limpiar buffer después de nextInt()

        switch (op3) {
            case 1: // --- AGENDAR CITA ---
                System.out.print("ID del Paciente: ");
                String idP = sc.nextLine();
                Paciente paciente = null;
                
                // Buscar paciente en la lista del hospital
                for (Paciente p : hospital.getPacientes()) {
                    if (p.getId().equals(idP)) { 
                        paciente = p; 
                        break; 
                    }
                }

                if (paciente == null) {
                    System.out.println(" ERROR: El paciente no está registrado.");
                    break;
                }

                System.out.print("ID del Médico: ");
                String idM = sc.nextLine();
                Empleado emp = hospital.buscarEmpleado(idM);

                // Validar que el ID pertenezca a un Médico y esté activo
                if (emp instanceof Medico) {
                    Medico medico = (Medico) emp;
                    
                    if (!medico.isActivo()) {
                        System.out.println("❌ ERROR: El médico no está disponible (Inactivo).");
                        break;
                    }

                    System.out.print("Fecha (AAAA-MM-DD): ");
                    LocalDateTime fecha = LocalDateTime.parse(sc.nextLine());
                    System.out.print("Hora (HH:mm): ");
                    String hora = sc.nextLine();
                    System.out.println("Motivo: ");
                    String motivo = sc.nextLine();

                    // CÁLCULO DE COSTO AUTOMÁTICO
                    // Base: Costo de la especialidad
                    double costoTotal = medico.getEspecialidad().getCostoConsulta(); 
                    
                    // Recargo por jerarquía (Si es Cirujano)
                    if (medico instanceof Cirujano) {
                        costoTotal += 500; 
                        System.out.println("ℹ️ Nota: Se aplicó recargo de $500 por honorarios de Cirugía.");
                    }

                    
                    
                    Citamedica nuevaCita = new Citamedica(idP, paciente, medico, fecha, motivo, EstadoCita.Pendiente, costoTotal, null);
                    nuevaCita.setFechaHora(fecha);
                    nuevaCita.setCosto(costoTotal);
                    hospital.getCitas().add(nuevaCita);
                    System.out.println("cita agendada exitosamente.");
                    System.out.println(" Costo total de atención: $" + costoTotal);

                } else {
                    System.out.println("❌ ERROR: El ID ingresado no corresponde a un personal médico.");
                }
                break;

            case 2: // --- CAMBIAR ESTADOS ---
                if (hospital.getCitas().isEmpty()) {
                    System.out.println("️ No hay citas registradas en el sistema.");
                    break;
                }
                
                System.out.println("\n--- LISTA DE CITAS ---");
                for (int i = 0; i < hospital.getCitas().size(); i++) {
                    Citamedica c = hospital.getCitas().get(i);
                    System.out.println(i + ". " + c.getFechaHora() + " | Paciente: " + c.getPaciente().getNombre() + 
                                       " | Estado actual: [" + c.getEstado() + "]");
                }
                
                System.out.print("\nSeleccione el número de índice: ");
                int indice = sc.nextInt();
                
                if (indice >= 0 && indice < hospital.getCitas().size()) {
                    System.out.println("Seleccione nuevo estado: 1.PENDIENTE, 2.CONFIRMADA, 3.EN_ATENCION, 4.COMPLETADA, 5.CANCELADA");
                    int est = sc.nextInt();
                    
                    EstadoCita[] estados = EstadoCita.values();
                    if (est >= 1 && est <= estados.length) {
                        hospital.getCitas().get(indice).setEstado(estados[est-1]);
                        System.out.println(" Estado actualizado a " + estados[est-1]);
                    } else {
                        System.out.println(" Opción de estado inválida.");
                    }
                } else {
                    System.out.println(" Índice de cita no válido.");
                }
                break;

            case 3: // --- REGISTRAR DIAGNÓSTICO Y RECETA ---
                System.out.print("Ingrese ID del Paciente para registrar consulta: ");
                String idBusca = sc.nextLine();
                boolean encontrado = false;

                for (Citamedica c : hospital.getCitas()) {
                    // Solo permite diagnosticar si la cita está "EN_ATENCION"
                    if (c.getPaciente().getId().equals(idBusca) && c.getEstado() == EstadoCita.En_Atencion) {
                        System.out.println("? Registrando consulta para: " + c.getPaciente().getNombre());
                        System.out.print("Diagnóstico clínico: ");
                        c.setDiagnostico(sc.nextLine());

                        
                        c.setEstado(EstadoCita.Completada);
                        System.out.println("✅ Consulta finalizada y guardada con éxito.");
                        encontrado = true;
                        break;
                    }
                }
                
                if (!encontrado) {
                    System.out.println(" No se encontró una cita 'EN ATENCIÓN' para este ID de paciente.");
                }
                break;

            case 4:
                System.out.println("Saliendo del módulo de citas...");
                break;

            default:
                System.out.println(" Opción no válida.");
                break;
        }
    } while (op3 != 4);
    }
    }