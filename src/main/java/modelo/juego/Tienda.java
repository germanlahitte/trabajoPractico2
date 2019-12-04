package modelo.juego;

import java.util.ArrayList;

public class Tienda extends Observable {

    private boolean abierta;
    private ArrayList<Jugador> clientes;

    public Tienda(Ronda clientes){
        this.clientes = clientes.getJugadores();
        this.venta();
    }

    public boolean estaAbierta(){
        return abierta;
    }

    public void venta(){
        this.abierta = false;
        for (Jugador unJugador:clientes){
            abierta = (abierta || unJugador.tieneSaldo());
        }
        this.notifyObservers();
    }

}
