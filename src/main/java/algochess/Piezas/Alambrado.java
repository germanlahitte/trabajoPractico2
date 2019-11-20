package algochess.Piezas;

import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Casillero;

public class Alambrado extends Pieza {

    public Alambrado(Casillero casillero, Equipo equipo) {
        super(FactoryConstantes.vidaAlambrado(), equipo);
        this.casillero = casillero;
        casillero.asignarPieza(this);
        casillero.quemado();
    }
}
