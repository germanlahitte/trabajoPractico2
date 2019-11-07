package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;

public class Curandero extends Pieza {
    public Curandero(Equipo equipo) {
        super(2, 75, equipo);
        this.agregarArma(15,0);
    }

    @Override
    public void atacar(Pieza objetivo) {
        this.puedeCurar(objetivo);
    }

    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        this.arma = new ArmaCurandero(danio,danioADistancia);

    }

    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {
    this.curadaDesde(ubicacion,arma);
    }

    private void puedeCurar(Pieza objetivo){
        objetivo.puedoCurarme(this.ubicacion,this.arma);
    }

}

