package algoChess;

import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import excepciones.NoAlcanzanLasMonedasException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BilleteraTest {

    @Test
    void testNoSePuedeComprarUnaPiezaSinPuntosLanzaExcepcion() {
        Billetera billetera = new Billetera(2);
        Equipo equipo = new Rojo();
        assertThrows(NoAlcanzanLasMonedasException.class,()->billetera.comprarJinete(equipo));
    }
}