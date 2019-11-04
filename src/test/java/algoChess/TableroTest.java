package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    @Test
    public void seInicializaBienElTablero(){
        Tablero tablero = new Tablero();
        assertEquals(400,tablero.getCantidadDeCasilleros());
    }

}