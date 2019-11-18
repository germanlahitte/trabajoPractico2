package algochess.Equipos;

import algochess.Piezas.Pieza;
import excepciones.CasilleroEnemigoException;

public class EquipoAzul implements Equipo {

    public double atacar(Equipo equipo){
        return equipo.atacar(this);
    }
    public double atacar(EquipoRojo equipo){
        return 1.05;
    }
    public double atacar(EquipoAzul equipo){
        return 1.00;
    }

    public Pieza ubicarCon(Equipo equipo, Pieza pieza){
        return equipo.ubicarCon(this,pieza);
    }
    public Pieza ubicarCon(EquipoAzul equipo, Pieza pieza){
        return pieza;
    }
    public Pieza ubicarCon(EquipoRojo equipo, Pieza pieza){
        throw new CasilleroEnemigoException("Casillero diferente equipo");}

    public void enlistarse(Equipo equipo, Pieza pieza1, Pieza pieza2) { enlistarse(this, pieza1, pieza2); }
    public void enlistarse(EquipoAzul equipo, Pieza pieza1, Pieza pieza2) { pieza1.enlistar(pieza2); }
    public void enlistarse(EquipoRojo equipo, Pieza pieza1, Pieza pieza2) { }

}
