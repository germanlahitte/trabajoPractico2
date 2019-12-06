package excepciones;

public class BatallonSoldadosInsuficientes extends RuntimeException {
    public BatallonSoldadosInsuficientes() {
        super("No hay suficientes soldados");
    }
}
