package algoChess.Piezas;

import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;

public class Catapulta extends Pieza {

    public Catapulta(Equipo equipo) {
        super(5, 50, equipo);
        this.agregarArma(0,20);
    }
    @Override
    public void atacar(Pieza objetivo) {
        objetivo.atacadaDesde(this.ubicacion, this.arma);
    }

    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        this.arma = new ArmaCatapulta(danio,danioADistancia);
    }
}

