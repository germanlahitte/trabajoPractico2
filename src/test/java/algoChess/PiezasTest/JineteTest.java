package algoChess.PiezasTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Jinete;
import algoChess.Piezas.Pieza;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {

    @Test
    public void testJineteSeCreaConVidaCorrecta() {
        Pieza pieza = new Jinete(new EquipoAzul());
        assertEquals(100, pieza.vida());
    }

    @Test
    public void testJineteHace15DeDañoAOtraPiezaEnRangoConArco() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,4);
        Pieza pieza = new Jinete(new EquipoAzul());
        Pieza pieza2 = new Jinete(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);

        pieza.atacar(pieza2);
        assertEquals(85,pieza2.vida());
    }

    @Test
    public void testJineteHace5DeDañoAOtraPiezaEnRangoConEspada() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Jinete pieza = new Jinete(new EquipoAzul());
        Pieza pieza2 = new Jinete(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);
        pieza.equiparEspada();

        pieza.atacar(pieza2);
        assertEquals(95,pieza2.vida());
    }
}
