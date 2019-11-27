package controlador.botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.Jugador;
import modelo.equipos.Equipo;

import java.util.ArrayList;

public class BotonCrear implements EventHandler<ActionEvent> {

    Equipo bando;
    String nombre;
    ArrayList<Jugador> lista;

    public BotonCrear(TextField nombre, Equipo bando, ArrayList<Jugador> lista){
        this.bando = bando;
        this.nombre = nombre.getText();
        this.lista = lista;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador = new Jugador(nombre,bando);
        lista.add(jugador);
    }

}
