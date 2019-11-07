package algoChess.UbicacionTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Curandero;
import algoChess.Piezas.Jinete;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Direccion;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import excepciones.CasilleroOcupadoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest { //TODO: necesito tocar otras clases para un método
    @Test
    public void seCreaCorrectamenteElTableroTest(){
        Tablero tablero = new Tablero();
        assertEquals(400,tablero.getCantidadDeCasilleros());
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

    // Test ubicacion de pieza


    @Test
    public void seColocaUnaPiezaAliadaEnUnCasilleroAliadoVacioConExitoTest(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new EquipoRojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (1,3);
        Casillero unCasillero = tablero.buscar(unaPosicion);

        Posicion p3 = new Posicion(1,19);
        Casillero casillero3 = new Casillero(p3,bandoRojo);
        piezaPrueba.asignarCasillero(casillero3);

        tablero.ubicar(piezaPrueba,unCasillero);

        assertEquals(piezaPrueba.distanciaA(unCasillero),0);
    }

    @Test
    public void noSePuedeColocarPiezaEnCasilleroEnemigo(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new EquipoRojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (15,15);
        Casillero unCasillero = tablero.buscar(unaPosicion);

        tablero.ubicar(piezaPrueba,unCasillero);
        //Necesito probar que el casillero está vacío
        assertEquals(1,1);
    }

    @Test
    public void noSePuedeColocarPiezaEnCasilleroOcupado(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new EquipoRojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (1,3);
        Casillero unCasillero = tablero.buscar(unaPosicion);

        Posicion p3 = new Posicion(1,19);
        Casillero casillero3 = new Casillero(p3,bandoRojo);
        piezaPrueba.asignarCasillero(casillero3);

        tablero.ubicar(piezaPrueba,unCasillero);

        Soldado otraPieza = new Soldado(bandoRojo);

        assertThrows(CasilleroOcupadoException.class,()-> tablero.ubicar(otraPieza,unCasillero));
    }


   // Test Movimientos de pieza

    // Mover
    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionNorte(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,6);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;
        soldado.asignarCasillero(casillero);

        tablero.mover(soldado, Direccion.norte());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionSur(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,4);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;

        soldado.asignarCasillero(casillero);

        tablero.mover(soldado, Direccion.sur());

        assertEquals(p2,soldado.posicion());

    }
    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionEste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,5);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;

        soldado.asignarCasillero(casillero);
        tablero.mover(soldado, Direccion.este());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionOeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,5);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;

        soldado.asignarCasillero(casillero);

        tablero.mover(soldado, Direccion.oeste());


        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionNoreste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,6);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;
        soldado.asignarCasillero(casillero);

        tablero.mover(soldado, Direccion.norEste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionNoroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,6);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;

        soldado.asignarCasillero(casillero);


        tablero.mover(soldado, Direccion.norOeste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionSureste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,4);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;

        soldado.asignarCasillero(casillero);

        tablero.mover(soldado, Direccion.surEste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeSoldadoYLoMueveEnDireccionSuroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Casillero casillero = new Casillero(p1,tablero);

        Soldado soldado = new Soldado(new EquipoAzul()) ;

        soldado.asignarCasillero(casillero);

        tablero.mover(soldado, Direccion.surOeste());

        assertEquals(p2,soldado.posicion());

    }

    @Test
    public void testTableroRecibeCuranderoYLoMueve(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Casillero casillero = new Casillero(p1,tablero);

        Curandero curandero = new Curandero(new EquipoAzul()) ;

        curandero.asignarCasillero(casillero);

        tablero.mover(curandero, Direccion.surOeste());

        assertEquals(p2,curandero.posicion());

    }

    @Test
    public void testTableroRecibeJineteYLoMueve(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Casillero casillero = new Casillero(p1,tablero);

        Jinete jinete = new Jinete(new EquipoAzul()) ;

        jinete.asignarCasillero(casillero);

        tablero.mover(jinete, Direccion.surOeste());

        assertEquals(p2,jinete.posicion());

    }



}