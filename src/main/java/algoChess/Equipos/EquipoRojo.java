package algoChess.Equipos;

public class EquipoRojo implements Equipo {


    public double  atacar(Equipo equipo){
        return equipo.atacar(this);
    }

    public double  atacar(EquipoRojo equipo){
        return 1.00;
    }

    public double  atacar(EquipoAzul equipo){
        return 1.05;
    }
            /* Para Double Dispatch
        public float vs(Equipo unEquipo){
            return unEquipo.vs(this);
        }
        public float vs(Azul equipoAzul){
            return 1.05f
        }
        public float vs(Rojo equipoRojo){
            return 1.0f
        }

        public boolean ubicar(Equipo unEquipo){
            return unEquipo.ubicar(this);
        }
        public boolean ubicar(Azul equipoAzul){
            return false;
        }
        public boolean ubicar(Rojo equipoRojo){
            return true;
        }
    }*/
}
