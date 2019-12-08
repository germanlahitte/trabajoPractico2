package modelo.piezas;

import excepciones.CatapultaNoPuedeCurarse;
import modelo.armas.ArmaCatapulta;
import modelo.equipos.Equipo;
import modelo.ProveedorConstantes;

public class Catapulta extends Pieza {

    public Catapulta(Equipo equipo) {
        super(ProveedorConstantes.vidaCatapulta(), equipo);
        this.agregarArma(new ArmaCatapulta());
    }

    @Override
    public String getNombre() {
        return "catapulta";
    }

    @Override
    public void curarse(float vida){
        throw new CatapultaNoPuedeCurarse();
    }

}

