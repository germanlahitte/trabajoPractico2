package modelo.armas;
import excepciones.DistanciaArmaInefectiva;
import modelo.ProveedorConstantes;
import modelo.piezas.Pieza;

public class ArmaCurandero extends Arma {

    public ArmaCurandero() {
        super(ProveedorConstantes.armaCurandero(), Rango.cercano());
    }
    public void atacarA(Pieza pieza, int distancia) {
        if (rango.enRango(distancia)){
            pieza.curarse(this.danio);
        } else {
            throw new DistanciaArmaInefectiva();
        }
    }

}
