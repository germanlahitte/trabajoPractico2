package algoChess.Armas;

import algoChess.Piezas.Pieza;

public class ArmaCatapulta extends Arma {
    public ArmaCatapulta(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }

    @Override
    public int atacar(Pieza unaPieza, int aUnaDistancia) {
        int danio = 0;
        if(aUnaDistancia>=6){
            danio = this.danioAdistancia;
        }
        return danio;
    }
}
