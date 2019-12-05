package modelo.piezas;

import modelo.armas.ArmaCurandero;
import modelo.equipos.Equipo;
import modelo.ProveedorConstantes;
import modelo.ubicacion.Direccion;

public class Curandero extends Pieza implements Movible {

    public Curandero(Equipo equipo) {
        super(ProveedorConstantes.vidaCurandero(), equipo);
        this.agregarArma(new ArmaCurandero());
    }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    @Override
    public String getNombre() {
        return "curandero";
    }

    public void atacar(Pieza pieza){
        if(pieza.soyAliado(this.equipo))
            pieza.atacadaDesde(this.casillero,this.arma);
    }
}

