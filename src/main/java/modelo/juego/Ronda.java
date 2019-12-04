package modelo.juego;

import java.util.ArrayList;
import java.util.Random;

public class Ronda extends Observable {

    private static int CANTIDAD_DE_JUGADORES = 2;
    private ArrayList<Jugador> jugadores;
    private Jugador jugadorActual;

    public Ronda(){
        this.jugadores = new ArrayList<>();
    }

    public void agregar(Jugador esteJugador){
        this.jugadores.add(esteJugador);
    }

    public Jugador getJugadorActual(){
        return jugadorActual;
    }

    public void iniciarRonda(){
        this.setJugadorActual(this.tirarDado());
        this.notifyObservers();
    }

    public void avanzar(){
        int indiceActual=jugadores.indexOf(jugadorActual);
        int indiceSiguiente=indiceActual+1;
        if(indiceSiguiente==CANTIDAD_DE_JUGADORES){
            indiceSiguiente=0;
        }
        this.setJugadorActual(indiceSiguiente);
        this.notifyObservers();
    }

    private int tirarDado(){
        Random numeroAleatorio = new Random();
        int indiceAleatorio = numeroAleatorio.nextInt(CANTIDAD_DE_JUGADORES);
        return indiceAleatorio;
    }

    private void setJugadorActual(int indiceSiguiente) {
        jugadorActual = jugadores.get(indiceSiguiente);
    }

    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }

}