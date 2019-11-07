package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCuranderoTest {

    /*@Test
    public void curarDesdeUnaDistanciaCercanaDevuelveLaCuracionTest(){
        Equipo e1 = new EquipoRojo();
        ArmaCurandero armaCurandero = new ArmaCurandero();
        Soldado soldado = new Soldado(e1);
        //assertEquals(15,armaCurandero.atacarA(soldado,2));

    }*/


    @Test
    public void testAtacarAPiezaADistanciaMayorNoAumentaVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma arma = new ArmaCurandero();
        soldado.hacerseDanio(30);

        arma.atacarA(soldado,3);
        assertEquals(70,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaConTodaLaVidaNoAumentaVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma arma = new ArmaCurandero();

        arma.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaSinVidaNoAumentaVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        soldado.hacerseDanio(200);
        Arma arma = new ArmaCurandero();

        arma.atacarA(soldado,1);
        assertEquals(0,soldado.vida());
    }


    @Test
    public void testAtacarAPiezaConPocaVidaADistanciaCorrectaAumentaVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        soldado.hacerseDanio(70);
        Arma arma = new ArmaCurandero();

        arma.atacarA(soldado,1);
        assertEquals(45,soldado.vida());
    }



    @Test
    public void testAtacarAPiezaADistanciaCorrectaAumentaVidaComoMaximo100(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        soldado.hacerseDanio(70);

        Arma arma = new ArmaCurandero();
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
        assertEquals(100,soldado.vida());
    }
}
