package algoChess.Armas;
import algoChess.Piezas.Pieza;

public class ArmaCurandero extends Arma {

    public ArmaCurandero() {
        super(15, Rango.cercano());
    }
    public void atacarA(Pieza pieza, int distancia) {
        if(rango.enRango(distancia)){ pieza.curarse(this.danio); }
    }

}
