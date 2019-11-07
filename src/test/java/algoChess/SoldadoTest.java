package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoldadoTest {
    @Test
    public void soldadoAliadoAtacaAJineteEnemigoADistanciaCercanaYSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Equipo bando1 = new Rojo();
        Equipo bando2 = new Azul();
        Jinete jinete = new Jinete(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(jinete);
        casillero2.ubicar(soldado);
        soldado.atacar(jinete);
        assertEquals(90,jinete.vidaRestante());
    }

    @Test
    public void soldadoAliadoAtacaJineteADistanciaLejanaYNoSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(5,5);
        Equipo bando1 = new Rojo();
        Equipo bando2 = new Azul();
        Jinete jinete = new Jinete(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(jinete);
        casillero2.ubicar(soldado);
        soldado.atacar(jinete);
        assertEquals(100,jinete.vidaRestante());
    }
}
