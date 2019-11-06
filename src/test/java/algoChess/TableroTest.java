package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
    @Test
    public void seCreaCorrectamenteElTableroTest(){
        Tablero tablero = new Tablero();
        assertEquals(400,tablero.getCantidadDeCasilleros());
    }
    
    @Test
    public void seColocaUnaPiezaAliadaEnUnCasilleroAliadoVacioConExitoTest(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new Rojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (1,3);
        Casillero unCasillero = tablero.buscar(unaPosicion);

        tablero.ubicar(piezaPrueba,unCasillero);

        assertEquals(piezaPrueba.distanciaA(unCasillero),0);
    }
}