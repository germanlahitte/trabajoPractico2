package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;

public class Catapulta extends Pieza {
    private static int costo = 5;

    public Catapulta(Equipo equipo) {
        super(costo, 50, equipo);
        this.agregarArma(0,20);
    }

    @Override
    public void mover(Casillero destino) {

    }

    public static int getCosto() {
        return costo;
    }

    @Override
    public void atacar(Pieza objetivo) {
        objetivo.atacadaDesde(this.casillero, this.arma);
    }

    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        this.arma = new ArmaCatapulta(danio,danioADistancia);
    }

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {

    }

}

