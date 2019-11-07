package algoChess.Piezas;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;

public class Catapulta extends Pieza {

    public Catapulta(Equipo equipo) {
        super(5, 50, equipo);
        this.agregarArma(new ArmaCatapulta());
    }
    @Override
    public void atacar(Pieza objetivo) {
        //objetivo.atacadaDesde(this.casillero, this.arma);
    }

    /*
    @Override
    protected void agregarArma(int danio, int danioADistancia) {
        this.arma = new ArmaCatapulta();
    }
*/
    @Override
    public void puedoCurarme(Casillero ubicacion, Arma arma) {

    }

}

