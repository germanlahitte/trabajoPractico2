package algochess.ArmasTest;

import algochess.armas.Arma;
import algochess.armas.ArmaSoldado;
import algochess.equipos.EquipoRojo;
import algochess.piezas.Pieza;
import algochess.piezas.Soldado;
import algochess.ubicacion.Posicion;
import algochess.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaSoldadoTest {
    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    void init() {
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicionRojo);
        arma = new ArmaSoldado();
    }

     @Test
     void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
         arma.atacarA(soldado,3);
         assertEquals(100,soldado.vida());
     }

    @Test
    void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(90,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1);

        assertEquals(0,soldado.vida());
    }
}
