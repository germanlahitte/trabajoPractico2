package algoChess.Ubicacion.StrategyDisponibilidad;

import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;

public interface StrategyDisponibilidad {

    void agregarPieza(Pieza pieza, Casillero casillero);

//    void quitarPieza(Casillero casillero);
}
