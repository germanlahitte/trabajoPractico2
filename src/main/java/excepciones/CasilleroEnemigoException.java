package excepciones;

public class CasilleroEnemigoException extends RuntimeException{
    public CasilleroEnemigoException(String casillero_enemigo) { super(casillero_enemigo); }
}
