package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
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
