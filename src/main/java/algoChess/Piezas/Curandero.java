package algoChess.Piezas;

import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Direccion;

public class Curandero extends Pieza implements Movible {

    public Curandero(Equipo equipo) {
        super(2, 75, equipo);
        this.agregarArma(new ArmaCurandero());
    }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

}

