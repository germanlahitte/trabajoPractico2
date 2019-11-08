package algoChess.Ubicacion;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Movible;
import algoChess.Piezas.Pieza;

import excepciones.ElJuegoTerminoPorqueHayUnGanadorException;

import java.util.HashMap;

public class Tablero {

    private static int lado = 20;
    private static int movimientoMaximo = 1;
    private HashMap<Posicion, Casillero> posiciones;

    public Tablero() {
        this.posiciones = new HashMap<Posicion, Casillero>();

        for (int vertical = 1; vertical <= (lado / 2); vertical++) {
            Equipo bandoRojo = new EquipoRojo();
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoRojo );
                nuevoCasillero.agregarTablero(this);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }

        for (int vertical = (lado / 2) + 1; vertical <= lado; vertical++) {
            Equipo bandoAzul = new EquipoAzul();
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoAzul);
                nuevoCasillero.agregarTablero(this);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }
    }


   // Ubicar piezas
    public void ubicar(Pieza estaPieza, Posicion posicion) {
        this.casilleroEn(posicion).ubicar(estaPieza);
    }

    // Metodo para buscar casilleros
    public Casillero casilleroEn(Posicion enPosicion){
        return posiciones.get(enPosicion);
    }

   // Metodo que le pasa movible a tablero para que se mueva
    public void mover(Movible movible, Direccion direccion) {
        movible.mover(direccion);
        }
}