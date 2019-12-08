package modelo.ubicacion.alcanzado;

import modelo.ubicacion.Casillero;

public class StrategyNoQuemado implements StrategyAlcanzado {

    @Override
    public void quemar(int danio, Casillero unCasillero) { unCasillero.quemar(danio); }

}
