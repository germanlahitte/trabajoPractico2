package algoChess.EquipoTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import excepciones.CasilleroEnemigoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    @Test
    void testEquipoAzulAtacarEquipoRojoDevuelveMultiplicadorPor5() {
        Equipo rojo = new EquipoRojo();
        Equipo azul = new EquipoAzul();
        assertEquals(1.05,azul.atacar(rojo));
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

    // Ubicacion
    @Test
    void testEquipoDevuelvePiezaSiPerteneceAlMismoEquipo() {
        Equipo rojo = new EquipoRojo();
        Equipo rojo2 = new EquipoRojo();
        Pieza pieza = new Soldado(new EquipoAzul()) ;
        rojo.ubicarCon(rojo2, pieza);
        assertEquals(pieza, rojo.ubicarCon(rojo2, pieza));
    }

    @Test
    void testEquipoNoDevuelvePiezaSiPerteneceADiferenteEquipo() {
        Equipo rojo = new EquipoRojo();
        Equipo azul = new EquipoAzul();
        Pieza pieza = new Soldado(new EquipoAzul()) ;

        assertThrows(CasilleroEnemigoException.class, ()-> rojo.ubicarCon(azul, pieza));
    }
}