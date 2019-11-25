package algochess.ubicacion.alcanzado;

import algochess.ubicacion.Casillero;

public class StrategyNoQuemado implements StrategyAlcanzado {

    @Override
    public void quemar(int danio, Casillero unCasillero) { unCasillero.quemar(danio); }

}
