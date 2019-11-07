package algoChess.ArmasTest;

import algoChess.Armas.Rango;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangoTest {


    // Rango cercano
    @Test
    public void testRangoCercanoDevuelveTrueSiLaDistanciaEsUno() {

        Rango rango = Rango.cercano();
        assertTrue(rango.enRango(1));
    }

    @Test
    public void testRangoCercanoDevuelveTrueSiLaDistanciaEsDos() {

        Rango rango = Rango.cercano();
        assertTrue(rango.enRango(2));
    }
    @Test
    public void testRangoCercanoDevuelveFalseSiLaDistanciaEsTresOMas() {

        Rango rango = Rango.cercano();
        assertFalse(rango.enRango(3));
    }

    // Rango mediano

    @Test
    public void testRangoMedianoDevuelveTrueSiLaDistanciaEsTres() {

        Rango rango = Rango.mediano();
        assertTrue(rango.enRango(3));
    }
    @Test
    public void testRangoMedianoDevuelveTrueSiLaDistanciaEsCuatro() {

        Rango rango = Rango.mediano();
        assertTrue(rango.enRango(4));
    }

    @Test
    public void testRangoMedianoDevuelveTrueSiLaDistanciaEsCinco() {

        Rango rango = Rango.mediano();
        assertTrue(rango.enRango(5));
    }

    @Test
    public void testRangoMedianoDevuelveFalseSiLaDistanciaEsUno() {

        Rango rango = Rango.mediano();
        assertFalse(rango.enRango(1));
    }

    @Test
    public void testRangoMedianoDevuelveFalseSiLaDistanciaEsDos() {

        Rango rango = Rango.mediano();
        assertFalse(rango.enRango(2));
    }

    @Test
    public void testRangoMedianoDevuelveFalseSiLaDistanciaEsSeis() {

        Rango rango = Rango.mediano();
        assertFalse(rango.enRango(6));
    }

    // Rango lejano

    @Test
    public void testRangoLeganoDevuelveTrueSiLaDistanciaEsSeis() {

        Rango rango = Rango.lejano();
        assertTrue(rango.enRango(6));
    }

    @Test
    public void testRangoLeganoDevuelveTrueSiLaDistanciaEsOcho() {

        Rango rango = Rango.lejano();
        assertTrue(rango.enRango(8));
    }

    @Test
    public void testRangoLeganoDevuelveFalseSiLaDistanciaEsUno() {

        Rango rango = Rango.lejano();
        assertFalse(rango.enRango(1));
    }

    @Test
    public void testRangoLeganoDevuelveFalseSiLaDistanciaEsMenorASeis() {

        Rango rango = Rango.lejano();
        assertFalse(rango.enRango(4));
    }
}
