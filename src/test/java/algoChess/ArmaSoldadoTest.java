package algoChess;

import algoChess.Armas.ArmaSoldado;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArmaSoldadoTest {
     @Test
    public void atacarDesdeUnaDistanciaCercanaDevuelveElDanioTest(){
         Equipo e1 = new Rojo();
         ArmaSoldado armaSoldado = new ArmaSoldado(10,0);
         Soldado soldado = new Soldado(e1);
         assertEquals(10,armaSoldado.atacar(soldado,2));
     }
}
