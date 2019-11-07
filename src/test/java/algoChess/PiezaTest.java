package algoChess;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCurandero;
import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Azul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Movible;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
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

        Posicion p3 = new Posicion(1,19);
        Casillero casillero3 = new Casillero(p3,e2);
        soldado1.asignarCasillero(casillero3);


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

        Posicion p3 = new Posicion(1,19);
        Casillero casillero3 = new Casillero(p3,e2);
        soldado1.asignarCasillero(casillero3);

        casillero1.ubicar(soldado1);
        assertEquals(3,soldado1.distanciaA(casillero2));
    }
    @Test
    public void quitarVidaTest(){
        Equipo e1 = new Rojo();
        Posicion p1 = new Posicion(1,1);
        Casillero casillero1 = new Casillero(p1,e1);
        Soldado soldado1 = new Soldado(e1);

        Posicion p3 = new Posicion(1,19);
        Casillero casillero3 = new Casillero(p3,e1);
        soldado1.asignarCasillero(casillero3);

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

        Posicion p3 = new Posicion(1,19);
        Casillero casillero3 = new Casillero(p3,e2);
        soldado1.asignarCasillero(casillero3);

        casillero1.ubicar(soldado1);
        soldado1.curadaDesde(casillero2,armaCurandero);
        assertEquals(115,soldado1.vidaRestante());

    }





// Mover
    @Test
    public void testMovibleSeMueveEnDireccionNorte(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,6);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.norte());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testMovibleSeMueveEnDireccionSur(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,4);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.sur());

        assertEquals(p2,soldado.posicion());

    }
    @Test
    public void testMovibleSeMueveEnDireccionEste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,5);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.este());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testMovibleSeMueveEnDireccionOeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,5);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.oeste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testMovibleSeMueveEnDireccionNoreste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,6);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.norEste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testMovibleSeMueveEnDireccionNoroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,6);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.norOeste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testMovibleSeMueveEnDireccionSureste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,4);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.surEste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testMovibleSeMueveEnDireccionSuroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new Azul()) ;

        soldado.asignarCasillero(casillero);

        soldado.mover(Direccion.surOeste());

        assertEquals(p2,soldado.posicion());

    }

}