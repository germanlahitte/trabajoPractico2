package algoChess.Armas;
import algoChess.Piezas.Pieza;

public class ArmaCurandero extends Arma {

    private static int danio = 15;

    public ArmaCurandero() {
        super(danio, Rango.cercano());
    }
    public void atacarA(Pieza pieza, int distancia) {
        if(rango.enRango(distancia)){ pieza.curarse(this.danio); }
    }

}
