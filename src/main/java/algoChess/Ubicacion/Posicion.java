package algoChess.Ubicacion;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Posicion {
    private int horizontal;
    private int vertical;

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

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }
}
