package algoChess;

import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    public void compraPiezasYSeGuardanCorrectamente()  {
        Equipo bando = new Rojo();
        Tablero tablero = new Tablero();
        Jugador nuevoJugador = new Jugador("camila",bando,tablero);
        nuevoJugador.comprarSoldado();
        nuevoJugador.comprarJinete();
        assertEquals(nuevoJugador.getCantidadDePiezas(),2);

    }

}