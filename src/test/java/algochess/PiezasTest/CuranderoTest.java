package algochess.PiezasTest;

import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.*;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuranderoTest {

    @Test
    public void testCuranderoSeCreaConVidaCorrecta() {
        Pieza pieza = new Curandero(new EquipoAzul());
        assertEquals(75, pieza.vida());
    }

    @Test
    public void testCuranderoCura15DeVidaAOtraPiezaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Curandero(new EquipoAzul());
        Pieza pieza2 = new Curandero(new EquipoRojo());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);
        pieza2.hacerseDanio(30);

        pieza.atacar(pieza2);
        assertEquals(60,pieza2.vida());
    }

    @Test
    public void testCuranderoNoCuraACatapultaEnRango() {

        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Pieza pieza = new Curandero(new EquipoAzul());
        Pieza pieza2 = new Catapulta(new EquipoAzul());
        Casillero casillero1 = tablero.casilleroEn(posicion1);
        Casillero casillero2 = tablero.casilleroEn(posicion2);
        pieza.asignarCasillero(casillero1);
        pieza2.asignarCasillero(casillero2);
        pieza2.hacerseDanio(20);

        pieza.atacar(pieza2);
        assertEquals(30,pieza2.vida());
    }
}
