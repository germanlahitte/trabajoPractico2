package excepciones;

public class PiezaNoPuedeAtacar extends RuntimeException {
    public PiezaNoPuedeAtacar(String errorText) {
        super(errorText);
    }
}
