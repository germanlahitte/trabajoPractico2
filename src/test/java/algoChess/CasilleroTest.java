package algoChess;

import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Pieza;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.StrategyDisponibilidad.Disponibilidad;
import algoChess.Ubicacion.Posicion;
import org.junit.jupiter.api.Test;

class CasilleroTest {
    @Test
    public void testUbicarUbicaCorrectamente(){
        Equipo equipo = new Rojo();
        Posicion posicion = new Posicion(1,1);
        Casillero casillero = new Casillero(posicion,equipo);
        Pieza soldado = new Soldado(equipo);
        casillero.ubicar(soldado);
        Disponibilidad ocupado;

    }

}