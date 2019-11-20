package algochess.ubicacion.ocupacion;

import algochess.piezas.Pieza;
import algochess.ubicacion.Casillero;
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
