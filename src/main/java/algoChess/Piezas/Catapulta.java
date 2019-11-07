package algoChess.Piezas;

import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;

public class Catapulta extends Pieza {

    public Catapulta(Equipo equipo) {
        super(5, 50, equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    @Override
    public void curarse(float vida){    }
}

