package modelo.juego;

import modelo.ubicacion.Tablero;

public class Juego {

    Tablero campoDeJuego;
    Ronda ronda;

    public Juego(){
        this.ronda = new Ronda();
        this.campoDeJuego = new Tablero();
    }

    public void agregar(Jugador esteJugador) {
        this.ronda.agregar(esteJugador);
    }
    
    public Ronda getRonda(){
        return this.ronda;
    }
    
    public Tablero getTablero(){
        return this.campoDeJuego;
    }    

}
