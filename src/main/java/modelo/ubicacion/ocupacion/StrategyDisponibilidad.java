package modelo.ubicacion.ocupacion;

import modelo.piezas.Pieza;
import modelo.ubicacion.Casillero;

public interface StrategyDisponibilidad {

    void agregarPieza(Pieza pieza, Casillero casillero);

    void quemar(int danio, Casillero casillero);
}
