package algochess.Ubicacion.StrategyDisponibilidad;

import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;

public class StrategyLibre implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
        casillero.asignarPieza(pieza);
    }

    public void quemar(int danio, Casillero unCasillero) { }
}
