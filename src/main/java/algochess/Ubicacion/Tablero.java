package algochess.Ubicacion;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.Equipo;
import algochess.Equipos.EquipoRojo;
import algochess.FactoryConstantes;
import algochess.Piezas.Movible;
import algochess.Piezas.Pieza;

import java.util.HashMap;

public class Tablero {

    private static int lado = FactoryConstantes.ladoDelTablero();
    private static int desplazamientoMaximo = FactoryConstantes.desplazamientoMaximo();
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