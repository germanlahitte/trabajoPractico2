package algoChess.Armas;

import algoChess.Piezas.Pieza;

public class EspadaJinete extends Arma {

    /*public EspadaJinete(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }*/

    public EspadaJinete() {
        super(5, Rango.cercano());
    }
}
