package algoChess.Piezas;

import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;

public class Jinete extends Pieza {
    private static int costo = 3;

    public Jinete(Equipo equipo) {
        super(costo, 100, equipo);
        this.agregarArma(5,15);
    }

    public static int getCosto() {
        return costo;
    }

    @Override
    public void mover(Casillero destino) {
        destino.agregarPieza(this);
    }

    @Override
    public void atacar(Pieza objetivo) {
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }

    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        this.arma = new ArmaJinete(danio,danioADistancia);

    }

}
