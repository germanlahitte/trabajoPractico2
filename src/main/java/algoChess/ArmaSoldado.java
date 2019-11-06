package algoChess;

public class ArmaSoldado extends Arma{
    public ArmaSoldado(int danio, int danioAdistancia) {
        super(danio, danioAdistancia);
    }
    @Override
    public int atacar(Pieza unaPieza, int aUnaDistancia){
        int danio = 0;
        if(aUnaDistancia<=2) {
            danio = this.danio;
        }
        return danio;
    }
}
