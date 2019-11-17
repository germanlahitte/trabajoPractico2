package algochess.ArmasTest;

import algochess.Armas.Arma;
import algochess.Armas.ArmaCatapulta;
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
    private Arma arma;
    @BeforeEach
    public void executedBeforeEach() {
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
    }


    // Atacar Piezas
    @Test
    public void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        Arma armaCatapulta = new ArmaCatapulta();
        armaCatapulta.atacarA(soldado,1);

        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorDisminuyeVida(){
        Arma armaCatapulta = new ArmaCatapulta();
        armaCatapulta.atacarA(soldado,6);

        assertEquals(80,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        Arma armaCatapulta = new ArmaCatapulta();
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);
        armaCatapulta.atacarA(soldado,6);

        assertEquals(0,soldado.vida());
    }
}
