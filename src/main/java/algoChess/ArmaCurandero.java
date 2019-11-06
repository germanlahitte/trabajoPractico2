package algoChess;

public class ArmaCurandero extends Arma{
    public ArmaCurandero(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }

    @Override
    public int atacar(Pieza unaPieza, int aUnaDistancia) {
        int danio = 0;
        if(aUnaDistancia<=2) {
            danio = this.danio;
        }
        return danio;
    }
}
