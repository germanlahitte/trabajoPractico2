package algoChess.Ubicacion.StrategyDisponibilidad;

import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;
import excepciones.CasilleroOcupadoException;

public class StrategyOcupado implements StrategyDisponibilidad {

    public void agregarPieza(Pieza aAgregar, Casillero esteCasillero){
        throw new CasilleroOcupadoException("Casillero Ocupado");
    }

    public void quitarPieza(Casillero esteCasillero) {
        esteCasillero.desocupar();
    }
}
