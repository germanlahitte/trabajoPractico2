package algochess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
     void testGetNumero() {
        Main prueba = new Main();
        assertEquals(prueba.getNumero(),0);
    }

}