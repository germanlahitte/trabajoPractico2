package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;

public class Jinete extends Pieza implements Movible{

    public Jinete(Equipo equipo) {
        super(3, 100, equipo);
        this.agregarArma(5,15);
    }

    @Override
    public void atacar(Pieza objetivo) {
        objetivo.atacadaDesde(this.casillero, this.arma);
    }

    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        this.arma = new ArmaJinete(danio,danioADistancia);

    }

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {
        this.curadaDesde(ubicacion,arma);
    }


    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
