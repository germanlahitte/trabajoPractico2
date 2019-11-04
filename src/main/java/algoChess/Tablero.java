package algoChess;

import java.util.HashMap;

public class Tablero {

    private static int lado = 20;
    private static int movimientoMaximo = 1;
    private HashMap posiciones;

    public Tablero() {
        this.posiciones = new HashMap();

        for (int vertical = 1; vertical <= (lado / 2); vertical++) {
            Equipo bandoRojo = new Rojo();
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoRojo);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }

        for (int vertical = (lado / 2) + 1; vertical <= lado; vertical++) {
            Equipo bandoAzul = new Azul();
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoAzul);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }
    }

    public void mover(Pieza estaPieza, Casillero destino) {
        if (estaPieza.distanciaA(destino) == movimientoMaximo) {
            estaPieza.mover(destino);
        }
    }

}