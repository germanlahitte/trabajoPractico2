package algochess.ArmasTest;
import algochess.armas.Arma;
import algochess.armas.ArmaArcoJinete;
import algochess.equipos.EquipoRojo;
import algochess.piezas.Pieza;
import algochess.piezas.Soldado;
import algochess.ubicacion.Casillero;
import algochess.ubicacion.Posicion;
import algochess.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaArcoJineteTest {


    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    void executedBeforeEach() {

        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
    }

    @Test
    void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,6);

        assertEquals(100,soldado.vida());

    }

    @Test
    void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,1);

        assertEquals(100,soldado.vida());
    }



    @Test
    void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,3);

        assertEquals(85,soldado.vida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        arma = new ArmaArcoJinete();
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
