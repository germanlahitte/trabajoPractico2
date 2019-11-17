package algochess.Piezas;

import algochess.Armas.ArmaSoldado;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;

    public Soldado(Equipo equipo) {

        super(FactoryConstantes.vidaSoldado(), equipo);
        this.agregarArma(new ArmaSoldado());

    }

    public static int getCosto() { return costo; }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
