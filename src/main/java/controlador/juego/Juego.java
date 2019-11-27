package controlador.juego;

import modelo.Jugador;
import modelo.ubicacion.Tablero;

public class Juego {

    Tablero campoDeJuego;
    Ronda ronda;

    public Juego(){
        this.ronda = new Ronda();
        this.tablero = new Tablero();
    }

    public void agregar(Jugador esteJugador) {
        this.ronda.agregar(esteJugador);
    }

    public Jugador siguienteTurno(){
       return this.ronda.siguienteTurno();
    }

    public void jugar(){
        Jugador deTurno = this.siguienteTurno();
        /*
        Acá pasa algo
         */
        this.ronda.avanzar();
    }


}
