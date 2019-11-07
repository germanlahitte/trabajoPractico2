package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;

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

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {
        this.curadaDesde(ubicacion,arma);
    }

}
