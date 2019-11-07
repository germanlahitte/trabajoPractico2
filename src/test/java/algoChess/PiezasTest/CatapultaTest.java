package algoChess.PiezasTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Catapulta;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {
    @Test
    public void catapultaAtacaADistanciaCercanaASoldadoYNoSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,2);
        Equipo bando1 = new EquipoRojo();
        Equipo bando2 = new EquipoAzul();
        Catapulta catapulta = new Catapulta(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(catapulta);
        casillero2.ubicar(soldado);
        catapulta.atacar(soldado);
        assertEquals(100,soldado.vida());
    }

    @Test
    public void catapultaAtacaADistanciaLejanaASoldadoYSeLeRestaVidaTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(8,2);
        Equipo bando1 = new EquipoRojo();
        Equipo bando2 = new EquipoAzul();
        Catapulta catapulta = new Catapulta(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(catapulta);
        casillero2.ubicar(soldado);
        catapulta.atacar(soldado);
        assertEquals(80,soldado.vida());

    }
}
