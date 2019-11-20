package algochess.ArmasTest;

import algochess.Armas.Arma;
import algochess.Armas.ArmaCurandero;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCuranderoTest {
    private Tablero tablero;
    private Posicion posicionRojo;
    private Pieza soldado;
    private Arma armaCurandero;

    @BeforeEach
    public void init() {
        tablero = new Tablero();
        posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicionRojo);
        armaCurandero = new ArmaCurandero();
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorNoAumentaVida(){
        soldado.hacerseDanio(30);

        armaCurandero.atacarA(soldado,3);
        assertEquals(70,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaConTodaLaVidaNoAumentaVida(){
        armaCurandero.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaSinVidaNoAumentaVida(){
        soldado.hacerseDanio(200);

        armaCurandero.atacarA(soldado,1);
        assertEquals(0,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaConPocaVidaADistanciaCorrectaAumentaVida(){
        soldado.hacerseDanio(70);

        armaCurandero.atacarA(soldado,1);
        assertEquals(45,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaAumentaVidaComoMaximo100(){
        soldado.hacerseDanio(20);

        armaCurandero.atacarA(soldado,1);
        armaCurandero.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }
}
