package algoChess;

import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.StrategyDisponibilidad.StrategyDisponibilidad;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasilleroTest {


/*
    @Test
    public void testUbicarUbicaCorrectamente(){
        Equipo equipo = new Rojo();
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,equipo);
        Pieza soldado = new Soldado(equipo);
        casillero.ubicar(soldado);
        StrategyDisponibilidad ocupado;

    }*/


    @Test
    public void testCasilleroDevuelveDistanciaAPosicionCorrectaEnX(){
        Equipo equipo = new Rojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(4,1);
        Casillero casillero = new Casillero(posicion1,equipo);

        assertEquals(casillero.distanciaA(posicion2),3);

    }

    @Test
    public void testCasilleroDevuelveDistanciaAPosicionCorrectaEnY(){
        Equipo equipo = new Rojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,4);
        Casillero casillero = new Casillero(posicion1,equipo);

        assertEquals(casillero.distanciaA(posicion2),3);

    }

    @Test
    public void testCasilleroDevuelveDistanciaAPosicionCorrectaEnAmbasDirecciones(){
        Equipo equipo = new Rojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,6);
        Casillero casillero = new Casillero(posicion1,equipo);

        assertEquals(casillero.distanciaA(posicion2),5);

    }
    @Test
    public void testCasilleroDevuelveDistanciaACasilleroCorrectaEnY(){
        Equipo equipo = new Rojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,6);
        Casillero casillero = new Casillero(posicion1,equipo);
        Casillero casillero2 = new Casillero(posicion2,equipo);
        assertEquals(casillero.distanciaA(casillero2),5);

    }

    @Test
    public void testCasilleroDevuelveDistanciaACasilleroCorrectaEnX(){
        Equipo equipo = new Rojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,1);
        Casillero casillero = new Casillero(posicion1,equipo);
        Casillero casillero2 = new Casillero(posicion2,equipo);
        assertEquals(casillero.distanciaA(casillero2),5);

    }


    @Test
    public void testCasilleroDevuelveDistanciaACasilleroCorrectaEnAmbasDirecciones(){
        Equipo equipo = new Rojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,8);
        Casillero casillero = new Casillero(posicion1,equipo);
        Casillero casillero2 = new Casillero(posicion2,equipo);
        assertEquals(casillero.distanciaA(casillero2),7);

    }


}