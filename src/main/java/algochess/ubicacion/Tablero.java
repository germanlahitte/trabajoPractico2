package algochess.ubicacion;

import algochess.equipos.EquipoAzul;
import algochess.equipos.Equipo;
import algochess.equipos.EquipoRojo;
import algochess.ProveedorConstantes;
import algochess.piezas.Alambrado;
import algochess.piezas.Movible;
import algochess.piezas.Pieza;

import java.util.HashMap;

public class Tablero {

    private static int lado = ProveedorConstantes.ladoDelTablero();
    private HashMap<Posicion, Casillero> posiciones;
    private Equipo bandoRojo = new EquipoRojo();
    private Equipo bandoAzul = new EquipoAzul();

    public Tablero() {
        this.posiciones = new HashMap<>();

        for (int vertical = 1; vertical <= (lado / 2); vertical++) {
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoRojo );
                nuevoCasillero.agregarTablero(this);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }

        for (int vertical = (lado / 2) + 1; vertical <= lado; vertical++) {
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoAzul);
                nuevoCasillero.agregarTablero(this);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }

        this.limitar();

    }

    private void limitar() {
        for (int horizontal = 0; horizontal <= lado; horizontal++){
            Posicion nuevoLimiteSur = new Posicion(horizontal,0);
            Casillero casilleroLimiteSur = new Casillero(nuevoLimiteSur,bandoRojo);
            casilleroLimiteSur.agregarTablero(this);
            posiciones.put(nuevoLimiteSur,casilleroLimiteSur);
            casilleroLimiteSur.asignarPieza(new Alambrado(casilleroLimiteSur,bandoRojo));

            Posicion nuevoLimiteNorte = new Posicion(horizontal,21);
            Casillero casilleroLimiteNorte = new Casillero(nuevoLimiteNorte,bandoRojo);
            casilleroLimiteNorte.agregarTablero(this);
            posiciones.put(nuevoLimiteNorte,casilleroLimiteNorte);
            casilleroLimiteNorte.asignarPieza(new Alambrado(casilleroLimiteNorte,bandoRojo));
        }
        for (int vertical = 1; vertical <= lado; vertical++){
            Posicion nuevoLimiteOeste = new Posicion(0,vertical);
            Casillero casilleroLimiteOeste = new Casillero(nuevoLimiteOeste,bandoAzul);
            casilleroLimiteOeste.agregarTablero(this);
            posiciones.put(nuevoLimiteOeste,casilleroLimiteOeste);
            casilleroLimiteOeste.asignarPieza(new Alambrado(casilleroLimiteOeste,bandoAzul));

            Posicion nuevoLimiteEste = new Posicion(21,vertical);
            Casillero casilleroLimiteEste = new Casillero(nuevoLimiteEste,bandoAzul);
            casilleroLimiteEste.agregarTablero(this);
            posiciones.put(nuevoLimiteEste,casilleroLimiteEste);
            casilleroLimiteEste.asignarPieza(new Alambrado(casilleroLimiteEste,bandoAzul));
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

    void altoElFuego() {
        posiciones.forEach((k,v) -> v.noQuemado());
        this.limitar();
    }
}