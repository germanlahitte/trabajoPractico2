package excepciones;

public class ElJuegoTerminoPorqueHayUnGanadorException extends RuntimeException {
    public ElJuegoTerminoPorqueHayUnGanadorException(String juego_terminado){super(juego_terminado);}
}
