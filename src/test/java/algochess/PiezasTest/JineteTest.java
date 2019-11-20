package algochess.PiezasTest;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Jinete;
import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {

    @Test
    public void testJineteSeCreaConVidaCorrecta() {
        Pieza pieza = new Jinete(new EquipoAzul());
        assertEquals(100, pieza.vida());
    }

    @Test
    public void testJineteHace15DeDañoAOtraPiezaEnRangoConArco() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,14);
        Pieza pieza = new Jinete(new EquipoAzul());
        Pieza pieza2 = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,posicion2);
        tablero.ubicar(pieza2,posicion1);

        pieza.atacar(pieza2);
        assertEquals(85,pieza2.vida());
    }

    @Test
    public void testJineteHace5DeDañoAOtraPiezaEnRangoConEspada() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,11);
        Jinete pieza = new Jinete(new EquipoAzul());
        Pieza pieza2 = new Jinete(new EquipoRojo());
        tablero.ubicar(pieza,posicion2);
        tablero.ubicar(pieza2,posicion1);

        pieza.atacar(pieza2);
        assertEquals(95,pieza2.vida());
    }

    @Test
    public void testUnJineteSinAliadosCercaYUnEnemigoCercaAtacaConEspada(){
        Tablero tablero = new Tablero();
        Posicion posicionRoja = new Posicion(10,10);
        Posicion posicionAzul = new Posicion(10,11);
        Jinete jineteRojo = new Jinete(new EquipoRojo());
        Pieza piezaAzul = new Jinete(new EquipoAzul());
        tablero.ubicar(jineteRojo,posicionRoja);
        tablero.ubicar(piezaAzul,posicionAzul);

        jineteRojo.atacar(piezaAzul);
        assertEquals(95,piezaAzul.vida());
    }

    @Test //EXPRESAMENTE SOLICITADO PARA LA ENTREGA
    public void testUnJineteSinAliadosCercaYUnEnemigoEnDistanciaCortaYUnoEnLargoNoPuedeAtacarAlLejano(){
        Tablero tablero = new Tablero();
        Posicion posicionRoja = new Posicion(10,10);
        Posicion posicionAzulCercana = new Posicion(10,11);
        Posicion posicionAzulLejana = new Posicion(11,14);
        Jinete jineteRojo = new Jinete(new EquipoRojo());
        Pieza piezaAzulCercana = new Jinete(new EquipoAzul());
        Pieza piezaAzulLejana = new Jinete(new EquipoAzul());
        tablero.ubicar(jineteRojo,posicionRoja);
        tablero.ubicar(piezaAzulCercana,posicionAzulCercana);
        tablero.ubicar(piezaAzulLejana,posicionAzulLejana);

        jineteRojo.atacar(piezaAzulLejana);
        assertEquals(100,piezaAzulLejana.vida());
    }

    @Test //EXPRESAMENTE SOLICITADO PARA LA ENTREGA
    public void testUnJineteSinAliadosCercaYUnEnemigoEnDistanciaCortaYUnoEnLargoPuedeAtacarAlCercano(){
        Tablero tablero = new Tablero();
        Posicion posicionRoja = new Posicion(10,10);
        Posicion posicionAzulCercana = new Posicion(10,11);
        Posicion posicionAzulLejana = new Posicion(11,14);
        Jinete jineteRojo = new Jinete(new EquipoRojo());
        Pieza piezaAzulCercana = new Jinete(new EquipoAzul());
        Pieza piezaAzulLejana = new Jinete(new EquipoAzul());
        tablero.ubicar(jineteRojo,posicionRoja);
        tablero.ubicar(piezaAzulCercana,posicionAzulCercana);
        tablero.ubicar(piezaAzulLejana,posicionAzulLejana);

        jineteRojo.atacar(piezaAzulCercana);
        assertEquals(95,piezaAzulCercana.vida());
    }

    @Test
    public void testUnJineteConAliadosCercaYUnEnemigoEnDistanciaCortaYUnoEnLargoNoPuedeAtacarAlCercano(){
        Tablero tablero = new Tablero();
        Posicion posicionRoja = new Posicion(10,10);
        Posicion posicionRojaCercana = new Posicion(9,10);
        Posicion posicionAzulCercana = new Posicion(10,11);
        Posicion posicionAzulLejana = new Posicion(11,14);
        Jinete jineteRojo = new Jinete(new EquipoRojo());
        Pieza piezaRojaCercana = new Jinete(new EquipoRojo());
        Pieza piezaAzulCercana = new Jinete(new EquipoAzul());
        Pieza piezaAzulLejana = new Jinete(new EquipoAzul());
        tablero.ubicar(jineteRojo,posicionRoja);
        tablero.ubicar(piezaRojaCercana,posicionRojaCercana);
        tablero.ubicar(piezaAzulCercana,posicionAzulCercana);
        tablero.ubicar(piezaAzulLejana,posicionAzulLejana);

        jineteRojo.atacar(piezaAzulCercana);
        assertEquals(100,piezaAzulCercana.vida());
    }

    @Test
    public void testUnJineteConAliadosCercaYUnEnemigoEnDistanciaCortaYUnoEnLargoPuedeAtacarAlLejano(){
        Tablero tablero = new Tablero();
        Posicion posicionRoja = new Posicion(10,10);
        Posicion posicionRojaCercana = new Posicion(9,10);
        Posicion posicionAzulCercana = new Posicion(10,11);
        Posicion posicionAzulLejana = new Posicion(11,14);
        Jinete jineteRojo = new Jinete(new EquipoRojo());
        Pieza piezaRojaCercana = new Jinete(new EquipoRojo());
        Pieza piezaAzulCercana = new Jinete(new EquipoAzul());
        Pieza piezaAzulLejana = new Jinete(new EquipoAzul());
        tablero.ubicar(jineteRojo,posicionRoja);
        tablero.ubicar(piezaRojaCercana,posicionRojaCercana);
        tablero.ubicar(piezaAzulCercana,posicionAzulCercana);
        tablero.ubicar(piezaAzulLejana,posicionAzulLejana);

        jineteRojo.atacar(piezaAzulLejana);
        assertEquals(85,piezaAzulLejana.vida());
    }

}
