import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Multilab {
    int idCita = 1;
    private List<Paciente> pacientes;
    List<Cita> citas;
    private Scanner scanner;

    public Multilab() {
        scanner = new Scanner(System.in);
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
        precargarPacientes();
    }

    private void precargarPacientes() {
        Paciente paciente1 = new Paciente("Juan", "Pérez", "12345678A", "Calle Falsa 123", "600111222", "juan.perez@example.com");
        Paciente paciente2 = new Paciente("Ana", "García", "23456789B", "Avenida Siempre Viva 456", "600333444", "ana.garcia@example.com");
        Paciente paciente3 = new Paciente("Carlos", "Martín", "34567890C", "Plaza Mayor 789", "600555666", "carlos.martin@example.com");
        Paciente paciente4 = new Paciente("Laura", "López", "45678901D", "Camino del Rio 101", "600777888", "laura.lopez@example.com");
        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);
        pacientes.add(paciente4);


        Cita cita1 = new Cita("Luz","Garmendia","85632012","avenida garcilazo 128","9556314","Ana@gmail.com","17/12/23","22:00","Médico");
        citas.add(cita1);
    }

    private void registrarPacientes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("DNI: ");
        String dni = scanner.next();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellidos: ");
        String apellidos = scanner.next();
        System.out.print("fechaNacimiento: ");
        String fechaNacimiento = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Telefono: ");
        String telefono = scanner.next();
        System.out.print("Correo: ");
        String correo = scanner.next();
        Paciente nuevoPaciente = new Paciente(nombre, apellidos, dni, direccion, telefono, correo);
        pacientes.add(nuevoPaciente);
        System.out.println("Paciente registrado con éxito.");
        System.out.println("Ingresa el numero 0 para volver al menu anterior");
        int opcion = scanner.nextInt();
        procesaRegresarMenuPrincipal(opcion);
    }

    private void procesaRegresarMenuPrincipal(int opcion) {
        if (opcion == 0) {
            mostrarMenuPrincipal();
        }else {
            System.out.println("Error de dígito, Ingresa el numero 0 para volver al menu anterior");
            opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }
    }

    private void registrarCita() {
        System.out.print("DNI del Paciente: ");
        String dniPaciente = scanner.next();
        Paciente pacienteSeleccionado = buscarPacientePorDNI(dniPaciente, pacientes);
        if (pacienteSeleccionado != null) {
            System.out.print("Fecha de Cita (yyyy-MM-dd): ");
            String fechaCitaStr = scanner.next();
            System.out.print("Hora de Cita: ");
            String horaCita = scanner.next();
            System.out.print("Motivo de Cita: ");
            String motivoCita = scanner.next();
            Cita cita10 = new Cita(pacienteSeleccionado.getNombre(), pacienteSeleccionado.getApellido(), pacienteSeleccionado.getDni(), pacienteSeleccionado.getDireccion(), pacienteSeleccionado.getTelefono(), pacienteSeleccionado.getCorreo(), fechaCitaStr, horaCita, motivoCita);
            citas.add(cita10);
            System.out.println("Cita registrada con éxito.");
            System.out.println("Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        } else {
            System.out.println("Paciente no encontrado.");
            System.out.println("Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }
    }
    private static Paciente buscarPacientePorDNI(String dni, List<Paciente> pacientes) {
        Iterator<Paciente> var2 = pacientes.iterator();

        Paciente paciente;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            paciente = (Paciente) var2.next();
        } while (!paciente.getDni().equals(dni));
        return paciente;
    }
    public static void main(String[] args) {
        Multilab sistema = new Multilab();
        sistema.empezar();
    }
    public void empezar() {
        mostrarMenuPrincipal();
    }
    private void mostrarMenuPrincipal() {
        System.out.printf("BIENVENIDO A MULTILAB!");
        System.out.println("Seleecione una opcion:\n1.Registrar Pacientes\n2. Registrar Cita\n3.Visualizar Pacientes\n4.Vizualizar Citas\n5. Pruebas Medicas\n6. Mostrar pruebas registradas por Paciente\n7. Salir");
        System.out.println("Por favor digite la opcion: ");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            registrarPacientes();
        } else if (opcion == 2) {
            registrarCita();
        } else if (opcion == 3) {
            mostrarPacientes();
        } else if (opcion == 4) {
            mostrarListaCitas();
        } else if(opcion ==5){
            registrarPruebasMedicas();
        } else if(opcion ==6){
            mostrarPruebasMedicasPorPaciente();
        } else if (opcion==7) {
                System.exit(0);
        }
    }

    private void mostrarPruebasMedicasPorPaciente() {
        System.out.println("Ingrese el número del dni del paciente");
        String dni = scanner.next();
        Paciente paciente = buscarPacientePorDNI(dni,pacientes);
        if(paciente!=null){
            System.out.println("pruebas registradas para el paciente con dni " +paciente.getDni());
            for (PruebasIndividuales prueba : paciente.getPruebas()) {
                System.out.println(prueba.PruebasInd());
            }

        }else{
            System.out.println("Número de DNI INCORRECTO, Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }
    }

    private void registrarPruebasMedicas() {
        System.out.println("Ingrese dni del paciente: ");
        String dni = scanner.next();

        Paciente paciente = buscarPacientePorDNI(dni,pacientes);
        if(paciente!=null){
            System.out.println("Si existe un paciente con ese dni, ahora ingrese el nombre de la prueba ");
            String nombrePrueba = scanner.next();
            PruebasIndividuales prueba = new PruebasIndividuales(nombrePrueba);
            paciente.agregarPrueba(prueba);
            System.out.println("Prueba registrada exitosamente ");
            System.out.println("Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }else{
            System.out.println("no existe un paciente con ese dni");
            System.out.println("Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }
    }
    private void mostrarPacientes() {
        if (!pacientes.isEmpty()) {
            for (Paciente paciente : pacientes) {
                System.out.println(pacientes.indexOf(paciente) + 1);
                System.out.println(paciente);
            }
            System.out.println("Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }
    }
    private void mostrarListaCitas() {
        if (!citas.isEmpty()) {
            for (Cita cita : citas) {
                System.out.println("Informacion sobre la cita");
                System.out.println(citas.indexOf(cita) + 1);
                System.out.println(cita);

                System.out.println("Ingresa el numero 0 para volver al menu anterior");
                int opcion = scanner.nextInt();
                procesaRegresarMenuPrincipal(opcion);
            }
            System.out.println("Ingresa el numero 0 para volver al menu anterior");
            int opcion = scanner.nextInt();
            procesaRegresarMenuPrincipal(opcion);
        }System.out.println("Ingresa el numero 0 para volver al menu anterior");
        int opcion = scanner.nextInt();
        procesaRegresarMenuPrincipal(opcion);
    }
}