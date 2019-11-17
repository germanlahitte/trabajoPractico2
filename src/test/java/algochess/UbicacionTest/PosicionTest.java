package algochess.UbicacionTest;

import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;
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
    public void testPosicionADevuelveSiguientePosicionEnDireccionNorteCorrecta() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = posicion1.siguiente(Direccion.norte());
        Posicion posicion3 = new Posicion(1, 2);
        assertEquals(posicion2, posicion3);
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionSurCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.sur());
        Posicion posicion3 = new Posicion(3, 2);
        assertEquals(posicion2, posicion3);
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionEsteCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.este());
        Posicion posicion3 = new Posicion(4, 3);
        assertEquals(posicion2, posicion3);
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionOesteCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.oeste());
        Posicion posicion3 = new Posicion(2, 3);
        assertEquals(posicion2, posicion3);
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionNoresteCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.norEste());
        Posicion posicion3 = new Posicion(4, 4);
        assertEquals(posicion2, posicion3);
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionNoroesteCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.norOeste());
        Posicion posicion3 = new Posicion(2, 4);
        assertEquals(posicion2, posicion3);
    }


    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionSuresteCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.surEste());
        Posicion posicion3 = new Posicion(4, 2);
        assertEquals(posicion2, posicion3);
    }

    @Test
    public void testPosicionADevuelveSiguientePosicionEnDireccionSuroesteCorrecta() {
        Posicion posicion1 = new Posicion(3, 3);
        Posicion posicion2 = posicion1.siguiente(Direccion.surOeste());
        Posicion posicion3 = new Posicion(2, 2);
        assertEquals(posicion2, posicion3);
    }
}