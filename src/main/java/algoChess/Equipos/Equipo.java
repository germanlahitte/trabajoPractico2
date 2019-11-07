package algoChess.Equipos;

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
