package algochess.ArmasTest;

import algochess.armas.Arma;
import algochess.armas.ArmaCatapulta;
import algochess.equipos.EquipoAzul;
import algochess.equipos.EquipoRojo;
import algochess.piezas.Pieza;
import algochess.piezas.Soldado;
import algochess.ubicacion.Posicion;
import algochess.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCatapultaTest {

    private Pieza soldado;
    private Tablero tablero;
    private Arma arma;

    @BeforeEach
    void executedBeforeEach() {
        tablero = new Tablero();
        Posicion posicionRojo = new Posicion(10,10); // Posicion de equipo rojo.

        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado, posicionRojo);
        arma = new ArmaCatapulta();
    }


    // Atacar Piezas
    @Test
    void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaMayorDisminuyeVida(){
        arma.atacarA(soldado,6);
        assertEquals(80,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
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
    void testPropagarDanio(){
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
