package algochess.Ubicacion.StrategyAlcanzado;

import algochess.Ubicacion.Casillero;

public class StrategyQuemado implements StrategyAlcanzado {

    public void quemar(int danio, Casillero unCasillero) { }

    @Override
    public void altoElFuego(Casillero casillero) {
        casillero.noQuemado();
    }
}
