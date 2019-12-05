package modelo.ArmasTest;
import excepciones.DistanciaArmaInefectiva;
import modelo.armas.Arma;
import modelo.armas.ArmaArcoJinete;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Casillero;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(DistanciaArmaInefectiva.class, ()-> arma.atacarA(soldado,6));

        assertEquals(100,soldado.getVida());

    }

    @Test
    void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){
        arma = new ArmaArcoJinete();
        assertThrows(DistanciaArmaInefectiva.class, ()-> arma.atacarA(soldado,1));

        assertEquals(100,soldado.getVida());
    }



    @Test
    void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        arma = new ArmaArcoJinete();
        arma.atacarA(soldado,3);

        assertEquals(85,soldado.getVida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        arma = new ArmaArcoJinete();
        for(int i = 0;i<=7;i++){
            arma.atacarA(soldado,3);
        }

        assertEquals(0,soldado.getVida());
    }
}
