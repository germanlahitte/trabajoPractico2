package algoChess;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Posicion {
    private int horizontal;
    private int vertical;

    public Posicion(int posX, int posY) {
        this.horizontal = posX;
        this.vertical = posY;
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
