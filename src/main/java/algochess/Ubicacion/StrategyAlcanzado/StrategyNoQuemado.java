package algochess.Ubicacion.StrategyAlcanzado;

import algochess.Ubicacion.Casillero;

public class StrategyNoQuemado implements StrategyAlcanzado {

    @Override
    public void quemar(int danio, Casillero unCasillero) { unCasillero.quemar(danio); }

    @Override
    public void altoElFuego(Casillero casillero) { }
}
