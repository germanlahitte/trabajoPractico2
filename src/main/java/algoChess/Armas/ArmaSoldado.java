package algoChess.Armas;

import algoChess.Piezas.Pieza;

public class ArmaSoldado extends Arma {


    /*public ArmaSoldado(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }*/
    public ArmaSoldado() {
        super(10, Rango.cercano());
    }
}
