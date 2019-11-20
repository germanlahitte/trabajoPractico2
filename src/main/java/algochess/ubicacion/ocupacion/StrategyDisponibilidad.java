package algochess.ubicacion.ocupacion;

import algochess.piezas.Pieza;
import algochess.ubicacion.Casillero;

public interface StrategyDisponibilidad {

    void agregarPieza(Pieza pieza, Casillero casillero);

    void quemar(int danio, Casillero casillero);
}
