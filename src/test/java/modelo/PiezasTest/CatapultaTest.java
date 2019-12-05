package modelo.PiezasTest;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Catapulta;
import modelo.piezas.Pieza;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CatapultaTest {


    @Test
    void testCatapultaSeCreaConVidaCorrecta() {
        Pieza pieza = new Catapulta(new EquipoAzul());
        assertEquals(50, pieza.getVida());
    }

    @Test
    void testCatapultaHace20DeDanioAOtraPiezaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(1,12);
        Catapulta catapultaRoja = new Catapulta(new EquipoRojo());
        Catapulta catapultaAzul = new Catapulta(new EquipoAzul());
        tablero.ubicar(catapultaRoja,posicion1);
        tablero.ubicar(catapultaAzul,posicion2);

        catapultaAzul.atacar(catapultaRoja);
        assertEquals(30,catapultaRoja.getVida());
    }
}
