package algochess.Piezas;

import algochess.Armas.ArmaCatapulta;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;

public class Catapulta extends Pieza {
    private static int costo = 5;

    public Catapulta(Equipo equipo) {
        super(FactoryConstantes.vidaCatapulta(), equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    public static int getCosto() { return costo; }

    @Override
    public void curarse(float vida){ }

}

