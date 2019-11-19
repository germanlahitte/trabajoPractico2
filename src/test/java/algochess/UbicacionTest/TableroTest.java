package algochess.UbicacionTest;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Curandero;
import algochess.Piezas.Jinete;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import excepciones.CasilleroEnemigoException;
import excepciones.CasilleroOcupadoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {


    // Test ubicacion de pieza
    @Test
    public void TestTableroAceptaPiezaEnCasilleroDesocupadoYDeMismoEquipo(){
        Tablero tablero = new Tablero();
        Pieza pieza = new Soldado(new EquipoRojo());
        pieza.asignarCasillero(new Casillero(new Posicion(1,1), new EquipoAzul()));
        tablero.ubicar(pieza, new Posicion (2,2));

        assertEquals(pieza.posicion(),new Posicion (2,2));
    }

    @Test
    public void TestTableroNoAceptaPiezaEnCasilleroDesocupadoYDeDiferenteEquipo(){
        Tablero tablero = new Tablero();
        Pieza pieza = new Soldado(new EquipoRojo());
        Posicion posicion = new Posicion (12,12);

        assertThrows(CasilleroEnemigoException.class, ()-> tablero.ubicar(pieza, posicion));
    }

    @Test
    public void TestTableroNoAceptaPiezaEnCasilleroSiYaEstaOcupado(){
        Tablero tablero = new Tablero();
        Pieza pieza = new Soldado(new EquipoRojo());
        Pieza pieza2 = new Soldado(new EquipoRojo());
        Posicion posicion = new Posicion (2,2);
        tablero.ubicar(pieza, posicion);

        assertThrows(CasilleroOcupadoException.class, ()-> tablero.ubicar(pieza2, posicion));
    }

    // Obtener casillero en X posicion
    @Test
    public void testTableroDevuelveCasilleroDeLaPosicionElegida(){
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion (3,3);
        Casillero casillero = tablero.casilleroEn(posicion);

        assertEquals(casillero.posicion(),posicion);
    }

    @Test
    public void testTableroDevuelveNullSiLaPosicionEsIncorrecta(){
        Tablero tablero = new Tablero();
        Posicion posicion = new Posicion (30,30);

        assertEquals(null,tablero.casilleroEn(posicion));
    }

    // Test Movimientos de pieza
    // Mover
    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionNorte(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.norte());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionSur(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p2);
        tablero.mover(soldado, Direccion.sur());

        assertEquals(p1,soldado.posicion());
    }
    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionEste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,5);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.este());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionOeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,5);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.oeste());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionNoreste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.norEste());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionNoroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.norOeste());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionSureste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,4);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.surEste());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionSuroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        tablero.mover(soldado, Direccion.surOeste());

        assertEquals(p2,soldado.posicion());
    }

    @Test
    public void testTableroRecibeCuranderoYLoMueve(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Curandero curandero = new Curandero(new EquipoRojo()) ;
        tablero.ubicar(curandero,p1);
        tablero.mover(curandero, Direccion.surOeste());

        assertEquals(p2,curandero.posicion());
    }

    @Test
    public void testTableroRecibeJineteYLoMueve(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Jinete jinete = new Jinete(new EquipoRojo()) ;
        tablero.ubicar(jinete,p1);
        tablero.mover(jinete, Direccion.surOeste());

        assertEquals(p2,jinete.posicion());
    }
}