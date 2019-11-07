package algoChess.Ubicacion.StrategyDisponibilidad;

import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;

public class StrategyLibre implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
    //    aAgregar.ocupar(esteCasillero);
    //    esteCasillero.ocupar(aAgregar);
        casillero.asignarPieza(pieza);
    }

//    public void quitarPieza(Casillero esteCasillero){

//    }
}
