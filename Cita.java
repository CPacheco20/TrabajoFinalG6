public class Cita extends Paciente {

    private String fechaCita;
    private String horaCita;
    private String motivoCita;

    public Cita(String nombre, String apellido, String dni, String direccion, String telefono, String correo, String fechaCita, String horaCita, String motivoCita) {
        super(nombre, apellido, dni, direccion, telefono, correo);
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivoCita = motivoCita;
    }

    public void registrarCita(String dnipacientecita, String nombre, String apellido, String Direccion, String Telefono, String correo, String horaCita, String motivoCita, String medicoAsignado) {
    }

    public void obtenerCita() {
    }

    public void VerCita() {
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return this.horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getMotivoCita() {
        return this.motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String obtenerInformacioCita() {
        return "Cita{fechaCita='" + this.fechaCita + "', horaCita='" + this.horaCita + "', motivoCita='" + this.motivoCita + "'}";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Cita " + "\n" +
                "fechaCita: " + fechaCita + "\n" +
                "horaCita: " + horaCita + "\n" +
                "motivoCita: " + motivoCita + "\n";


    }
}