package algoChess.ArmasTest;

import algoChess.Armas.Arma;
import algoChess.Armas.ArmaEspadaJinete;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaEspadaJineteTest {

    /*
    @Test
    public void atacarDesdeUnaDistanciaCercanaDevuelveElDanioTest(){
         Equipo e1 = new EquipoRojo();
         EspadaJinete armaJinete = new EspadaJinete();
         Soldado soldado = new Soldado(e1);
         //assertEquals(5,armaJinete.atacarA(soldado,2));
     }
    @Test
     public void atacarDesdeUnaDistanciaLejanaDevuelveElDanioADistanciaTest(){
         Equipo e1 = new EquipoRojo();
         EspadaJinete armaJinete = new EspadaJinete();
         Soldado soldado = new Soldado(e1);
         //assertEquals(15,armaJinete.atacarA(soldado,25));
     }*/


    @Test
    public void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma arma = new ArmaEspadaJinete();
        arma.atacarA(soldado,3);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMenorDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma arma = new ArmaEspadaJinete();
        arma.atacarA(soldado,1);
        assertEquals(95,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);


        Arma arma = new ArmaEspadaJinete();
        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); //90

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 80

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 70

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 60

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 50

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 40

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 30

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 20

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 10

        arma.atacarA(soldado,1);
        arma.atacarA(soldado,1); // 00

        assertEquals(0,soldado.vida());
    }
}
