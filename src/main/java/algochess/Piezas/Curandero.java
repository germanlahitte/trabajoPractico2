package algochess.Piezas;

import algochess.Armas.ArmaCurandero;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Direccion;

public class Curandero extends Pieza implements Movible {
    private static int costo = 2;
    public Curandero(Equipo equipo) {
        super(FactoryConstantes.vidaCurandero(), equipo);
        this.agregarArma(new ArmaCurandero());
    }

    public static int getCosto() { return costo; }


    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    public void atacar(Pieza pieza){
        if(pieza.soyAliado(this.equipo))
            pieza.atacadaDesde(this.casillero,this.arma);
    }
}

