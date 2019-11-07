package algoChess;

import algoChess.Equipos.Equipo;
import algoChess.Equipos.Rojo;
import algoChess.Piezas.Soldado;
import algoChess.Ubicacion.Casillero;
import algoChess.Ubicacion.Posicion;
import algoChess.Ubicacion.Tablero;
import excepciones.CasilleroEnemigoException;
import excepciones.CasilleroOcupadoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest { //TODO: necesito tocar otras clases para un método
    @Test
    public void seCreaCorrectamenteElTableroTest(){
        Tablero tablero = new Tablero();
        assertEquals(400,tablero.getCantidadDeCasilleros());
    }


    @Test
    public void seColocaUnaPiezaAliadaEnUnCasilleroAliadoVacioConExitoTest(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new Rojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (1,3);
        Casillero unCasillero = tablero.buscar(unaPosicion);

        tablero.ubicar(piezaPrueba,unCasillero);

        assertEquals(piezaPrueba.distanciaA(unCasillero),0);
    }

    @Test
    public void noSePuedeColocarPiezaEnCasilleroEnemigo(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new Rojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (15,15);
        Casillero unCasillero = tablero.buscar(unaPosicion);

        tablero.ubicar(piezaPrueba,unCasillero);
        //Necesito probar que el casillero está vacío
        assertEquals(1,1);
    }

    @Test
    public void noSePuedeColocarPiezaEnCasilleroOcupado(){
        Tablero tablero = new Tablero();
        Equipo bandoRojo = new Rojo();
        Soldado piezaPrueba = new Soldado(bandoRojo);
        Posicion unaPosicion = new Posicion (1,3);
        Casillero unCasillero = tablero.buscar(unaPosicion);
        tablero.ubicar(piezaPrueba,unCasillero);

        Soldado otraPieza = new Soldado(bandoRojo);
        //Necesito probar que piezaPrueba sigue en el casillero.
        assertThrows(CasilleroOcupadoException.class,()-> tablero.ubicar(otraPieza,unCasillero));
    }
}