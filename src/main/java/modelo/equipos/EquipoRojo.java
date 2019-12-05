package modelo.equipos;

import modelo.ProveedorConstantes;
import modelo.piezas.Pieza;
import excepciones.CasilleroEnemigoException;

import java.util.ArrayList;

public class EquipoRojo implements Equipo {

    private static String nombre = "Rojo";

    public String getNombre() {
        return ProveedorConstantes.nombreEquipoA();
    }

    public double  atacar(Equipo equipo){
        return equipo.atacar(this);
    }
    public double  atacar(EquipoRojo equipo){
        return 1.00;
    }
    public double  atacar(EquipoAzul equipo){
        return 1.05;
    }

    public Pieza ubicarCon(Equipo equipo, Pieza pieza){
        return equipo.ubicarCon(this,pieza);
    }
    public Pieza ubicarCon(EquipoRojo equipo, Pieza pieza){ return pieza;}
    public Pieza ubicarCon(EquipoAzul equipo, Pieza pieza){
        throw new CasilleroEnemigoException("Casillero diferente equipo");
    }

    public void enlistarse(Equipo equipo, Pieza pieza1, Pieza pieza2) { enlistarse(this, pieza1, pieza2); }
    public void enlistarse(EquipoAzul equipo, Pieza pieza1, Pieza pieza2) { }
    public void enlistarse(EquipoRojo equipo, Pieza pieza1, Pieza pieza2) { pieza1.enlistar(pieza2); }

    @Override
    public void soyAliado(Equipo equipo, ArrayList<Pieza> aliadas, ArrayList<Pieza> enemigas,Pieza pieza) {
        equipo.soyAliado(this,aliadas,enemigas,pieza);
    }

    @Override
    public void soyAliado(EquipoRojo equipo, ArrayList<Pieza> aliadas, ArrayList<Pieza> enemigas,Pieza pieza) {
        aliadas.add(pieza);
    }

    @Override
    public void soyAliado(EquipoAzul equipo, ArrayList<Pieza> aliadas, ArrayList<Pieza> enemigas,Pieza pieza) {
        enemigas.add(pieza);
    }

    public boolean soyAliado(Equipo equipo){
        return equipo.soyAliado(this);
    }
    public boolean soyAliado(EquipoRojo equipo){
        return true;
    }
    public boolean soyAliado(EquipoAzul equipo){
        return false;
    }
}
