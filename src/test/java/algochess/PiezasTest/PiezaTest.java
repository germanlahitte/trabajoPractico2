package algochess.PiezasTest;

import algochess.Armas.*;
import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Direccion;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import excepciones.CasilleroEnemigoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PiezaTest {

    // Ubicar pieza
    @Test
    public void testPiezaSeUbicaEnCasilleroSiPerteneAlMismoEquipo() {
        Pieza pieza = new Soldado(new EquipoRojo());
        assertEquals(pieza, pieza.ubicarCon(new EquipoRojo()));

    }

    @Test
    public void testPiezaNoSeUbicaEnCasilleroSiNoPerteneAlMismoEquipo() {
        Pieza pieza = new Soldado(new EquipoRojo());
        assertThrows(CasilleroEnemigoException.class, ()-> pieza.ubicarCon(new EquipoAzul()));
    }

    // Atacarse
    @Test
    public void testPiezaRojoEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroRojoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(90,pieza.vida());
    }

    @Test
    public void testPiezaAzulEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroRojoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(89.5,pieza.vida());
    }

    @Test
    public void testPiezaRojoEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroLejanoRojoNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,6);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.vida());
    }

    @Test
    public void testPiezaRojoEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroLejanoAzulNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(11,12);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.vida());
    }

    @Test
    public void testPiezaAzulEsAtacadoConArmaDeSoldadoYDesdeUnCasilleroAzulPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,11);
        Posicion posicion2 = new Posicion(11,12);
        Pieza pieza = new Soldado(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaSoldado();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(90,pieza.vida());
    }


    @Test
    public void testPiezaRojoEsAtacadoConArmaArcoDeJineteYDesdeUnCasilleroRojoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,4);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaArcoJinete();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(85,pieza.vida());
    }

    @Test
    public void testPiezaRojoEsAtacadoConArmaArcoDeJineteYDesdeUnCasilleroCercanoRojoNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaArcoJinete();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.vida());
    }

    @Test
    public void testPiezaRojoEsAtacadoConArmaArcoDeJineteYDesdeUnCasilleroLejanoRojoNoPierdeVida(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,10);
        Pieza pieza = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        Arma arma = new ArmaArcoJinete();

        pieza.atacadaDesde(casillero2,arma);
        assertEquals(100,pieza.vida());
    }

    @Test
    public void testPiezaAtacaOtraPiezaRestaVidaSiEstaEnRango(){
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
        assertEquals(89.5,pieza2.vida());
    }

    @Test
    public void testPiezaNoAtacaOtraPiezaSiNoEstaEnRango(){
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
        assertEquals(100,pieza.vida());
    }

    // Quitarse vida (Hacerse daño)
    @Test
    public void testPiezaRojaQuitarVidaQuitaDañoMultiplicadoPorUnoEnCasilleroRojo(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        soldado.quitarVida(30);
        assertEquals(70,soldado.vida());
    }

    @Test
    public void testPiezaRojaQuitarVidaHastaLlegarACeroEnCasilleroRojo(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);

        assertEquals(0,soldado.vida());
    }

    @Test
    public void testPiezaRojaQuitarVidaHastaLlegarACeroEnCasilleroAzul(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(11,11); // Posicion de equipo azul.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);
        soldado.quitarVida(30);

        assertEquals(0,soldado.vida());
    }

    @Test
    public void testPiezaRojaQuitarVidaQuitaDañoMultiplicadoPorCincoEnCasilleroAzul(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(11,11); // Posicion de equipo azul.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);

        assertEquals(68.5,soldado.vida());
    }

    @Test
    public void testPiezaAzulQuitaVidaMultiplicandoDañoPorCincoCuandoEstaEnCasilleroDeMismoEquipo(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);
        Pieza soldado = new Soldado(new EquipoAzul());
        soldado.asignarCasillero(casillero);
        soldado.quitarVida(30);

        assertEquals(68.5,soldado.vida());
    }

    @Test
    public void testPiezaRestaVidaEn40(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(40);
        assertEquals(60,soldado1.vida());
    }

    @Test
    public void testPiezaRestaVidaEn60(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(60);

        assertEquals(40,soldado1.vida());
    }

    @Test
    public void testPiezaLlegaA0DeVida(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(100);

        assertEquals(0,soldado1.vida());
    }

    @Test
    public void testPiezaAlQuitarleVidaDeMasNoBajaDe0(){
        Soldado soldado1 = new Soldado(new EquipoRojo());
        soldado1.hacerseDanio(100);
        soldado1.hacerseDanio(100);
        soldado1.hacerseDanio(100);

        assertEquals(0,soldado1.vida());
    }

    // Mover
    @Test
    public void testMovibleSeMueveEnDireccionNorte(){
        Tablero tablero = new Tablero();
        Posicion p1 = new Posicion(5,5);
        Posicion p2 = new Posicion(5,6);
        Casillero casillero = new Casillero(p1,tablero);
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
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
        Soldado soldado = new Soldado(new EquipoAzul()) ;
        soldado.asignarCasillero(casillero);
        soldado.mover(Direccion.surOeste());

        assertEquals(p2,soldado.posicion());
    }
}