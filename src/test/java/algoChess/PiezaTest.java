package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiezaTest {
    @Test
    public void soldadoAliadoAtacaAPiezaEnemigaYseVerificaQueSeLeRestaVida(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Equipo bando1 = new Rojo();
        Equipo bando2 = new Azul();
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        Soldado soldado = new Soldado(bando1);
        Jinete jinete = new Jinete(bando2);
        casillero1.ubicar(soldado);
        casillero2.ubicar(jinete);
        soldado.atacar(jinete);
        assertEquals(90,jinete.vidaRestante());
    }

}