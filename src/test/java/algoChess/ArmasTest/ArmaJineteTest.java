package algoChess.ArmasTest;

import algoChess.Armas.EspadaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaJineteTest {
     @Test
    public void atacarDesdeUnaDistanciaCercanaDevuelveElDanioTest(){
         Equipo e1 = new EquipoRojo();
         EspadaJinete armaJinete = new EspadaJinete();
         Soldado soldado = new Soldado(e1);
         //assertEquals(5,armaJinete.atacarA(soldado,2));
     }
    @Test
     public void atacarDesdeUnaDistanciaLejanaDevuelveElDanioADistanciaTest(){
         Equipo e1 = new EquipoRojo();
         EspadaJinete armaJinete = new EspadaJinete();
         Soldado soldado = new Soldado(e1);
         //assertEquals(15,armaJinete.atacarA(soldado,25));
     }
}
