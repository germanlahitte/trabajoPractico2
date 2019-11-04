package excepciones;

public class NoAlcanzanLasMonedasException extends RuntimeException {
    public NoAlcanzanLasMonedasException(String mensaje){
        super(mensaje);
    }
}
