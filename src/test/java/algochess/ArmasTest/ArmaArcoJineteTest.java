package algochess.ArmasTest;
import algochess.Armas.Arma;
import algochess.Armas.ArmaArcoJinete;
import algochess.Equipos.EquipoRojo;
import algochess.Piezas.Pieza;
import algochess.Piezas.Soldado;
import algochess.Ubicacion.Casillero;
import algochess.Ubicacion.Posicion;
import algochess.Ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaArcoJineteTest {


    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    private void executedBeforeEach() {

        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        Casillero casillero = tablero.casilleroEn(posicionRojo);

        soldado = new Soldado(new EquipoRojo());
        soldado.asignarCasillero(casillero);
    }

    @Test
    public void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,6);

        assertEquals(100,soldado.vida());

    }

    @Test
    public void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,1);

        assertEquals(100,soldado.vida());
    }



    @Test
    public void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,3);

        assertEquals(85,soldado.vida());
    }

    @Test
    public void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
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
