package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {
    @Test
    public void testUbicarUbicaCorrectamente(){
        Equipo equipo = new Rojo();
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,equipo);
        Pieza soldado = new Soldado(equipo);
        casillero.ubicar(soldado);
        Disponibilidad ocupado;

    }

}