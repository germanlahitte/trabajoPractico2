package modelo.ubicacion;

import modelo.equipos.EquipoAzul;
import modelo.equipos.Equipo;
import modelo.equipos.EquipoRojo;
import modelo.ProveedorConstantes;
import modelo.piezas.Alambrado;
import modelo.piezas.Movible;
import modelo.piezas.Pieza;

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
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoRojo,this);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }

        for (int vertical = (lado / 2) + 1; vertical <= lado; vertical++) {
            for (int horizontal = 1; horizontal <= lado; horizontal++) {
                Posicion nuevaPosicion = new Posicion(horizontal, vertical);
                Casillero nuevoCasillero = new Casillero(nuevaPosicion, bandoAzul,this);
                posiciones.put(nuevaPosicion, nuevoCasillero);
            }
        }

        this.limitar();

    }

    private void limitar() {
        for (int horizontal = 0; horizontal <= lado+1; horizontal++){
            Posicion nuevoLimiteSur = new Posicion(horizontal,0);
            Casillero casilleroLimiteSur = new Casillero(nuevoLimiteSur,bandoRojo,this);
            posiciones.put(nuevoLimiteSur,casilleroLimiteSur);
            new Alambrado(casilleroLimiteSur,bandoRojo);

            Posicion nuevoLimiteNorte = new Posicion(horizontal,21);
            Casillero casilleroLimiteNorte = new Casillero(nuevoLimiteNorte,bandoRojo,this);
            posiciones.put(nuevoLimiteNorte,casilleroLimiteNorte);
            new Alambrado(casilleroLimiteNorte,bandoRojo);
        }
        for (int vertical = 1; vertical <= lado; vertical++){
            Posicion nuevoLimiteOeste = new Posicion(0,vertical);
            Casillero casilleroLimiteOeste = new Casillero(nuevoLimiteOeste,bandoAzul,this);
            posiciones.put(nuevoLimiteOeste,casilleroLimiteOeste);
            new Alambrado(casilleroLimiteOeste,bandoAzul);

            Posicion nuevoLimiteEste = new Posicion(21,vertical);
            Casillero casilleroLimiteEste = new Casillero(nuevoLimiteEste,bandoAzul,this);
            posiciones.put(nuevoLimiteEste,casilleroLimiteEste);
            new Alambrado(casilleroLimiteEste,bandoAzul);
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
        posiciones.forEach((posicion,casillero) -> casillero.noQuemado());
        this.limitar();
    }

    public int getLado() {
        return lado;
    }
}