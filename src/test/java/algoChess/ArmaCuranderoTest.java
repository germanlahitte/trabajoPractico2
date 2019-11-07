package algoChess;

import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCuranderoTest {
    @Test
    public void curarDesdeUnaDistanciaCercanaDevuelveLaCuracionTest(){
        Equipo e1 = new Rojo();
        ArmaCurandero armaCurandero = new ArmaCurandero(15,0);
        Soldado soldado = new Soldado(e1);
        assertEquals(15,armaCurandero.atacar(soldado,2));

    }

}
