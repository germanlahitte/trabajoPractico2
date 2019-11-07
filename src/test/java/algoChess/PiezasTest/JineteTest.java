package algoChess.PiezasTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Jinete;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {


    /*@Test
    public void jineteAtacaADistanciaLejanaYSeLeRestaLaVidaCorrespondienteTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(7,7);
        Equipo bando1 = new EquipoRojo();
        Equipo bando2 = new EquipoAzul();
        Jinete jinete = new Jinete(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(jinete);
        casillero2.ubicar(soldado);
        jinete.atacar(soldado);
        assertEquals(85,soldado.vida());

    }*/

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
