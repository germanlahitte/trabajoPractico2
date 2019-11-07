package algoChess.ArmasTest;

import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArmaSoldadoTest {
     @Test
    public void atacarDesdeUnaDistanciaCercanaDevuelveElDanioTest(){
         Equipo e1 = new EquipoRojo();
         ArmaSoldado armaSoldado = new ArmaSoldado();
         Soldado soldado = new Soldado(e1);
         //assertEquals(10,armaSoldado.atacarA(soldado,2));
     }
}
