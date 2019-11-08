package algoChess.Piezas;

import algoChess.Armas.ArmaArcoJinete;
import algoChess.Armas.ArmaEspadaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;

public class Jinete extends Pieza implements Movible{
    private static int costo = 3;

    public Jinete(Equipo equipo) {
        super(100, equipo);
        this.agregarArma(new ArmaArcoJinete());
    }

    public static int getCosto() { return costo; }

    // Cambiar arma
    public void equiparArco(){
        this.agregarArma(new ArmaArcoJinete());
    }
    public void equiparEspada(){
        this.agregarArma(new ArmaEspadaJinete());
    }

    public void mover(Direccion direccion){
        this.casillero.siguiente(direccion).agregarPieza(this);
    }
}
