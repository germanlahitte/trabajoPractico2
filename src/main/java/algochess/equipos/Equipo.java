package algochess.equipos;

import algochess.piezas.Pieza;

public interface  Equipo {

    double  atacar(Equipo equipo);
    double  atacar(EquipoRojo equipo);
    double  atacar(EquipoAzul equipo);
    Pieza ubicarCon(Equipo equipo, Pieza pieza);
    Pieza ubicarCon(EquipoAzul equipo, Pieza pieza);
    Pieza ubicarCon(EquipoRojo equipo, Pieza pieza);
    void enlistarse(Equipo equipo, Pieza pieza1, Pieza pieza2);
    void enlistarse(EquipoAzul equipo, Pieza pieza1, Pieza pieza2);
    void enlistarse(EquipoRojo equipo, Pieza pieza1, Pieza pieza2);
    boolean soyAliado(Equipo equipo);
    boolean soyAliado(EquipoRojo equipo);
    boolean soyAliado(EquipoAzul equipo);
}

