package algoChess;

import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PosicionTest {


    @Test
    public void testPosicionSeCreaConPosicionCorrectaEnXDesdeConstructor() {
        Posicion posicion1 = new Posicion(1, 6);
        assertEquals(posicion1.getHorizontal(), 1);
    }

    @Test
    public void testPosicionSeCreaConPosicionCorrectaEnYDesdeConstructor() {
        Posicion posicion1 = new Posicion(1, 6);
        assertEquals(posicion1.getVertical(), 6);
    }

    @Test
    public void testPosicionADevuelveDistanciaCorrectaAPosicionBCorridoSoloEnPosicionY() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 7);
        assertEquals(posicion1.distanciaA(posicion2), 6);
    }

    @Test
    public void testPosicionADevuelveDistanciaCorrectaAPosicionBCorridoSoloEnPosicionX() {
        Posicion posicion1 = new Posicion(7, 1);
        Posicion posicion2 = new Posicion(1, 1);
        assertEquals(posicion1.distanciaA(posicion2), 6);
    }

    @Test
    public void testPosicionADevuelveDistanciaCorrectaAPosicionBCorridoEnAmbasPosiciones() {
        Posicion posicion1 = new Posicion(4, 1);
        Posicion posicion2 = new Posicion(2, 8);
        assertEquals(posicion1.distanciaA(posicion2), 7);
    }

    @Test
    public void testPosicionADevuelveMismaDistanciaAPosicionBQuePosicionBDistanciaAPosicionA() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 7);
        assertEquals(posicion2.distanciaA(posicion1), posicion1.distanciaA(posicion2));
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionCorrecta() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 7);
        assertEquals(posicion2.distanciaA(posicion1), posicion1.distanciaA(posicion2));
    }



}