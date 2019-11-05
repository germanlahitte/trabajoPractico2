package algoChess;

import excepciones.NoAlcanzanLasMonedasException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilleteraTest {

    @Test
    void testNoSePuedeComprarSinPuntosLanzaExcepcion() {
        Billetera billetera = new Billetera(10);
        Equipo equipo = new Rojo();
        assertThrows(NoAlcanzanLasMonedasException.class,()->billetera.comprar(Soldado.class,equipo));
    }
}