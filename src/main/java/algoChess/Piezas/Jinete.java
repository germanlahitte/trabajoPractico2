package algoChess.Piezas;

import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Equipo;

public class Jinete extends Pieza {

    public Jinete(Equipo equipo) {
        super(3, 100, equipo);
        this.agregarArma(5,15);
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
