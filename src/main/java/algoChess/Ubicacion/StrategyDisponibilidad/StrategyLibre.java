package algoChess.Ubicacion.StrategyDisponibilidad;

import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;

public class StrategyLibre extends StrategyDisponibilidad {

    public void agregarPieza(Pieza aAgregar, Casillero esteCasillero){
        aAgregar.ocupar(esteCasillero);
        esteCasillero.ocupar(aAgregar);
    }

    public void quitarPieza(Casillero esteCasillero){

    }
}
