package algoChess.Equipos;

import algoChess.Piezas.Pieza;

public interface  Equipo { //2 implementaciones

    /*public boolean ubicar(Equipo bandoDelCasillero){
        return (bandoDelCasillero.getClass() == this.getClass());
    }*/

    /*
    public float bajoAtaque(Equipo bandoDelCasillero){
        float multiplicador = 1.0f;
        if(!this.ubicar(bandoDelCasillero)){
            multiplicador = 1.05f;
        }
        return multiplicador;
    }*/


    double  atacar(Equipo equipo);
    double  atacar(EquipoRojo equipo);
    double  atacar(EquipoAzul equipo);
    Pieza ubicarCon(Equipo equipo, Pieza pieza);
    Pieza ubicarCon(EquipoAzul equipo, Pieza pieza);
    Pieza ubicarCon(EquipoRojo equipo, Pieza pieza);
}
    /* Para Double Dispatch
    public interface Equipo {

        public float vs(Equipo unEquipo);
        public float vs(Azul equipoAzul);
        public float vs(Rojo equipoRojo);

        public boolean ubicar(Equipo unEquipo);
        public boolean ubicar(Azul equipoAzul);
        public boolean ubicar(Rojo equipoRojo);
    }*/
