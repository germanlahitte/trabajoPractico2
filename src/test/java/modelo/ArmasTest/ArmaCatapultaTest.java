package modelo.ArmasTest;

import excepciones.DistanciaArmaInefectiva;
import modelo.armas.Arma;
import modelo.armas.ArmaCatapulta;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArmaCatapultaTest {

    private Pieza soldado;
    private Tablero tablero;
    private Arma arma;

    @BeforeEach
    void executedBeforeEach() {
        tablero = new Tablero();
        Posicion posicionRojo = new Posicion(10,10); // Posicion de equipo rojo.

        soldado = new Soldado(new EquipoRojo());
        tablero.ubicar(soldado, posicionRojo);
        arma = new ArmaCatapulta();
    }


    // Atacar Piezas
    @Test
    void testAtacarAPiezaADistanciaMenorNoDisminuyeVida(){

        assertThrows(DistanciaArmaInefectiva.class, ()-> arma.atacarA(soldado,1));
        assertEquals(100,soldado.getVida());
    }

    @Test
    void testAtacarAPiezaADistanciaMayorDisminuyeVida(){
        arma.atacarA(soldado,6);
        assertEquals(80,soldado.getVida());
    }

    @Test
    void testAtacarAPiezaADistanciaCorrectaNoDisminuyeVidaMenorACero(){
        for(int i =0;i<=8;i++){
            arma.atacarA(soldado,6);
        }
        assertEquals(0,soldado.getVida());
    }

    @Test
    void testPropagarDanio(){
        Soldado soldadoRojo = new Soldado (new EquipoRojo());
        Posicion posicionRojo = new Posicion(11,10); // Posicion de equipo rojo.
        Soldado soldadoAzul = new Soldado(new EquipoAzul());
        Posicion posicionAzul = new Posicion(11,11);
        tablero.ubicar(soldadoRojo,posicionRojo);
        tablero.ubicar(soldadoAzul,posicionAzul);
        arma.atacarA(soldado,7);

        assertEquals(80,soldado.getVida());
        assertEquals(80,soldadoAzul.getVida());
        assertEquals(80,soldadoRojo.getVida());
    }

    @Test
    void testNoPropagaDanioEnLosLimitesDelTablero(){
        Soldado soldadoRojo1 = new Soldado (new EquipoRojo());
        Posicion posicionRojo1 = new Posicion(1,1); // Posicion de equipo rojo.
        Soldado soldadoRojo2 = new Soldado(new EquipoRojo());
        Posicion posicionRojo2 = new Posicion(1,2);
        Soldado soldadoRojo3 = new Soldado(new EquipoRojo());
        Posicion posicionRojo3 = new Posicion(1,3);
        Soldado soldadoRojo4 = new Soldado(new EquipoRojo());
        Posicion posicionRojo4 = new Posicion(1,4);
        Soldado soldadoRojo5 = new Soldado(new EquipoRojo());
        Posicion posicionRojo5 = new Posicion(1,5);


        tablero.ubicar(soldadoRojo1,posicionRojo1);
        tablero.ubicar(soldadoRojo2,posicionRojo2);
        tablero.ubicar(soldadoRojo3,posicionRojo3);
        tablero.ubicar(soldadoRojo4,posicionRojo4);
        tablero.ubicar(soldadoRojo5,posicionRojo5);

        arma.atacarA(soldadoRojo1,7);

        assertEquals(80,soldadoRojo1.getVida());
        assertEquals(80,soldadoRojo2.getVida());
        assertEquals(80,soldadoRojo3.getVida());
        assertEquals(80,soldadoRojo4.getVida());
        assertEquals(80,soldadoRojo5.getVida());
    }

}
