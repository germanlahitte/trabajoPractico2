package algochess.Armas;
import algochess.FactoryConstantes;
import algochess.Piezas.Pieza;

public class ArmaCurandero extends Arma {

    public ArmaCurandero() {
        super(FactoryConstantes.armaCurandero(), Rango.cercano());
    }
    public void atacarA(Pieza pieza, int distancia) {
        if(rango.enRango(distancia)){ pieza.curarse(this.danio); }
    }

}
