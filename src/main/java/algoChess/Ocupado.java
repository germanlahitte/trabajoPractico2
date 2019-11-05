package algoChess;

import excepciones.CasilleroOcupadoException;

public class Ocupado extends Disponibilidad {

    protected void agregarPieza(Pieza aAgregar,Casillero esteCasillero){
        throw new CasilleroOcupadoException("Casillero Ocupado");
    }

    protected void quitarPieza(Casillero esteCasillero) {
        esteCasillero.desocupar();
    }
}
