package modelo.ArmasTest;

import excepciones.DistanciaArmaInefectiva;
import modelo.armas.Arma;
import modelo.armas.ArmaSoldado;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArmaSoldadoTest {
    private Pieza soldado;
    private Arma arma;

    @BeforeEach
    void init() {
        Tablero tablero = new Tablero();
        Posicion posicionRojo = new Posicion(1,1); // Posicion de equipo rojo.
        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado,posicionRojo);
        arma = new ArmaSoldado();
    }

     @Test
     void testAtacarAPiezaADistanciaMayorNoDisminuyeVida(){
         assertThrows(DistanciaArmaInefectiva.class, ()-> arma.atacarA(soldado,3));
         assertEquals(100,soldado.getVida());
     }

    @Test
    void testAtacarAPiezaADistanciaCorrectaDisminuyeVida(){
        arma.atacarA(soldado,1);
        assertEquals(90,soldado.getVida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        for(int i =0;i<=13;i++){
            arma.atacarA(soldado,1);
        }

        assertEquals(0,soldado.getVida());
    }
}
