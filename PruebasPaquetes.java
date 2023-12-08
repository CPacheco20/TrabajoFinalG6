public class PruebasPaquetes {
    private String NombrePaquete;
    String Sugerencias = " debe tener un ayuno de 8 horas";
    String SugOrina = " se debe traer la primera orina del día";

    public PruebasPaquetes(String nombrePaquete) {
        this.NombrePaquete = nombrePaquete;
    }

    public String PaquetesPrueb() {
        String txPaquetePrueb = null;
        switch (this.NombrePaquete) {
            case "1":
                txPaquetePrueb = "El paquete cuesta 60 Nuevos Soles";
                break;
            case "2":
                txPaquetePrueb = "El paquete cuesta 70 Nuevos Soles y";
                break;
            case "3":
                txPaquetePrueb = "El paquete cuesta 65 Nuevos Soles";
        }

        return txPaquetePrueb;
    }
}