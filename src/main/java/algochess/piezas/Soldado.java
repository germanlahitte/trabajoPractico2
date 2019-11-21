package algochess.piezas;

import algochess.armas.ArmaSoldado;
import algochess.equipos.Equipo;
import algochess.ProveedorConstantes;
import algochess.ubicacion.Direccion;

public class Soldado extends Pieza implements Movible{

    private Batallon batallon;

    public Soldado(Equipo equipo) {

        super(ProveedorConstantes.vidaSoldado(), equipo);
        this.agregarArma(new ArmaSoldado());
        this.batallon = new Batallon(this);
    }

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

    void mover(Direccion enDireccion, Batallon enBatallon) {
        this.casillero.siguiente(enDireccion).agregarPieza(this, enBatallon,enDireccion);
    }

    public void escoltar(Jinete unJinete){ unJinete.equiparArco(); }
}
