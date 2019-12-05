package modelo.armas;


import excepciones.DistanciaArmaInefectiva;
import modelo.ProveedorConstantes;
import modelo.piezas.Pieza;

public class ArmaCatapulta extends Arma {

    public ArmaCatapulta() {
        super(ProveedorConstantes.armaCatapulta(), Rango.lejano());
    }

    public void atacarA(Pieza unaPieza, int distancia) {
        if(this.rango.enRango(distancia)){
            unaPieza.casillero().bombardeo(this.danio);
            unaPieza.casillero().altoElFuego();
        } else {
            throw new DistanciaArmaInefectiva();
        }

    }
}
