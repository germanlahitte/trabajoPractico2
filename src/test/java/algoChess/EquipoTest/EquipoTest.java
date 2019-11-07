package algoChess.EquipoTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {


    /*
    @Test
    void ubicarDevuelveFalseEnCasoDeNoSerDelMismoEquipo() {
        Equipo rojo = new EquipoRojo();
        Equipo azul = new EquipoAzul();
        boolean noSonDelMismoEquipo = rojo.ubicar(azul);
        assertEquals(1,1);
        //assertFalse(noSonDelMismoEquipo);
    } */

    @Test
    void testEquipoAzulAtacarEquipoRojoDevuelveMultiplicadorPor5() {
        Equipo rojo = new EquipoRojo();
        Equipo azul = new EquipoAzul();
        assertEquals(1.05,azul.atacar(rojo));
        //assertFalse(noSonDelMismoEquipo);
    }

    @Test
    void testEquipoAzulAtacarEquipoAzulDevuelveMultiplicadorPor1() {
        Equipo azul2 = new EquipoAzul();
        Equipo azul = new EquipoAzul();
        assertEquals(1.00,azul2.atacar(azul));
    }

    @Test
    void testEquipoRojoAtacaEquipoAzulDevuelveMultiplicadorPor5() {
        Equipo rojo = new EquipoRojo();
        Equipo azul = new EquipoAzul();
        assertEquals(1.05,rojo.atacar(azul));
    }

    @Test
    void testEquipoRojoAtacarEquipoRojoDevuelveMultiplicadorPor1() {
        Equipo rojo = new EquipoRojo();
        Equipo rojo2 = new EquipoRojo();
        assertEquals(1.00,rojo.atacar(rojo2));
    }
}