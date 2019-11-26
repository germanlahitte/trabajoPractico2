package excepciones;

public class CasilleroOcupadoException extends RuntimeException {
    public CasilleroOcupadoException(String casillero_ocupado) { super(casillero_ocupado); }
}
