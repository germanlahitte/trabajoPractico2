package algoChess.Piezas;

import algoChess.Armas.ArmaArcoJinete;
import algoChess.Armas.ArmaEspadaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Direccion;

public class Jinete extends Pieza implements Movible{

    public Jinete(Equipo equipo) {
        super(3, 100, equipo);
        this.agregarArma(new ArmaArcoJinete());
    }

    // Cambiar arma
    public void equiparArco(){
        this.agregarArma(new ArmaArcoJinete());
    }
    public void equiparEspada(){
        this.agregarArma(new ArmaEspadaJinete());
    }

    // Se mueve en X direccion
    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
