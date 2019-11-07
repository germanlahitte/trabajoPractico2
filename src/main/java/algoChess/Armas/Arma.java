package algoChess.Armas;

import algoChess.Piezas.Pieza;

public abstract class Arma { //TODO :lo mínimo para compilar
    protected int danio;

    protected Rango rango;


    public Arma(int danio, Rango rango) {
        this.danio = danio;
        this.rango = rango;
    }

    public void atacarA(Pieza unaPieza, int distancia) {

        if(rango.enRango(distancia)){
            unaPieza.quitarVida(this.danio);
        }
        unaPieza.quitarVida(0);
    }
}

