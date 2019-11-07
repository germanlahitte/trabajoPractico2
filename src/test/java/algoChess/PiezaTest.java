package algoChess;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCurandero;
import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Azul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PiezaTest {
    @Test
    public void atacadaDesdeTest(){
        Equipo e1 = new Rojo();
        Equipo e2 = new Azul();
        Posicion p1 = new Posicion(1,1);
        Posicion p2 = new Posicion(1,2);
        Casillero casillero1 = new Casillero(p1,e1);
        Casillero casillero2 = new Casillero(p2,e2);
        Soldado soldado1 = new Soldado(e1);
        Arma armaJinete = new ArmaJinete(5,15);
        casillero1.ubicar(soldado1);
        soldado1.atacadaDesde(casillero2,armaJinete);
        assertEquals(95,soldado1.vidaRestante());
    }

    @Test
    public void distanciaATest(){
        Equipo e1 = new Rojo();
        Equipo e2 = new Azul();
        Posicion p1 = new Posicion(1,1);
        Posicion p2 = new Posicion(3,4);
        Casillero casillero1 = new Casillero(p1,e1);
        Casillero casillero2 = new Casillero(p2,e2);
        Soldado soldado1 = new Soldado(e1);
        casillero1.ubicar(soldado1);
        assertEquals(3,soldado1.distanciaA(casillero2));
    }
    @Test
    public void quitarVidaTest(){
        Equipo e1 = new Rojo();
        Posicion p1 = new Posicion(1,1);
        Casillero casillero1 = new Casillero(p1,e1);
        Soldado soldado1 = new Soldado(e1);
        casillero1.ubicar(soldado1);
        soldado1.quitarVida(30);
        assertEquals(70,soldado1.vidaRestante());
    }
    @Test
    public void hacerseDanioTest(){
        Equipo e1 = new Rojo();
        Soldado soldado1 = new Soldado(e1);
        soldado1.hacerseDanio(40);
        assertEquals(60,soldado1.vidaRestante());
    }

    @Test
    public void ubicarDevuelveTrueCuandoPiezaYCasilleroSonDelMismoEquipoTest(){
        Equipo e1 = new Rojo();
        Soldado soldado1 = new Soldado(e1);
        assertTrue(soldado1.ubicar(e1));
    }

    @Test
    public void ubicarDevuelveFalseCuandoPiezaYCasilleroSonDeDiferenteEquipoTest(){
        Equipo e1 = new Rojo();
        Equipo e2 = new Azul();
        Soldado soldado1 = new Soldado(e1);
        assertFalse(soldado1.ubicar(e2));
    }

    @Test
    public void curadaDesdeTest(){
        Equipo e1 = new Rojo();
        Equipo e2 = new Azul();
        Posicion p1 = new Posicion(1,1);
        Posicion p2 = new Posicion(1,2);
        Casillero casillero1 = new Casillero(p1,e1);
        Casillero casillero2 = new Casillero(p2,e2);
        Soldado soldado1 = new Soldado(e1);
        Arma armaCurandero = new ArmaCurandero(15,0);
        casillero1.ubicar(soldado1);
        soldado1.curadaDesde(casillero2,armaCurandero);
        assertEquals(115,soldado1.vidaRestante());

    }


}