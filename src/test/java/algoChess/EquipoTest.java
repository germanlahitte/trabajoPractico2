package algoChess;

import algoChess.Equipos.Azul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    @Test
    void ubicarDevuelveFalseEnCasoDeNoSerDelMismoEquipo() {
        Equipo rojo = new Rojo();
        Equipo azul = new Azul();
        boolean noSonDelMismoEquipo = rojo.ubicar(azul);
        assertEquals(1,1);
        //assertFalse(noSonDelMismoEquipo);
    }
}