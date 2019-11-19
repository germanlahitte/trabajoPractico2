package algochess.Piezas;

import algochess.Armas.ArmaSoldado;
import algochess.Equipos.Equipo;
import algochess.FactoryConstantes;
import algochess.Ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{
    private static int costo = 1;
    private Batallon batallon;

    public Soldado(Equipo equipo) {

        super(FactoryConstantes.vidaSoldado(), equipo);
        this.agregarArma(new ArmaSoldado());
        this.batallon = new Batallon(this);
    }

    public static int getCosto() { return costo; }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }

    public void crearBatallon() {
        this.batallon = new Batallon(this);
    }

    public void enlistarse(Equipo equipoDelSoldado, Soldado capitan){
       equipoDelSoldado.enlistarse(this.equipo,capitan,this);
    }
    
    public void enlistar(Soldado soldado) {
        this.batallon.enlistar(soldado);
    }

    public void mover(Direccion direccion, Batallon batallon) {
        this.casillero.siguiente(direccion).agregarPieza(this, batallon,direccion);
    }

    public void escoltar(Jinete unJinete){ unJinete.equiparArco(); }
}
