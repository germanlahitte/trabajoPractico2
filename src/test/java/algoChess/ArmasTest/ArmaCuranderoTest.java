package algoChess.ArmasTest;

import algoChess.Armas.ArmaCurandero;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCuranderoTest {
    @Test
    public void curarDesdeUnaDistanciaCercanaDevuelveLaCuracionTest(){
        Equipo e1 = new EquipoRojo();
        ArmaCurandero armaCurandero = new ArmaCurandero();
        Soldado soldado = new Soldado(e1);
        //assertEquals(15,armaCurandero.atacarA(soldado,2));

    }

}
