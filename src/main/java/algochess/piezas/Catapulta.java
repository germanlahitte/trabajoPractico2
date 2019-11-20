package algochess.piezas;

import algochess.armas.ArmaCatapulta;
import algochess.equipos.Equipo;
import algochess.ProveedorConstantes;

public class Catapulta extends Pieza {

    public Catapulta(Equipo equipo) {
        super(ProveedorConstantes.vidaCatapulta(), equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    @Override
    public void curarse(float vida){ }

}

