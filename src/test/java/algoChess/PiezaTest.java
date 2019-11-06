package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiezaTest {
    @Test
    public void curanderoCuraSoldadoAliadoTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando);
        Casillero casillero1 = new Casillero(posicion1,bando);
        Casillero casillero2 = new Casillero(posicion2,bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        curandero.atacar(soldado);
        assertEquals(115,soldado.vidaRestante());
    }
    @Test
    public void curanderoNoCuraSoldadoAliadoPorEstarLejosTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(5,5);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando);
        Casillero casillero1 = new Casillero(posicion1,bando);
        Casillero casillero2 = new Casillero(posicion2,bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        curandero.atacar(soldado);
        assertEquals(100,soldado.vidaRestante());

    }
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

   @Test
    public void jineteAtacaADistanciaLejanaYSeLeRestaLaVidaCorrespondienteTest(){
       Posicion posicion1 = new Posicion(1,1);
       Posicion posicion2 = new Posicion(7,7);
       Equipo bando1 = new Rojo();
       Equipo bando2 = new Azul();
       Jinete jinete = new Jinete(bando1);
       Soldado soldado = new Soldado(bando2);
       Casillero casillero1 = new Casillero(posicion1,bando1);
       Casillero casillero2 = new Casillero(posicion2,bando2);
       casillero1.ubicar(jinete);
       casillero2.ubicar(soldado);
       jinete.atacar(soldado);
       assertEquals(85,soldado.vidaRestante());


   }

}