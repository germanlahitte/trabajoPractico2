package algochess.Ubicacion.StrategyAlcanzado;

import algochess.Ubicacion.Casillero;

public interface StrategyAlcanzado {

    void quemar(int danio, Casillero unCasillero);

    void altoElFuego(Casillero casillero);
}
