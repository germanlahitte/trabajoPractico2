package modelo.piezas;

import modelo.equipos.Equipo;
import modelo.ProveedorConstantes;
import modelo.ubicacion.Casillero;

public class Alambrado extends Pieza {

    public Alambrado(Casillero casillero, Equipo equipo) {
        super(ProveedorConstantes.vidaAlambrado(), equipo);
        casillero.agregarPieza(this);
        casillero.quemado();
    }
}
