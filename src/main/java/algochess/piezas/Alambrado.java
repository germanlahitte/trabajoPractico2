package algochess.piezas;

import algochess.equipos.Equipo;
import algochess.ProveedorConstantes;
import algochess.ubicacion.Casillero;

public class Alambrado extends Pieza {

    public Alambrado(Casillero casillero, Equipo equipo) {
        super(ProveedorConstantes.vidaAlambrado(), equipo);
        casillero.agregarPieza(this);
        casillero.quemado();
    }
}
