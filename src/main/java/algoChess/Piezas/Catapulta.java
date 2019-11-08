package algoChess.Piezas;

import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;

public class Catapulta extends Pieza {
    private static int costo = 5;

    public Catapulta(Equipo equipo) {
        super(50, equipo);
        this.agregarArma(new ArmaCatapulta());
    }


    @Override
    public void curarse(float vida){

    }
}

