package algochess.Armas;


import algochess.FactoryConstantes;
import algochess.Piezas.Pieza;

public class ArmaCatapulta extends Arma {

    public ArmaCatapulta() {
        super(FactoryConstantes.armaCatapulta(), Rango.lejano());
    }

    public void atacarA(Pieza unaPieza, int distancia) {
        if(this.rango.enRango(distancia)){
            unaPieza.casillero().bombardeo(this.danio);
            unaPieza.casillero().altoElFuego();
        }
    }
}
