package algoChess.Ubicacion.StrategyDisponibilidad;

import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;

public class Libre extends Disponibilidad {

    public void agregarPieza(Pieza aAgregar, Casillero esteCasillero){
        aAgregar.ocupar(esteCasillero);
        esteCasillero.ocupar(aAgregar);
    }

    public void quitarPieza(Casillero esteCasillero){

    }
}