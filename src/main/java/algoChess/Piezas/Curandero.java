package algoChess.Piezas;

import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Direccion;

public class Curandero extends Pieza implements Movible {
    private static int costo = 2;
    public Curandero(Equipo equipo) {
        super(75, equipo);
        this.agregarArma(new ArmaCurandero());
    }

    public static int getCosto() { return costo; }


    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

}

