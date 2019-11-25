package algochess.ubicacion.ocupacion;

import algochess.piezas.Pieza;
import algochess.ubicacion.Casillero;

public class StrategyLibre implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
        casillero.asignarPieza(pieza);
    }

    public void quemar(int danio, Casillero unCasillero) { }
}
