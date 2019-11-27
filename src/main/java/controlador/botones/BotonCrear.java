package controlador.botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import controlador.juego.Ronda;
import controlador.juego.Juego;
import modelo.Jugador;
import modelo.equipos.Equipo;
import modelo.ubicacion.Tablero;


public class BotonCrear implements EventHandler<ActionEvent> {

    Equipo bando;
    String nombre;
    Ronda listaDeJugadores;
    Tablero tablero;
    
    public BotonCrear(TextField nombre, Equipo bando, Juego batalla){
        this.bando = bando;
        this.nombre = nombre.getText();
        this.listaDeJugadores = batalla.getRonda();
        this.tablero = batalla.getTablero();
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador = new Jugador(nombre,bando,tablero);
        lista.agregar(jugador);
    }

}
