import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paciente {
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String correo;

    private List<PruebasIndividuales> pruebas;

    public Paciente(String nombre, String apellido, String dni, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.pruebas = new ArrayList<>();
    }

    public void agregarPrueba(PruebasIndividuales prueba) {
        this.pruebas.add(prueba);
    }

    public List<PruebasIndividuales> getPruebas() {
        return pruebas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String obtenerInformacion() {
        new SimpleDateFormat("dd-MM-yyyy");
        return "DNI: " + this.dni + ", Nombre: " + this.nombre + " " + this.apellido + ", Dirección: " + this.direccion + ", Celular: " + this.telefono + ", Correo: " + this.correo;
    }


    @Override
    public String toString() {
        return "Paciente " + "\n" +
                "nombre: " + nombre + "\n" +
                "apellido: " + apellido + "\n" +
                "dni: " + dni + "\n" +
                "telefono: " + telefono + "\n" +
                "correo: " + correo + "\n" ;

    }
}