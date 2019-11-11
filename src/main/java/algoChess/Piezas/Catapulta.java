package algoChess.Piezas;

import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;

public class Catapulta extends Pieza {
    private static int costo = 5;
    private static int vida = 50;

    public Catapulta(Equipo equipo) {
        super(vida, equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    public static int getCosto() { return costo; }


    @Override
    public void curarse(float vida){

    }
}

