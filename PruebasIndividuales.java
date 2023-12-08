public class PruebasIndividuales extends Prueba{
    private String nombrePruebaInd;

    public PruebasIndividuales(String nombrePruebaInd) {
        this.nombrePruebaInd = nombrePruebaInd;
    }

    public String PruebasInd() {
        String txPruebasInd = null;
        switch (this.nombrePruebaInd) {
            case "Hemograma":
                txPruebasInd = getHemograma();
                break;
            case "Renal":
                txPruebasInd = getRenal();
                break;
            case "Examen de orina":
                txPruebasInd = getOrina();
                break;
            case "TGO":
                txPruebasInd = getTGO();
                break;
            case "TGP":
                txPruebasInd = getTGP();
                break;
            case "Urea":
                txPruebasInd = getUrea();
                break;
            case "Creatinina":
                txPruebasInd = getCreatinina();
        }

        return txPruebasInd;
    }
}