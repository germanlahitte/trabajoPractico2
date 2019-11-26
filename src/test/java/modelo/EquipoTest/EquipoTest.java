package modelo.EquipoTest;

import modelo.equipos.EquipoAzul;
import modelo.equipos.Equipo;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import excepciones.CasilleroEnemigoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {
    private Equipo rojo;
    private Equipo azul;

    @BeforeEach
    void init(){
        rojo = new EquipoRojo();
        azul = new EquipoAzul();
    }

    @Test
    void testEquipoAzulAtacarEquipoRojoDevuelveMultiplicadorPor5() {
        assertEquals(1.05,azul.atacar(rojo));
    }

    @Test
    void testEquipoAzulAtacarEquipoAzulDevuelveMultiplicadorPor1() {
        Equipo azul2 = new EquipoAzul();
        assertEquals(1.00,azul2.atacar(azul));
    }

    @Test
    void testEquipoRojoAtacaEquipoAzulDevuelveMultiplicadorPor5() {
        assertEquals(1.05,rojo.atacar(azul));
    }

    @Test
    void testEquipoRojoAtacarEquipoRojoDevuelveMultiplicadorPor1() {
        Equipo rojo2 = new EquipoRojo();
        assertEquals(1.00,rojo.atacar(rojo2));
    }

    // Ubicacion
    @Test
    void testEquipoDevuelvePiezaSiPerteneceAlMismoEquipo() {
        Equipo rojo2 = new EquipoRojo();
        Pieza pieza = new Soldado(new EquipoAzul()) ;
        rojo.ubicarCon(rojo2, pieza);
        assertEquals(pieza, rojo.ubicarCon(rojo2, pieza));
    }

    @Test
    void testEquipoNoDevuelvePiezaSiPerteneceADiferenteEquipo() {
        Pieza pieza = new Soldado(new EquipoAzul()) ;
        assertThrows(CasilleroEnemigoException.class, ()-> rojo.ubicarCon(azul, pieza));
    }

    @Test
    void testEquipoRojoNoEsAliadoDeEquipoAzul(){
        assertFalse(rojo.soyAliado(azul));
    }

    @Test
    void testEquipoAzulNoEsAliadoDeEquipoRojo(){
        assertFalse(azul.soyAliado(rojo));
    }

    @Test
    void testEquipoAzulEsAliadoDeEquipoAzul(){ assertTrue(azul.soyAliado(azul)); }

    @Test
    void testEquipoRojoEsAliadoDeEquipoRojo(){ assertTrue(rojo.soyAliado(rojo)); }
}