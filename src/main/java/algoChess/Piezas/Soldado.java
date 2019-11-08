package algoChess.Piezas;

import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;

    public Soldado(Equipo equipo) {

        super(100, equipo);
        this.agregarArma(new ArmaSoldado());

    }

    public static int getCosto() { return costo; }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
