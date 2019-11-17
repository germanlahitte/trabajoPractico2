package algochess.ArmasTest;

import algochess.Armas.Arma;
import algochess.Armas.ArmaEspadaJinete;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaEspadaJineteTest {
    private Tablero tablero;
    private Posicion posicionRojo;
    private Casillero casillero;
    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    public void init() {
        tablero = new Tablero();
        posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        casillero = tablero.casilleroEn(posicionRojo);
        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
        arma = new ArmaEspadaJinete();
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
        arma.atacarA(soldado,3);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaMenorDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(95,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
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
