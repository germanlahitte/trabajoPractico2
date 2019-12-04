package modelo.juego;

import java.util.ArrayList;

public class Tienda extends Observable {

    private ArrayList<Jugador> clientes;

    public Tienda(Ronda clientes){
        this.clientes = new ArrayList<>(clientes.getJugadores());
    }

    public boolean estaCerrada(){
        return clientes.isEmpty();
    }

    public void venderSoldado(Jugador unJugador){
        if (clientes.contains(unJugador)){
            unJugador.comprarSoldado();
        }
        this.venta(unJugador);
    }

    public void venderJinete(Jugador unJugador){
        if (clientes.contains(unJugador)){
            unJugador.comprarJinete();
        }
        this.venta(unJugador);
    }

    public void venderCurandero(Jugador unJugador){
        if (clientes.contains(unJugador)){
            unJugador.comprarCurandero();
        }
        this.venta(unJugador);
    }

    public void venderCatapulta(Jugador unJugador){
        if (clientes.contains(unJugador)){
            unJugador.comprarCatapulta();
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
//        this.abierta = false;
//        for (Jugador unJugador:clientes){
//            abierta = (abierta || unJugador.tieneSaldo());
//        }
//        if(!estaAbierta()){
//            this.notifyObservers();
//        }
    }

}
