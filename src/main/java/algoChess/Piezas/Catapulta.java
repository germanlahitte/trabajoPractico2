package algoChess.Piezas;

import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;
import algoChess.FactoryConstantes;

public class Catapulta extends Pieza {
    private static int costo = 5;

    public Catapulta(Equipo equipo) {
        super(FactoryConstantes.vidaCatapulta(), equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    public static int getCosto() { return costo; }


    @Override
    public void curarse(float vida){

    }
}

