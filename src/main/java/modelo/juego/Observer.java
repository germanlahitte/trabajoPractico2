package modelo.juego;

import modelo.piezas.Pieza;

public interface Observer {
    public void change();
    public void change(Pieza unaPieza);
}
