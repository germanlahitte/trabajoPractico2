package algoChess;

public abstract class Disponibilidad {

    protected abstract void agregarPieza(Pieza aAgregar,Casillero enEsteCasillero);

    protected abstract void quitarPieza(Casillero esteCasillero);
}
