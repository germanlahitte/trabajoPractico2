package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {
    @Test
    public void catapultaAtacaADistanciaCercanaASoldadoYNoSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Equipo bando1 = new Rojo();
        Equipo bando2 = new Azul();
        Catapulta catapulta = new Catapulta(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(catapulta);
        casillero2.ubicar(soldado);
        catapulta.atacar(soldado);
        assertEquals(100,soldado.vidaRestante());
    }

    @Test
    public void catapultaAtacaADistanciaLejanaASoldadoYSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(8,2);
        Equipo bando1 = new Rojo();
        Equipo bando2 = new Azul();
        Catapulta catapulta = new Catapulta(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(catapulta);
        casillero2.ubicar(soldado);
        catapulta.atacar(soldado);
        assertEquals(80,soldado.vidaRestante());

    }

}