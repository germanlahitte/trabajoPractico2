package algochess.PiezasTest;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Batallon;
import algochess.Piezas.Jinete;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
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
        Posicion posicion1 = new Posicion(1,1);
        Casillero casillero1 = new Casillero(posicion1, new EquipoAzul() );
        Soldado capitan = new Soldado(new EquipoAzul());
        capitan.asignarCasillero(casillero1);

        Batallon batallon = new Batallon(capitan);
        Soldado soldado = new Soldado(new EquipoAzul());
        batallon.enlistar(soldado);

        Posicion posicion2 = new Posicion(1,2);
        Casillero casillero2 = new Casillero(posicion2, new EquipoAzul());
        soldado.asignarCasillero(casillero2);

        batallon.mover(Direccion.norte());

        assertEquals(posicion1,capitan.posicion());
        assertEquals(posicion2,soldado.posicion());
        assertFalse(batallon.pertenece(soldado));
    }

    @Test
    public void testMoverNoSeEjecutaSiUnSoldadoSeAlejo() {
        Posicion posicion1 = new Posicion(1,1);
        Casillero casillero1 = new Casillero(posicion1, new EquipoAzul() );
        Soldado capitan = new Soldado(new EquipoAzul());
        capitan.asignarCasillero(casillero1);

        Batallon batallon = new Batallon(capitan);
        Soldado soldado = new Soldado(new EquipoAzul());
        batallon.enlistar(soldado);

        Posicion posicion2 = new Posicion(3,5);
        Casillero casillero2 = new Casillero(posicion2, new EquipoAzul());
        soldado.asignarCasillero(casillero2);

        batallon.mover(Direccion.norte());

        assertEquals(posicion1,capitan.posicion());
        assertEquals(posicion2,soldado.posicion());
        assertFalse(batallon.pertenece(soldado));

    }

    @Test
    public void testMoverBatallonSinObstaculos() {
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1, 1);
        Posicion p2 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        Casillero c1 = new Casillero(p1, tablero);
        soldado1.asignarCasillero(c1);

        Posicion p3 = new Posicion(2, 1);
        Posicion p4 = new Posicion(2, 2);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        Casillero c3 = new Casillero(p3, tablero);
        soldado2.asignarCasillero(c3);

        Posicion p5 = new Posicion(3, 1);
        Posicion p6 = new Posicion(3, 2);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        Casillero c5 = new Casillero(p5, tablero);
        soldado3.asignarCasillero(c5);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.norte());

        assertEquals(p2, soldado1.posicion());
        assertEquals(p4, soldado2.posicion());
        assertEquals(p6, soldado3.posicion());
    }

    @Test
    public void testMoverBatallonSeObstaculizanEntre2deEllos() {
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1, 1);
        Posicion p2 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        Casillero c1 = new Casillero(p1, tablero);
        soldado1.asignarCasillero(c1);

        Posicion p3 = new Posicion(2, 1);
        Posicion p4 = new Posicion(2, 2);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        Casillero c3 = new Casillero(p3, tablero);
        soldado2.asignarCasillero(c3);

        Posicion p6 = new Posicion(2, 3);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        Casillero c5 = new Casillero(p4, tablero);
        soldado3.asignarCasillero(c5);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.norte());

        assertEquals(p2, soldado1.posicion());
        assertEquals(p4, soldado2.posicion());
        assertEquals(p6, soldado3.posicion());
    }

    @Test
    public void testMoverBatallonSeObstaculizanEntre3deEllos() {
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1, 1);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        Casillero c1 = new Casillero(p1, tablero);
        soldado1.asignarCasillero(c1);

        Posicion p2 = new Posicion(2, 1);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        Casillero c2 = new Casillero(p2, tablero);
        soldado2.asignarCasillero(c2);

        Posicion p3 = new Posicion(3, 1);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        Casillero c3 = new Casillero(p3, tablero);
        soldado3.asignarCasillero(c3);

        Posicion p4 = new Posicion(4, 1);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);
        batallon.mover(Direccion.este());

        assertEquals(p2, soldado1.posicion());
        assertEquals(p3, soldado2.posicion());
        assertEquals(p4, soldado3.posicion());
    }

    @Test
    public void testMoverBatallonConUnObstaculoExterno() {
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1, 1);
        Posicion p2 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        Casillero c1 = new Casillero(p1, tablero);
        soldado1.asignarCasillero(c1);

        Posicion p3 = new Posicion(2, 1);
        Posicion p4 = new Posicion(2, 2);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        Casillero c3 = new Casillero(p3, tablero);
        soldado2.asignarCasillero(c3);

        Posicion p5 = new Posicion(3, 1);
        Posicion p6 = new Posicion(3, 2);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        Casillero c5 = new Casillero(p5, tablero);
        soldado3.asignarCasillero(c5);

        Pieza pieza = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,p6);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);

        batallon.mover(Direccion.norte());

        assertEquals(p2, soldado1.posicion());
        assertEquals(p4, soldado2.posicion());
        assertEquals(p5, soldado3.posicion());

    }

    @Test
    public void testMoverBatallonConObstaculoInternoYExterno() {
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1, 1);
        Posicion p2 = new Posicion(1, 2);
        Soldado soldado1 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado1,p1);

        Posicion p3 = new Posicion(2, 1);
        Soldado soldado2 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado2,p3);

        Posicion p4 = new Posicion(2, 2);
        Soldado soldado3 = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado3,p4);

        Posicion p6 = new Posicion(2, 3);
        Pieza pieza = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,p6);

        Batallon batallon = new Batallon(soldado2);
        batallon.enlistar(soldado1);
        batallon.enlistar(soldado3);

        batallon.mover(Direccion.norte());

        assertEquals(p2, soldado1.posicion());
        assertEquals(p3, soldado2.posicion());
        assertEquals(p4, soldado3.posicion());

    }

}