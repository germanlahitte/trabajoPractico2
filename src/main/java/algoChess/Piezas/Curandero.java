package algoChess.Piezas;

import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;

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

    private void puedeCurar(Pieza objetivo){
        if(objetivo.getBando() == this.equipo && objetivo.getClass()!=Catapulta.class){
            objetivo.curadaDesde(this.ubicacion,this.arma);
        }

    }

}

