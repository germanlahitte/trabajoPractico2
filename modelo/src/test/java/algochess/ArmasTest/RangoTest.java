package algochess.ArmasTest;

import algochess.armas.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangoTest {


    // Rango cercano
    @Test
    void testRangoCercanoDevuelveTrueSiLaDistanciaEsUno() {

        Rango rango = Rango.cercano();
        assertTrue(rango.enRango(1));
    }

    @Test
    void testRangoCercanoDevuelveTrueSiLaDistanciaEsDos() {

        Rango rango = Rango.cercano();
        assertTrue(rango.enRango(2));
    }
    @Test
    void testRangoCercanoDevuelveFalseSiLaDistanciaEsTresOMas() {

        Rango rango = Rango.cercano();
        assertFalse(rango.enRango(3));
    }

    // Rango mediano
    @Test
    void testRangoMedianoDevuelveTrueSiLaDistanciaEsTres() {

        Rango rango = Rango.mediano();
        assertTrue(rango.enRango(3));
    }
    @Test
    void testRangoMedianoDevuelveTrueSiLaDistanciaEsCuatro() {

        Rango rango = Rango.mediano();
        assertTrue(rango.enRango(4));
    }

    @Test
    void testRangoMedianoDevuelveTrueSiLaDistanciaEsCinco() {

        Rango rango = Rango.mediano();
        assertTrue(rango.enRango(5));
    }

    @Test
    void testRangoMedianoDevuelveFalseSiLaDistanciaEsUno() {

        Rango rango = Rango.mediano();
        assertFalse(rango.enRango(1));
    }

    @Test
    void testRangoMedianoDevuelveFalseSiLaDistanciaEsDos() {

        Rango rango = Rango.mediano();
        assertFalse(rango.enRango(2));
    }

    @Test
    void testRangoMedianoDevuelveFalseSiLaDistanciaEsSeis() {

        Rango rango = Rango.mediano();
        assertFalse(rango.enRango(6));
    }

    // Rango lejano
    @Test
    void testRangoLeganoDevuelveTrueSiLaDistanciaEsSeis() {

        Rango rango = Rango.lejano();
        assertTrue(rango.enRango(6));
    }

    @Test
    void testRangoLeganoDevuelveTrueSiLaDistanciaEsOcho() {

        Rango rango = Rango.lejano();
        assertTrue(rango.enRango(8));
    }

    @Test
    void testRangoLeganoDevuelveFalseSiLaDistanciaEsUno() {

        Rango rango = Rango.lejano();
        assertFalse(rango.enRango(1));
    }

    @Test
    void testRangoLeganoDevuelveFalseSiLaDistanciaEsMenorASeis() {

        Rango rango = Rango.lejano();
        assertFalse(rango.enRango(4));
    }
}
