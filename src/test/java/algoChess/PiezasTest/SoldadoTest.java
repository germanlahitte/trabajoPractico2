package algoChess.PiezasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaArcoJinete;
import algoChess.Armas.ArmaSoldado;
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

public class SoldadoTest {

    /*
    @Test
    public void soldadoAliadoAtacaAJineteEnemigoADistanciaCercanaYSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Equipo bando1 = new EquipoRojo();
        Equipo bando2 = new EquipoAzul();
        Jinete jinete = new Jinete(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(jinete);
        casillero2.ubicar(soldado);
        soldado.atacar(jinete);
        assertEquals(90,jinete.vida());
    }

    @Test
    public void soldadoAliadoAtacaJineteADistanciaLejanaYNoSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(5,5);
        Equipo bando1 = new EquipoRojo();
        Equipo bando2 = new EquipoAzul();
        Jinete jinete = new Jinete(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(jinete);
        casillero2.ubicar(soldado);
        soldado.atacar(jinete);
        assertEquals(100,jinete.vida());
    }*/


    @Test
    public void testSoldadoSeCreaConVidaCorrecta() {

        Pieza pieza = new Soldado(new EquipoAzul());
        assertEquals(100, pieza.vida());
    }

    @Test
    public void testSoldadoHace10DeDañoAOtraPiezaEnRango() {

        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoAzul());
        Pieza pieza2 = new Soldado(new EquipoRojo());

        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);

        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);


        pieza.atacar(pieza2);
        assertEquals(90,pieza2.vida());
    }



}
