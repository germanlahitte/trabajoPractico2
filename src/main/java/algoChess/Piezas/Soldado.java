package algoChess.Piezas;

import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;
    private static int vida = 100;

    public Soldado(Equipo equipo) {

        super(vida, equipo);
        this.agregarArma(new ArmaSoldado());

    }

    public static int getCosto() { return costo; }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
