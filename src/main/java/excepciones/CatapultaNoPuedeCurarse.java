package excepciones;

public class CatapultaNoPuedeCurarse extends RuntimeException {
    public CatapultaNoPuedeCurarse() {
        super("No se puede curar una catapulta");
    }
}
