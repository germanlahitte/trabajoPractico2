package modelo.PiezasTest;

import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;
import modelo.piezas.*;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CuranderoTest {

    @Test
    void testCuranderoSeCreaConVidaCorrecta() {
        Pieza pieza = new Curandero(new EquipoAzul());
        assertEquals(75, pieza.vida());
    }

    @Test
    void testCuranderoCura15DeVidaAOtraPiezaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Curandero curanderoRojo = new Curandero(new EquipoRojo());
        Pieza piezaRoja = new Soldado(new EquipoRojo());
        tablero.ubicar(curanderoRojo,posicion1);
        tablero.ubicar(piezaRoja,posicion2);

        piezaRoja.hacerseDanio(30);

        curanderoRojo.atacar(piezaRoja);
        assertEquals(85,piezaRoja.vida());
    }

    @Test
    void testCuranderoNoCuraACatapultaEnRango() {
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Curandero curandero = new Curandero(new EquipoRojo());
        Catapulta catapulta = new Catapulta(new EquipoRojo());
        tablero.ubicar(curandero,posicion1);
        tablero.ubicar(catapulta,posicion2);
        catapulta.hacerseDanio(20);

        curandero.atacar(catapulta);
        assertEquals(30,catapulta.vida());
    }

    @Test
    void testCuranderoNoCuraAUnEnemigo(){
        Tablero tablero = new Tablero();
        Posicion posicion1 = new Posicion(10,10);
        Posicion posicion2 = new Posicion(10,11);
        Curandero curanderoRojo = new Curandero(new EquipoRojo());
        Pieza piezaAzul = new Soldado(new EquipoAzul());
        tablero.ubicar(curanderoRojo,posicion1);
        tablero.ubicar(piezaAzul,posicion2);

        piezaAzul.hacerseDanio(70);

        curanderoRojo.atacar(piezaAzul);
        assertEquals(30,piezaAzul.vida());
    }
}
