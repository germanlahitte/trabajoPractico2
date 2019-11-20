package algochess.ArmasTest;

import algochess.armas.Arma;
import algochess.armas.ArmaEspadaJinete;
import algochess.equipos.EquipoRojo;
import algochess.piezas.Pieza;
import algochess.piezas.Soldado;
import algochess.ubicacion.Posicion;
import algochess.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaEspadaJineteTest {
    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    void init() {
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicionRojo);
        arma = new ArmaEspadaJinete();
    }

    @Test
    void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
        arma.atacarA(soldado,3);
        assertEquals(100,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaMenorDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(95,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
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
