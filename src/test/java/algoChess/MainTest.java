package algoChess;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public mainTestBasico() {
        Main prueba = new Main();
        assertEquals(prueba.getNumero(),0);
    }

}