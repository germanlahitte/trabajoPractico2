package algoChess;

public class Libre extends Disponibilidad {

    protected void agregarPieza(Pieza aAgregar,Casillero esteCasillero){
        aAgregar.ocupar(esteCasillero);
        esteCasillero.ocupar(aAgregar);
    }

    protected void quitarPieza(Casillero esteCasillero){

    }
}
