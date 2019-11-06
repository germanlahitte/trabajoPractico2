package algoChess;

public abstract class Arma { //TODO :lo mínimo para compilar
    protected int danio;
    protected int danioAdistancia;

    public Arma(int danio, int danioAdistancia) {
        this.danio = danio;
        this.danioAdistancia = danioAdistancia;
    }

    public abstract int atacar(Pieza unaPieza, int aUnaDistancia);

}

