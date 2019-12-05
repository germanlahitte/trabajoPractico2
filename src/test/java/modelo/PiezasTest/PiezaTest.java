package modelo.PiezasTest;

import modelo.armas.*;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Casillero;
import modelo.ubicacion.Direccion;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import excepciones.CasilleroEnemigoException;
import excepciones.CasilleroOcupadoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PiezaTest {

    // Ubicar pieza
    @Test
    void testPiezaSeUbicaEnCasilleroSiPerteneAlMismoEquipo() {
        Pieza pieza = new Soldado(new EquipoRojo());
        assertEquals(pieza, pieza.ubicarCon(new EquipoRojo()));

    }

    @Test
    void testPiezaNoSeUbicaEnCasilleroSiNoPerteneAlMismoEquipo() {
        Pieza pieza = new Soldado(new EquipoRojo());
        assertThrows(CasilleroEnemigoException.class, ()-> pieza.ubicarCon(new EquipoAzul()));
    }

    // Atacarse
    @Test
     void testPiezaRojoEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroRojoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(90,pieza.getVida());
    }

    @Test
     void testPiezaAzulEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroRojoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(89.5,pieza.getVida());
    }

    @Test
     void testPiezaRojoEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroLejanoRojoNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,6);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.getVida());
    }

    @Test
     void testPiezaRojoEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroLejanoAzulNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(11,12);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.getVida());
    }

    @Test
     void testPiezaAzulEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroAzulPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,11);
        Posicion posicion2 = new Posicion(11,12);
        Pieza pieza = new Soldado(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(90,pieza.getVida());
    }


    @Test
     void testPiezaRojoEsAtacadoConArmaArcoDeJineteYDesdeUnCasilleroRojoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,4);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaArcoJinete();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(85,pieza.getVida());
    }

    @Test
     void testPiezaRojoEsAtacadoConArmaArcoDeJineteYDesdeUnCasilleroCercanoRojoNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaArcoJinete();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.getVida());
    }

    @Test
     void testPiezaRojoEsAtacadoConArmaArcoDeJineteYDesdeUnCasilleroLejanoRojoNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,10);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaArcoJinete();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.getVida());
    }

    @Test
     void testPiezaAtacaOtraPiezaRestaVidaSiEstaEnRango(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoRojo());
        Pieza pieza2 = new Soldado(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);

        pieza.atacar(pieza2);
        assertEquals(89.5,pieza2.getVida());
    }

    @Test
     void testPiezaNoAtacaOtraPiezaSiNoEstaEnRango(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,10);
        Pieza pieza = new Soldado(new EquipoRojo());
        Pieza pieza2 = new Soldado(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);

        pieza.atacar(pieza2);
        assertEquals(100,pieza.getVida());
    }

    // Quitarse vida (Hacerse daño)
    @Test
     void testPiezaRojaQuitarVidaQuitaDaniooMultiplicadoPorUnoEnCasilleroRojo(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        soldado.quitarVida(30);
        assertEquals(70,soldado.getVida());
    }

    @Test
     void testPiezaRojaQuitarVidaHastaLlegarACeroEnCasilleroRojo(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);

        assertEquals(0,soldado.getVida());
    }

    @Test
     void testPiezaRojaQuitarVidaHastaLlegarACeroEnCasilleroAzul(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(11,11); // Posicion de equipo azul.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);

        assertEquals(0,soldado.getVida());
    }

    @Test
     void testPiezaRojaQuitarVidaQuitaDanioMultiplicadoPorCincoEnCasilleroAzul(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(11,11); // Posicion de equipo azul.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);

        assertEquals(68.5,soldado.getVida());
    }

    @Test
     void testPiezaAzulQuitaVidaMultiplicandoDanioPorCincoCuandoEstaEnCasilleroDeMismoEquipo(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoAzul());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);

        assertEquals(68.5,soldado.getVida());
    }

    @Test
     void testPiezaRestaVidaEn40(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(40);
        assertEquals(60,soldado1.getVida());
    }

    @Test
     void testPiezaRestaVidaEn60(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(60);

        assertEquals(40,soldado1.getVida());
    }

    @Test
     void testPiezaLlegaA0DeVida(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(100);

        assertEquals(0,soldado1.getVida());
    }

    @Test
     void testPiezaAlQuitarleVidaDeMasNoBajaDe0(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(100);
        soldado1.hacerseDanio(100);
        soldado1.hacerseDanio(100);

        assertEquals(0,soldado1.getVida());
    }

    // Mover
    @Test
     void testMovibleSeMueveEnDireccionNorte(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.norte());

        assertEquals(p2,soldado.getPosicion());
    }

    @Test
     void testMovibleSeMueveEnDireccionSur(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,4);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.sur());

        assertEquals(p2,soldado.getPosicion());
    }
    @Test
     void testMovibleSeMueveEnDireccionEste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,5);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.este());

        assertEquals(p2,soldado.getPosicion());
    }

    @Test
     void testMovibleSeMueveEnDireccionOeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,5);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.oeste());

        assertEquals(p2,soldado.getPosicion());
    }

    @Test
     void testMovibleSeMueveEnDireccionNoreste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.norEste());

        assertEquals(p2,soldado.getPosicion());
    }

    @Test
     void testMovibleSeMueveEnDireccionNoroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,6);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.norOeste());

        assertEquals(p2,soldado.getPosicion());
    }

    @Test
     void testMovibleSeMueveEnDireccionSureste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(6,4);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.surEste());

        assertEquals(p2,soldado.getPosicion());
    }

    @Test
     void testMovibleSeMueveEnDireccionSuroeste(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(4,4);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);
        soldado.mover(Direccion.surOeste());

        assertEquals(p2,soldado.getPosicion());
    }


    @Test
    void testMovibleNoSeMueveFueraDelTableroEsquinaInferiorIzquierda(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1,1);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);

        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.surOeste()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.oeste()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.sur()));
    }

    @Test
    void testMovibleNoSeMueveFueraDelTableroEsquinaSuperiorIzquierda(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(1,20);
        Soldado soldado = new Soldado(new EquipoAzul()) ;
        tablero.ubicar(soldado,p1);

        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.norOeste()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.oeste()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.norte()));
    }

    @Test
    void testMovibleNoSeMueveFueraDelTableroEsquinaSuperiorDerecha(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(20,20);
        Soldado soldado = new Soldado(new EquipoAzul()) ;
        tablero.ubicar(soldado,p1);

        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.norEste()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.norte()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.este()));
    }

    @Test
    void testMovibleNoSeMueveFueraDelTableroEsquinaInferiorDerecha(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(20,1);
        Soldado soldado = new Soldado(new EquipoRojo()) ;
        tablero.ubicar(soldado,p1);

        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.surEste()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.este()));
        assertThrows(CasilleroOcupadoException.class,()->soldado.mover(Direccion.sur()));
    }


}
