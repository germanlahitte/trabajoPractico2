package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCatapultaTest {

    /*
    @Test
    public void atacarDesdeUnaDistanciaLejanaDevuelveElDanioADistanciaTest(){
        Equipo e1 = new EquipoRojo();
        ArmaCatapulta armaCatapulta = new ArmaCatapulta();
        Soldado soldado = new Soldado(e1);
        //assertEquals(15,armaCatapulta.atacarA(soldado,7));

    }

    @Test
    public void atacarDesdeUnaDistanciaLejanaNoDevuelveNingunDanioTest(){
        Equipo e1 = new EquipoRojo();
        ArmaCatapulta armaCatapulta = new ArmaCatapulta();
        Soldado soldado = new Soldado(e1);
        //assertEquals(0,armaCatapulta.atacarA(soldado,2));


    }*/


    // Atacar Piezas

    @Test
    public void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma armaCatapulta = new ArmaCatapulta();
        armaCatapulta.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma armaCatapulta = new ArmaCatapulta();
        armaCatapulta.atacarA(soldado,6);
        assertEquals(80,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


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
