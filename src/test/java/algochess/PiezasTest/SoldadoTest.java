package algochess.PiezasTest;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoldadoTest {

    @Test
    public void testSoldadoSeCreaConVidaCorrecta() {
        Pieza pieza = new Soldado(new EquipoAzul());
        assertEquals(100, pieza.vida());
    }

    @Test
    public void testSoldadoHace10DeDañoAOtraPiezaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Soldado(new EquipoAzul());
        Pieza pieza2 = new Soldado(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);
        pieza.atacar(pieza2);

        assertEquals(90,pieza2.vida());
    }
}
