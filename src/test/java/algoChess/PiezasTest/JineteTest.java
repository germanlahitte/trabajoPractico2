package algoChess.PiezasTest;

import algoChess.Equipos.EquipoAzul;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Jinete;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JineteTest {
    @Test
    public void jineteAtacaADistanciaLejanaYSeLeRestaLaVidaCorrespondienteTest(){
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(7,7);
        Equipo bando1 = new EquipoRojo();
        Equipo bando2 = new EquipoAzul();
        Jinete jinete = new Jinete(bando1);
        Soldado soldado = new Soldado(bando2);
        Casillero casillero1 = new Casillero(posicion1,bando1);
        Casillero casillero2 = new Casillero(posicion2,bando2);
        casillero1.ubicar(jinete);
        casillero2.ubicar(soldado);
        jinete.atacar(soldado);
        assertEquals(85,soldado.vida());

    }
}
