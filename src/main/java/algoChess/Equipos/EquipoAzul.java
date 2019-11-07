package algoChess.Equipos;

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

        /* Para Double Dispatch
        public float vs(Equipo unEquipo){
            return unEquipo.vs(this);
        }
        public float vs(Azul equipoAzul){
            return 1.0f
        }
        public float vs(Rojo equipoRojo){
            return 1.05f
        }

        public boolean ubicar(Equipo unEquipo){
            return unEquipo.ubicar(this);
        }
        public boolean ubicar(Azul equipoAzul){
            return true;
        }
        public boolean ubicar(Rojo equipoRojo){
            return false;
        }
    }*/

}
