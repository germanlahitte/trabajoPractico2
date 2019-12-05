package excepciones;

public class ArmaNoPuedeAtacarException extends RuntimeException {
    public ArmaNoPuedeAtacarException(String errorText) {
        super(errorText);
    }
}
