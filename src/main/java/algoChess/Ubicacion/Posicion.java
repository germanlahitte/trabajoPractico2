package algoChess.Ubicacion;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Posicion {
    private final int horizontal;
    private final int vertical;

    public Posicion(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public Posicion siguiente(Direccion enDireccion) {
        return (enDireccion.proximaPosicion(this));
    }

    public int distanciaA(Posicion otraPosicion){
        int distanciaEnX=abs(this.horizontal - otraPosicion.horizontal);
        int distanciaEnY=abs(this.vertical - otraPosicion.vertical);
        return max(distanciaEnX,distanciaEnY);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Posicion other = (Posicion) obj;

        return (this.getHorizontal() == other.getHorizontal() && this.getVertical() == other.getVertical());
    }

    @Override
    public int hashCode() {
        return this.getHorizontal()+this.getVertical();
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }
}
