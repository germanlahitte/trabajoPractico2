package modelo;

import modelo.equipos.Equipo;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Catapulta;
import modelo.piezas.Jinete;
import modelo.piezas.Soldado;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
     void comprarSoldadoSeCompraCorrectamente()  {
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador nuevoJugador = new Jugador("camila",bando,tablero);
        nuevoJugador.comprarSoldado();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);
    }

    @Test
     void comprarJineteSeCompraCorrectamente(){
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador nuevoJugador = new Jugador("camila",bando,tablero);
        nuevoJugador.comprarJinete();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);

    }
    @Test
     void comprarCatapultaSeCompraCorrectamente(){
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador nuevoJugador = new Jugador("camila",bando,tablero);
        nuevoJugador.comprarCatapulta();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);

    }

    @Test
     void comprarCuranderoSeCompraCorrectamente(){
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador nuevoJugador = new Jugador("camila",bando,tablero);
        nuevoJugador.comprarCurandero();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);

    }


    @Test
     void testJugadorNoEsPerdedorSiTienePiezasConVida(){
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("juan",bando,tablero);
        Soldado soldado = new Soldado(bando);
        Jinete jinete = new Jinete(bando);
        jugador.agregarPieza(soldado);
        jugador.agregarPieza(jinete);
        soldado.hacerseDanio(50);
        soldado.hacerseDanio(50);
        jinete.hacerseDanio(30);
        assertFalse(jugador.esPerdedor());

    }

    @Test
     void testJugadorEsPerdedorCuandoTodasSusPiezasSeQuedaronSinVida(){
        Equipo bando = new EquipoRojo();
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("juan",bando,tablero);
        Soldado soldado = new Soldado(bando);
        Catapulta catapulta = new Catapulta(bando);
        jugador.agregarPieza(soldado);
        jugador.agregarPieza(catapulta);
        soldado.hacerseDanio(100);
        catapulta.hacerseDanio(50);
        catapulta.hacerseDanio(30);
        assertTrue(jugador.esPerdedor());


    }



}