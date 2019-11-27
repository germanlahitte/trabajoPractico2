package controlador.juego;

import modelo.Jugador;

import java.util.ArrayList;
import java.util.Iterator;

public class Ronda {

    ArrayList<Jugador> jugadores;
    Iterator<Jugador> deTurno;

    public Ronda(){
        this.jugadores = new ArrayList<>();
        this.iniciarRonda();
    }

    public void agregar(Jugador esteJugador){
        this.jugadores.add(esteJugador);
    }

    public Jugador siguienteTurno(){
        return deTurno.next();
    }

    public void avanzar(){
        if(!this.deTurno.hasNext()){
            this.iniciarRonda();
        }
    }

    private void iniciarRonda(){
        this.deTurno = new Iterator<Jugador>() {
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

}
