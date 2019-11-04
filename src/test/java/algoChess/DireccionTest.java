package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DireccionTest {
    Posicion posicion11 = new Posicion(1,1);
    Posicion posicion12 = new Posicion(1,2);
    Posicion posicion23 = new Posicion(2,3);
    Posicion posicion33 = new Posicion(3,3);

       @Test
    void proximaPosicionTest() {
        Posicion nueva = Direccion.norte().proximaPosicion(posicion11);
        assertEquals(nueva.distanciaA(posicion12),0);

        nueva = Direccion.sur().proximaPosicion(posicion12);
        assertEquals(nueva.distanciaA(posicion11),0);

        nueva = Direccion.este().proximaPosicion(posicion23);
        assertEquals(nueva.distanciaA(posicion33),0);

        nueva = Direccion.oeste().proximaPosicion(posicion33);
        assertEquals(nueva.distanciaA(posicion23),0);

        nueva = Direccion.norEste().proximaPosicion(posicion11);
        assertEquals(nueva.getHorizontal(),2);
        assertEquals(nueva.getVertical(),2);

        nueva = Direccion.surOeste().proximaPosicion(posicion11);
        assertEquals(nueva.getHorizontal(),0);
        assertEquals(nueva.getVertical(),0);



    }
}