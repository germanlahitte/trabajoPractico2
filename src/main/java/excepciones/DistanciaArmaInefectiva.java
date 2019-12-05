package excepciones;

public class DistanciaArmaInefectiva extends RuntimeException {
    public DistanciaArmaInefectiva(String fuera_de_rango) {
        super(fuera_de_rango);
    }
}
