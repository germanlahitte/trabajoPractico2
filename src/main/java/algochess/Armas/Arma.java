package algochess.Armas;

import algochess.Piezas.Pieza;

public abstract class Arma {
    protected int danio;
    protected Rango rango;

    public Arma(int danio, Rango rango) {
        this.danio = danio;
        this.rango = rango;
    }
    public void atacarA(Pieza unaPieza, int distancia) {
        if(this.rango.enRango(distancia)){
            unaPieza.quitarVida(this.danio);
        }
    }
}

