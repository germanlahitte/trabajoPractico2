package controlador.buttonHandlers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.juego.Ronda;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.equipos.Equipo;
import modelo.ubicacion.Tablero;


public class HandlerBotonCrear implements EventHandler<ActionEvent> {

    Equipo bando;
    String nombre;
    Ronda listaDeJugadores;
    Tablero tablero;
    
    public HandlerBotonCrear(TextField nombre, Equipo bando, Juego batalla){
        this.bando = bando;
        this.nombre = nombre.getText();
        this.listaDeJugadores = batalla.getRonda();
        this.tablero = batalla.getTablero();
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador = new Jugador(nombre,bando);
        listaDeJugadores.agregar(jugador);
    }

}
