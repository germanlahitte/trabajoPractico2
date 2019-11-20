package algochess.PiezasTest;

import algochess.equipos.EquipoAzul;
import algochess.equipos.EquipoRojo;
import algochess.piezas.Pieza;
import algochess.piezas.Soldado;
import algochess.ubicacion.Casillero;
import algochess.ubicacion.Posicion;
import algochess.ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class SoldadoTest {

    @Test
     void testSoldadoSeCreaConVidaCorrecta() {
        Pieza pieza = new Soldado(new EquipoAzul());
        assertEquals(100, pieza.vida());
    }

    @Test
     void testSoldadoHace10DeDanioAOtraPiezaEnRango() {
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
