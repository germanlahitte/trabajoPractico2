package algoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    @Test
    void ubicarDevuelveFalseEnCasoDeNoSerDelMismoEquipo() {
        Equipo rojo = new Rojo();
        Equipo azul = new Azul();
        boolean noSonDelMismoEquipo = rojo.ubicar(azul);
        assertFalse(noSonDelMismoEquipo);
    }
}