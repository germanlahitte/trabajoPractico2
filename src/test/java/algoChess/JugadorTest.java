package algoChess;

import excepciones.NoAlcanzanLasMonedasException;
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