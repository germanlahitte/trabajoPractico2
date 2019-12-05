package modelo.juego;

import java.util.ArrayList;

public class Tienda extends Observable {

    private ArrayList<Jugador> clientes;

    public Tienda() { }

    public void abrirTienda(Ronda ronda) {
        this.clientes = new ArrayList<>(ronda.getJugadores());
    }

    public boolean estaCerrada(){
        return clientes.isEmpty();
    }

    public void venderSoldado(Jugador unJugador){
        if (clientes.contains(unJugador)){
            this.notifyObservers(unJugador.comprarSoldado());
        }
        this.venta(unJugador);
    }

    public void venderJinete(Jugador unJugador){
        if (clientes.contains(unJugador)){
            this.notifyObservers(unJugador.comprarJinete());
        }
        this.venta(unJugador);
    }

    public void venderCurandero(Jugador unJugador){
        if (clientes.contains(unJugador)){
            this.notifyObservers(unJugador.comprarCurandero());
        }
        this.venta(unJugador);
    }

    public void venderCatapulta(Jugador unJugador){
        if (clientes.contains(unJugador)){
            this.notifyObservers(unJugador.comprarCatapulta());
        }
        this.venta(unJugador);
    }

    public void venta(Jugador unJugador){
        if(!unJugador.tieneSaldo()){
            clientes.remove(unJugador);
        }
        if(estaCerrada()) {
            this.notifyObservers();
        }
    }

}
