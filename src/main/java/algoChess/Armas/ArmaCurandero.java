package algoChess.Armas;
import algoChess.FactoryConstantes;
import algoChess.Piezas.Pieza;

public class ArmaCurandero extends Arma {

    public ArmaCurandero() {
        super(FactoryConstantes.armaCurandero(), Rango.cercano());
    }
    public void atacarA(Pieza pieza, int distancia) {
        if(rango.enRango(distancia)){ pieza.curarse(this.danio); }
    }

}
