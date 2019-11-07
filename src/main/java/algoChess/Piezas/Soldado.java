package algoChess.Piezas;

import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{

    public Soldado(Equipo equipo) {
        super(1, 100, equipo);
        this.agregarArma(new ArmaSoldado());
    }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
