package modelo.PiezasTest;

import modelo.equipos.EquipoRojo;
import modelo.piezas.Batallon;
import modelo.piezas.Jinete;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatallonTest {
     private Soldado capitan;
     private Batallon batallon;
     private Soldado soldado;
     private Soldado soldado1;
     private Soldado soldado2;
     private Soldado soldado3;

    @BeforeEach
    void inicializacionDeSoldadosYBatallon(){
        this.capitan = new Soldado(new EquipoRojo());
        this.batallon = new Batallon(capitan);
        this.soldado = new Soldado(new EquipoRojo());
        batallon.enlistar(soldado);
        this.soldado1 = new Soldado(new EquipoRojo());
        this.soldado2 = new Soldado(new EquipoRojo());
        this.soldado3 = new Soldado(new EquipoRojo());

    }

    @Test
    void testCrearBatallon(){

        assertTrue(batallon.pertenece(capitan));
    }

    @Test
    void testEnlistar(){

        assertTrue(batallon.pertenece(soldado));
    }

    @Test
    void testMoverNoSeEjecutaSiElBatallonNoEsSuficientementeGrande() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        tablero.ubicar(capitan,posicion1);

        Posicion posicion2 = new Posicion(1,2);
        tablero.ubicar(soldado,posicion2);

        batallon.mover(Direccion.norte());

        assertEquals(posicion1,capitan.getPosicion());
        assertEquals(posicion2,soldado.getPosicion());
        assertFalse(batallon.pertenece(soldado));
    }

    @Test
    void testMoverNoSeEjecutaSiUnSoldadoSeAlejo() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        tablero.ubicar(capitan,posicion1);

        Posicion posicion2 = new Posicion(3,5);
        tablero.ubicar(soldado,posicion2);

        batallon.mover(Direccion.norte());

        assertEquals(posicion1,capitan.getPosicion());
        assertEquals(posicion2,soldado.getPosicion());
        assertFalse(batallon.pertenece(soldado));

    }

    @Test
    void testMoverBatallonSinObstaculos() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Posicion posicionFinal2 = new Posicion(2, 2);
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(3, 1);
        Posicion posicionFinal3 = new Posicion(3, 2);
        tablero.ubicar(soldado3,posicionInicial3);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.getPosicion());
        assertEquals(posicionFinal2, soldado2.getPosicion());
        assertEquals(posicionFinal3, soldado3.getPosicion());
    }

    @Test
    void testMoverBatallonSeObstaculizanEntre2deEllos() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Posicion posicionFinal2 = new Posicion(2, 2);
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionFinal3 = new Posicion(2, 3);
        tablero.ubicar(soldado3,posicionFinal2);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.getPosicion());
        assertEquals(posicionFinal2, soldado2.getPosicion());
        assertEquals(posicionFinal3, soldado3.getPosicion());
    }

    @Test
    void testMoverBatallonSeObstaculizanEntre3deEllos() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(3, 1);
        tablero.ubicar(soldado3,posicionInicial3);

        Posicion posicionFinal3 = new Posicion(4, 1);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.este());

        assertEquals(posicionInicial2, soldado1.getPosicion());
        assertEquals(posicionInicial3, soldado2.getPosicion());
        assertEquals(posicionFinal3, soldado3.getPosicion());
    }

    @Test
    void testMoverBatallonConUnObstaculoExterno() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Posicion posicionFinal2 = new Posicion(2, 2);
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(3, 1);
        Posicion posicionFinal3 = new Posicion(3, 2);
        tablero.ubicar(soldado3,posicionInicial3);

        Pieza pieza = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,posicionFinal3);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);

        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.getPosicion());
        assertEquals(posicionFinal2, soldado2.getPosicion());
        assertEquals(posicionInicial3, soldado3.getPosicion());

    }

    @Test
    void testMoverBatallonConObstaculoInternoYExterno() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(2, 2);
        tablero.ubicar(soldado3,posicionInicial3);

        Posicion posicionObstaculo = new Posicion(2, 3);
        Pieza pieza = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,posicionObstaculo);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);

        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.getPosicion());
        assertEquals(posicionInicial2, soldado2.getPosicion());
        assertEquals(posicionInicial3, soldado3.getPosicion());

    }

}