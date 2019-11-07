package algoChess.ArmasTest;

import algoChess.Armas.ArmaCatapulta;
import algoChess.Equipos.Equipo;
import algoChess.Equipos.EquipoRojo;
import algoChess.Piezas.Soldado;
import org.junit.jupiter.api.Test;
;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmaCatapultaTest {
    @Test
    public void atacarDesdeUnaDistanciaLejanaDevuelveElDanioADistanciaTest(){
        Equipo e1 = new EquipoRojo();
        ArmaCatapulta armaCatapulta = new ArmaCatapulta(0,15);
        Soldado soldado = new Soldado(e1);
        assertEquals(15,armaCatapulta.atacarA(soldado,7));

    }

    @Test
    public void atacarDesdeUnaDistanciaLejanaNoDevuelveNingunDanioTest(){
        Equipo e1 = new EquipoRojo();
        ArmaCatapulta armaCatapulta = new ArmaCatapulta(0,15);
        Soldado soldado = new Soldado(e1);
        assertEquals(0,armaCatapulta.atacarA(soldado,2));


    }
}
