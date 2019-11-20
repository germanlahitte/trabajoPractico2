package algochess.PiezasTest;
import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Catapulta;
import algochess.Piezas.Pieza;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {


    @Test
    public void testCatapultaSeCreaConVidaCorrecta() {
        Pieza pieza = new Catapulta(new EquipoAzul());
        assertEquals(50, pieza.vida());
    }

    @Test
    public void testCatapultaHace20DeDañoAOtraPiezaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(1,12);
        Catapulta catapultaRoja = new Catapulta(new EquipoRojo());
        Catapulta catapultaAzul = new Catapulta(new EquipoAzul());
        tablero.ubicar(catapultaRoja,posicion1);
        tablero.ubicar(catapultaAzul,posicion2);

        catapultaAzul.atacar(catapultaRoja);
        assertEquals(30,catapultaRoja.vida());
    }
}
