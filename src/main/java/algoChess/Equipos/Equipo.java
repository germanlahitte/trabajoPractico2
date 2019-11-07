package algoChess.Equipos;

import algoChess.Piezas.Pieza;

public interface  Equipo { //2 implementaciones


    double  atacar(Equipo equipo);
    double  atacar(EquipoRojo equipo);
    double  atacar(EquipoAzul equipo);
    Pieza ubicarCon(Equipo equipo, Pieza pieza);
    Pieza ubicarCon(EquipoAzul equipo, Pieza pieza);
    Pieza ubicarCon(EquipoRojo equipo, Pieza pieza);
}

