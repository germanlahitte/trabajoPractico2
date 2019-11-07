package algoChess.Armas;

import algoChess.Piezas.Pieza;

public class ArmaCurandero extends Arma {


    /*public ArmaCurandero(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }*/

    public ArmaCurandero() {
        super(15, Rango.cercano());
    }


}
