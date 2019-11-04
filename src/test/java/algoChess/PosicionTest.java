package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosicionTest {

    @Test
    public void distanciaATest (){
        Posicion posicion11 = new Posicion(1,1);
        Posicion posicion17 = new Posicion(1,7);
        Posicion posicion23 = new Posicion(2,3);
        Posicion posicion45 = new Posicion(4,5);

        assertEquals(posicion11.distanciaA(posicion17),6);
        assertEquals(posicion11.distanciaA(posicion11),0);
        assertEquals(posicion11.distanciaA(posicion23),2);
        assertEquals(posicion11.distanciaA(posicion45),4);
        assertEquals(posicion17.distanciaA(posicion11),6);
        assertEquals(posicion23.distanciaA(posicion45),2);
        assertEquals(posicion45.distanciaA(posicion17),3);
        assertEquals(posicion23.distanciaA(posicion17),4);
    }

}