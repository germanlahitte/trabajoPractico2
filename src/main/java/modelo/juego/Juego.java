package modelo.juego;

import modelo.ubicacion.Tablero;

public class Juego {

    Tablero campoDeJuego;
    Tienda tienda;
    Ronda ronda;
    Jugador jugadorActivo;

    public Juego(){
        this.ronda = new Ronda();
        this.campoDeJuego = new Tablero();
    }

    public void agregar(Jugador esteJugador) {
        this.ronda.agregar(esteJugador);
    }

    public Jugador getJugadorActual(){
        return this.ronda.getJugadorActual();
    }

    public void comprar(){
        Tienda tienda = new Tienda(ronda);
        while(tienda.estaAbierta()) {
            this.jugadorActivo = this.getJugadorActual();
            jugadorActivo.comprar(tienda);
            this.ronda.avanzar();
        }

    }

    public void jugar(){
        Jugador jugadorActual = this.getJugadorActual();
        /*
        Acá pasa algo
         */
        this.ronda.avanzar();
    }

    public Ronda getRonda(){
        return this.ronda;
    }

    public Tablero getTablero(){
        return this.campoDeJuego;
    }

}