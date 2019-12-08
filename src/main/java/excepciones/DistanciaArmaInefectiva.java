package excepciones;

public class DistanciaArmaInefectiva extends RuntimeException {
    public DistanciaArmaInefectiva() {
        super("Fuera de rango");
    }
}
