package algoChess;

import algoChess.Armas.ArmaJinete;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaJineteTest {
     @Test
    public void atacarDesdeUnaDistanciaCercanaDevuelveElDanioTest(){
         Equipo e1 = new Rojo();
         ArmaJinete armaJinete = new ArmaJinete(5,15);
         Soldado soldado = new Soldado(e1);
         assertEquals(5,armaJinete.atacar(soldado,2));
     }
    @Test
     public void atacarDesdeUnaDistanciaLejanaDevuelveElDanioADistanciaTest(){
         Equipo e1 = new Rojo();
         ArmaJinete armaJinete = new ArmaJinete(5,15);
         Soldado soldado = new Soldado(e1);
         assertEquals(15,armaJinete.atacar(soldado,25));
     }
}
