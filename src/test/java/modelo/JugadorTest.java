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
        Jugador nuevoJugador = new Jugador("camila",bando);
        nuevoJugador.comprarSoldado();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);
    }

    @Test
     void comprarJineteSeCompraCorrectamente(){
        Equipo bando = new EquipoRojo();
        Jugador nuevoJugador = new Jugador("camila",bando);
        nuevoJugador.comprarJinete();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);

    }
    @Test
     void comprarCatapultaSeCompraCorrectamente(){
        Equipo bando = new EquipoRojo();
        Jugador nuevoJugador = new Jugador("camila",bando);
        nuevoJugador.comprarCatapulta();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);

    }

    @Test
     void comprarCuranderoSeCompraCorrectamente(){
        Equipo bando = new EquipoRojo();
        Jugador nuevoJugador = new Jugador("camila",bando);
        nuevoJugador.comprarCurandero();
        assertEquals(nuevoJugador.getCantidadDePiezas(),1);

    }


    @Test
     void testJugadorNoEsPerdedorSiTienePiezasConVida(){
        Equipo bando = new EquipoRojo();
        Jugador jugador = new Jugador("juan",bando);
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
        Jugador jugador = new Jugador("juan",bando);
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