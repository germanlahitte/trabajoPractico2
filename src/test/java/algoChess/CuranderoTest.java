package algoChess;

import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Curandero;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuranderoTest {

    @Test
    public void curanderoCuraSoldadoAliadoTest() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando);
        Casillero casillero1 = new Casillero(posicion1, bando);
        Casillero casillero2 = new Casillero(posicion2, bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        curandero.atacar(soldado);
        assertEquals(115, soldado.vidaRestante());
    }

    @Test
    public void curanderoNoCuraSoldadoAliadoPorEstarLejosTest() {
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(5, 5);
        Equipo bando = new Rojo();
        Curandero curandero = new Curandero(bando);
        Soldado soldado = new Soldado(bando);
        Casillero casillero1 = new Casillero(posicion1, bando);
        Casillero casillero2 = new Casillero(posicion2, bando);
        casillero1.ubicar(curandero);
        casillero2.ubicar(soldado);
        curandero.atacar(soldado);
        assertEquals(100, soldado.vidaRestante());

    }
}
