package algoChess.Armas;

import algoChess.Piezas.Pieza;

public class ArmaJinete extends Arma {
    public ArmaJinete(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }

    @Override
    public int atacar(Pieza unaPieza, int aUnaDistancia) {
        int danio =0;
        if(aUnaDistancia<=2){
            danio = this.danio;
        }else if(aUnaDistancia>=3 && aUnaDistancia<=5){
            danio = this. danio;
        }else{
            danio = this.danioAdistancia;
        }
        return danio;
    }
}
