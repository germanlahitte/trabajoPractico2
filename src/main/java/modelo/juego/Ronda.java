package modelo.juego;

import java.util.ArrayList;
import java.util.Iterator;

public class Ronda {

    ArrayList<Jugador> jugadores;
    Iterator<Jugador> jugadorActual;

    public Ronda(){
        this.jugadores = new ArrayList<>();
        this.iniciarRonda();
    }

    public void agregar(Jugador esteJugador){
        this.jugadores.add(esteJugador);
    }

    public Jugador siguienteTurno(){
        return jugadorActual.next();
    }

    public void avanzar(){
        if(!this.jugadorActual.hasNext()){
            this.iniciarRonda();
        }
    }

    private void iniciarRonda(){
        this.jugadorActual = new Iterator<Jugador>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Jugador next() {
                return null;
            }
        };
    }

    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }

}
