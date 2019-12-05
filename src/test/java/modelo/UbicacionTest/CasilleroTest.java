package modelo.UbicacionTest;

import modelo.equipos.EquipoAzul;
import modelo.equipos.Equipo;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Casillero;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import excepciones.CasilleroEnemigoException;
import excepciones.CasilleroOcupadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasilleroTest {

    private Tablero tablero;

    @BeforeEach
    void iniciar(){
        tablero = new Tablero();
    }
    // Ubicar pieza en casillero (al iniciar, medio mapa azul y medio rojo)
    @Test
     void testCasilleroUbicaPiezaSiEstaVacioYSiEsDelMismoColor(){
        Pieza pieza = new Soldado(new EquipoRojo());
        pieza.asignarCasillero(new Casillero(new Posicion(3,3), new EquipoAzul(),tablero));
        Casillero casillero = tablero.casilleroEn(new Posicion(1,1)); // Casillero rojo
        casillero.ubicar(pieza);

        assertEquals(pieza.getPosicion(),casillero.getPosicion());
    }

    @Test
     void testCasilleroNoUbicaPiezaSiEsDeDiferenteColor(){

        Pieza pieza = new Soldado(new EquipoAzul());
        pieza.asignarCasillero(new Casillero(new Posicion(11,11), new EquipoAzul(),tablero));
        Casillero casillero = tablero.casilleroEn(new Posicion(1,1)); // Casillero rojo

        assertThrows(CasilleroEnemigoException.class, ()-> casillero.ubicar(pieza));
    }

    @Test
     void testCasilleroNoUbicaPiezaSiEsDelMismoColorPeroEstaOcupado(){

        Pieza pieza = new Soldado(new EquipoRojo());
        Pieza pieza2 = new Soldado(new EquipoRojo());
        pieza.asignarCasillero(new Casillero(new Posicion(11,11), new EquipoAzul(),tablero));
        pieza2.asignarCasillero(new Casillero(new Posicion(12,12), new EquipoAzul(),tablero));
        Casillero casillero = tablero.casilleroEn(new Posicion(1,1)); // Casillero rojo
        casillero.ubicar(pieza);

        assertThrows(CasilleroOcupadoException.class, ()-> casillero.ubicar(pieza2));
    }

    // Test en relacion a una posicion
    @Test
     void testCasilleroDevuelveDistanciaAPosicionCorrectaEnX(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(4,1);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        assertEquals(casillero.distanciaA(posicion2),3);
    }

    @Test
     void testCasilleroDevuelveDistanciaAPosicionCorrectaEnY(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,4);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        assertEquals(casillero.distanciaA(posicion2),3);
    }

    @Test
     void testCasilleroDevuelveDistanciaAPosicionCorrectaEnAmbasDirecciones(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,6);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        assertEquals(casillero.distanciaA(posicion2),5);
    }

    // Test en relacion a un casillero
    @Test
     void testCasilleroDevuelveDistanciaACasilleroCorrectaEnY(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,6);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);
        Casillero casillero2 = new Casillero(posicion2,equipo,tablero);

        assertEquals(casillero.distanciaA(casillero2),5);
    }

    @Test
     void testCasilleroDevuelveDistanciaACasilleroCorrectaEnX(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,1);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);
        Casillero casillero2 = new Casillero(posicion2,equipo,tablero);

        assertEquals(casillero.distanciaA(casillero2),5);
    }


    @Test
     void testCasilleroDevuelveDistanciaACasilleroCorrectaEnAmbasDirecciones(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(6,8);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);
        Casillero casillero2 = new Casillero(posicion2,equipo,tablero);

        assertEquals(casillero.distanciaA(casillero2),7);
    }

    // Test casillero devuelve casillero en direccion correcta
    @Test
     void testCasilleroDevuelveCasilleroEnDireccionNorte(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,11);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.norte());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionSur(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,9);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.sur());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionEste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(11,10);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.este());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionOeste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,10);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.oeste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionNoreste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(11,11);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.norEste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionNoroeste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,11);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.norOeste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionSurEste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(11,9);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.surEste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    @Test
     void testCasilleroDevuelveCasilleroEnDireccionSurOeste(){
        Equipo equipo = new EquipoRojo();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(9,9);
        Casillero casillero = new Casillero(posicion1,equipo,tablero);

        Casillero casillero2 = casillero.siguiente(Direccion.surOeste());
        assertEquals(casillero2.distanciaA(posicion2),0);
    }

    // Test casillero es ocupado por pieza
    @Test
     void testCasilleroLanzaExcepcionDeOcupadoSiSeQuiereAgregarOtraPieza(){

        Posicion posicionAzul = new Posicion(20,20);
        Casillero casilleroAzul = tablero.casilleroEn(posicionAzul);
        Pieza piezaAzul = new Soldado(new EquipoAzul()) ;
        Pieza piezaAzul2 = new Soldado(new EquipoAzul()) ;
        tablero.ubicar(piezaAzul,posicionAzul);

        assertThrows(CasilleroOcupadoException.class, ()-> casilleroAzul.agregarPieza(piezaAzul2));
    }


    @Test
     void testCasilleroSeDesocupaDePiezaYPuedeAgregarOtraSinProblemas(){

        Posicion posicionAzul = new Posicion(20,20);
        Casillero casilleroAzul = tablero.casilleroEn(posicionAzul);

        Pieza soldadoAzul = new Soldado(new EquipoAzul());
        tablero.ubicar(soldadoAzul,posicionAzul);
        casilleroAzul.desocupar();

        Pieza soldadoRojo = new Soldado(new EquipoRojo());

        assertDoesNotThrow(()-> casilleroAzul.agregarPieza(soldadoRojo));
        assertEquals(soldadoRojo,casilleroAzul.getPieza());
    }

    // Test casillero calcula daño a equipo
    @Test
     void testCasilleroDevuelveMultiplicadoDeDanioPorCincoAEquipoDiferente(){

        Posicion posicionRojo = new Posicion(3,3);
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Equipo azul = new EquipoAzul();

        assertEquals(1.05,casillero.calcularDanio(azul));
    }

    @Test
     void testCasilleroDevuelveMultiplicadoDeDanioPorUnoAMismoEquipo(){

        Posicion posicionRojo = new Posicion(3,3);
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Equipo rojo = new EquipoRojo();

        assertEquals(1.00,casillero.calcularDanio(rojo));
    }


}