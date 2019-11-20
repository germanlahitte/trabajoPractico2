package algochess.PiezasTest;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Batallon;
import algochess.Piezas.Jinete;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BatallonTest {

    @Test
    public void testCrearBatallon(){
        Soldado capitan = new Soldado(new EquipoAzul());
        Batallon batallon = new Batallon(capitan);

        assertTrue(batallon.pertenece(capitan));
    }

    @Test
    public void testEnlistar(){
        Soldado capitan = new Soldado(new EquipoAzul());
        Batallon batallon = new Batallon(capitan);
        Soldado soldado = new Soldado(new EquipoAzul());
        batallon.enlistar(soldado);

        assertTrue(batallon.pertenece(soldado));
    }

    @Test
    public void testMoverNoSeEjecutaSiElBatallonNoEsSuficientementeGrande() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Soldado capitan = new Soldado(new EquipoRojo());
        tablero.ubicar(capitan,posicion1);

        Posicion posicion2 = new Posicion(1,2);
        Soldado soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicion2);

        Batallon batallon = new Batallon(capitan);
        batallon.enlistar(soldado);

        batallon.mover(Direccion.norte());

        assertEquals(posicion1,capitan.posicion());
        assertEquals(posicion2,soldado.posicion());
        assertFalse(batallon.pertenece(soldado));
    }

    @Test
    public void testMoverNoSeEjecutaSiUnSoldadoSeAlejo() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Soldado capitan = new Soldado(new EquipoRojo());
        tablero.ubicar(capitan,posicion1);

        Posicion posicion2 = new Posicion(3,5);
        Soldado soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicion2);

        Batallon batallon = new Batallon(capitan);
        batallon.enlistar(soldado);

        batallon.mover(Direccion.norte());

        assertEquals(posicion1,capitan.posicion());
        assertEquals(posicion2,soldado.posicion());
        assertFalse(batallon.pertenece(soldado));

    }

    @Test
    public void testMoverBatallonSinObstaculos() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Posicion posicionFinal2 = new Posicion(2, 2);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(3, 1);
        Posicion posicionFinal3 = new Posicion(3, 2);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado3,posicionInicial3);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.posicion());
        assertEquals(posicionFinal2, soldado2.posicion());
        assertEquals(posicionFinal3, soldado3.posicion());
    }

    @Test
    public void testMoverBatallonSeObstaculizanEntre2deEllos() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Posicion posicionFinal2 = new Posicion(2, 2);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionFinal3 = new Posicion(2, 3);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado3,posicionFinal2);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.posicion());
        assertEquals(posicionFinal2, soldado2.posicion());
        assertEquals(posicionFinal3, soldado3.posicion());
    }

    @Test
    public void testMoverBatallonSeObstaculizanEntre3deEllos() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(3, 1);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado3,posicionInicial3);

        Posicion posicionFinal3 = new Posicion(4, 1);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.este());

        assertEquals(posicionInicial2, soldado1.posicion());
        assertEquals(posicionInicial3, soldado2.posicion());
        assertEquals(posicionFinal3, soldado3.posicion());
    }

    @Test
    public void testMoverBatallonConUnObstaculoExterno() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Posicion posicionFinal2 = new Posicion(2, 2);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(3, 1);
        Posicion posicionFinal3 = new Posicion(3, 2);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado3,posicionInicial3);

        Pieza pieza = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,posicionFinal3);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);

        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.posicion());
        assertEquals(posicionFinal2, soldado2.posicion());
        assertEquals(posicionInicial3, soldado3.posicion());

    }

    @Test
    public void testMoverBatallonConObstaculoInternoYExterno() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial1 = new Posicion(1, 1);
        Posicion posicionFinal1 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado1,posicionInicial1);

        Posicion posicionInicial2 = new Posicion(2, 1);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado2,posicionInicial2);

        Posicion posicionInicial3 = new Posicion(2, 2);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado3,posicionInicial3);

        Posicion posicionObstaculo = new Posicion(2, 3);
        Pieza pieza = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,posicionObstaculo);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);

        batallon.mover(Direccion.norte());

        assertEquals(posicionFinal1, soldado1.posicion());
        assertEquals(posicionInicial2, soldado2.posicion());
        assertEquals(posicionInicial3, soldado3.posicion());

    }

}