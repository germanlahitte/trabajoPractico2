package algochess.ArmasTest;

import algochess.Armas.Arma;
import algochess.Armas.ArmaCatapulta;
import algochess.Equipos.EquipoAzul;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCatapultaTest {

    private Pieza soldado;
    private Tablero tablero;
    private Arma arma;

    @BeforeEach
    public void executedBeforeEach() {
        tablero = new Tablero();
        Posicion posicionRojo = new Posicion(10,10); // Posicion de equipo rojo.

        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado, posicionRojo);
        arma = new ArmaCatapulta();
    }


    // Atacar Piezas
    @Test
    public void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorDisminuyeVida(){
        arma.atacarA(soldado,6);
        assertEquals(80,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);
        arma.atacarA(soldado,6);

        assertEquals(0,soldado.vida());
    }

    @Test
    public void testPropagarDanio(){
        Soldado soldadoRojo = new Soldado (new EquipoRojo());
        Posicion posicionRojo = new Posicion(11,10); // Posicion de equipo rojo.
        Soldado soldadoAzul = new Soldado(new EquipoAzul());
        Posicion posicionAzul = new Posicion(11,11);
        tablero.ubicar(soldadoRojo,posicionRojo);
        tablero.ubicar(soldadoAzul,posicionAzul);
        arma.atacarA(soldado,7);

        assertEquals(80,soldado.vida());
        assertEquals(80,soldadoAzul.vida());
        assertEquals(80,soldadoRojo.vida());
    }
}
