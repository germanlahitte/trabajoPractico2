package algoChess.ArmasTest;
import algoChess.Armas.Arma;
import algoChess.Armas.ArmaArcoJinete;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaArcoJineteTest {


    @Test
    public void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        Arma arma = new ArmaArcoJinete();
        arma.atacarA(soldado,6);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        Arma arma = new ArmaArcoJinete();
        arma.atacarA(soldado,1);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        Arma arma = new ArmaArcoJinete();
        arma.atacarA(soldado,3);
        assertEquals(85,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        Pieza soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);

        Arma arma = new ArmaArcoJinete();
        arma.atacarA(soldado,3);
        arma.atacarA(soldado,3);
        arma.atacarA(soldado,3);
        arma.atacarA(soldado,3);
        arma.atacarA(soldado,3);
        arma.atacarA(soldado,3);
        arma.atacarA(soldado,3);

        assertEquals(0,soldado.vida());
    }
}
