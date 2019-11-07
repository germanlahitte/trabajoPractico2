package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArmaSoldadoTest {


     /*
    public void atacarDesdeUnaDistanciaCercanaDevuelveElDanioTest(){
         Equipo e1 = new EquipoRojo();
         ArmaSoldado armaSoldado = new ArmaSoldado();
         Soldado soldado = new Soldado(e1);
         //assertEquals(10,armaSoldado.atacarA(soldado,2));
     }*/

     @Test
     public void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
         Tablero tablero = new Tablero();
         Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
         Casillero casillero = tablero.casilleroEn(posicionRojo);

         Pieza soldado = new Soldado(new EquipoRojo());
         soldado.asignarCasillero(casillero);


         Arma armaCatapulta = new ArmaSoldado();
         armaCatapulta.atacarA(soldado,3);
         assertEquals(100,soldado.vida());
     }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma armaCatapulta = new ArmaSoldado();
        armaCatapulta.atacarA(soldado,1);
        assertEquals(90,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma armaCatapulta = new ArmaSoldado();
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);
        armaCatapulta.atacarA(soldado,1);

        assertEquals(0,soldado.vida());
    }
}
