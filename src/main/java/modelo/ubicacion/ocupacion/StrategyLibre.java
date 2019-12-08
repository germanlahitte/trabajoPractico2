package modelo.ubicacion.ocupacion;

import modelo.piezas.Pieza;
import modelo.ubicacion.Casillero;

public class StrategyLibre implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
        casillero.asignarPieza(pieza);
    }

    public void quemar(int danio, Casillero unCasillero) { }
}
