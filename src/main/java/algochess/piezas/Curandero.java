package algochess.piezas;

import algochess.armas.ArmaCurandero;
import algochess.equipos.Equipo;
import algochess.ProveedorConstantes;
import algochess.ubicacion.Direccion;

public class Curandero extends Pieza implements Movible {

    public Curandero(Equipo equipo) {
        super(ProveedorConstantes.vidaCurandero(), equipo);
        this.agregarArma(new ArmaCurandero());
    }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    public void atacar(Pieza pieza){
        if(pieza.soyAliado(this.equipo))
            pieza.atacadaDesde(this.casillero,this.arma);
    }
}

