package modelo.ubicacion.ocupacion;

import modelo.piezas.Pieza;
import modelo.ubicacion.Casillero;
import excepciones.CasilleroOcupadoException;

public class StrategyOcupado implements StrategyDisponibilidad {

    public void agregarPieza(Pieza pieza, Casillero casillero){
        throw new CasilleroOcupadoException("Casillero Ocupado");
    }

    public void quemar(int danio, Casillero casillero) {
        casillero.getPieza().quitarVida(danio);
        casillero.propagar(danio);
    }
}
