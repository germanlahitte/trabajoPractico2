package modelo.ArmasTest;

import excepciones.DistanciaArmaInefectiva;
import modelo.armas.Arma;
import modelo.armas.ArmaEspadaJinete;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertThrows(DistanciaArmaInefectiva.class, ()-> arma.atacarA(soldado,3));
        assertEquals(100,soldado.getVida());
    }

    @Test
    void testAtacarAPiezaADistanciaMenorDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(95,soldado.getVida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        for(int i = 0;i<=20;i++){
            arma.atacarA(soldado,1);
        }

        assertEquals(0,soldado.getVida());
    }
}
