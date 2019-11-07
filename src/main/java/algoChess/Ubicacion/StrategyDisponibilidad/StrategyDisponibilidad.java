package algoChess.Ubicacion.StrategyDisponibilidad;

import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;

public interface StrategyDisponibilidad {

    public abstract void agregarPieza(Pieza aAgregar, Casillero enEsteCasillero);

    public abstract void quitarPieza(Casillero esteCasillero);
}
