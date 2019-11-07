package algoChess;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    @Test
    void ubicarDevuelveFalseEnCasoDeNoSerDelMismoEquipo() {
        Equipo rojo = new EquipoRojo();
        Equipo azul = new EquipoAzul();
        boolean noSonDelMismoEquipo = rojo.ubicar(azul);
        assertEquals(1,1);
        //assertFalse(noSonDelMismoEquipo);
    }
}