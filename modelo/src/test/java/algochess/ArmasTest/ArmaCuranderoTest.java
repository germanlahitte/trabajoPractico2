package algochess.ArmasTest;

import algochess.armas.Arma;
import algochess.armas.ArmaCurandero;
import algochess.equipos.EquipoRojo;
import algochess.piezas.Pieza;
import algochess.piezas.Soldado;
import algochess.ubicacion.Posicion;
import algochess.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCuranderoTest {
    private Pieza soldado;
    private Arma armaCurandero;

    @BeforeEach
    void init() {
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicionRojo);
        armaCurandero = new ArmaCurandero();
    }

    @Test
    void testAtacarAPiezaADistanciaMayorNoAumentaVida(){
        soldado.hacerseDanio(30);

        armaCurandero.atacarA(soldado,3);
        assertEquals(70,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaConTodaLaVidaNoAumentaVida(){
        armaCurandero.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaSinVidaNoAumentaVida(){
        soldado.hacerseDanio(200);

        armaCurandero.atacarA(soldado,1);
        assertEquals(0,soldado.vida());
    }

    @Test
    void testAtacarAPiezaConPocaVidaADistanciaCorrectaAumentaVida(){
        soldado.hacerseDanio(70);

        armaCurandero.atacarA(soldado,1);
        assertEquals(45,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaAumentaVidaComoMaximo100(){
        soldado.hacerseDanio(20);

        armaCurandero.atacarA(soldado,1);
        armaCurandero.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }
}
