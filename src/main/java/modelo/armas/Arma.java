package modelo.armas;

import excepciones.CasilleroOcupadoException;
import excepciones.DistanciaArmaInefectiva;
import modelo.piezas.Pieza;

public abstract class Arma {
    protected int danio;
    Rango rango;

    public Arma(int danio, Rango rango) {
        this.danio = danio;
        this.rango = rango;
    }
    public void atacarA(Pieza unaPieza, int distancia) {
        if(!this.rango.enRango(distancia)){
            throw new DistanciaArmaInefectiva();
        } else {
            unaPieza.quitarVida(this.danio);
        }
    }
}

