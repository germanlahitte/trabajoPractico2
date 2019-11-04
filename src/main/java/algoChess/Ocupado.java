package algoChess;

public class Ocupado extends Disponibilidad {

    protected void agregarPieza(Pieza aAgregar,Casillero esteCasillero){
    }

    protected void quitarPieza(Casillero esteCasillero) {
        esteCasillero.desocupar();
    }
}
