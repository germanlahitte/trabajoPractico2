package controlador.buttonHandlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.juego.Juego;
import vista.contenedores.Escena;
import vista.contenedores.MenuPrincipal;

public class HandlerVolverAJugar implements EventHandler<ActionEvent> {

    private Scene menuPricipal;
    private Juego partida;
    private Stage ventana;

    public HandlerVolverAJugar(Stage ventana, Juego partida, Scene menuPrincipal) {
        this.ventana = ventana;
        this.partida = partida;
        this.menuPricipal = menuPrincipal;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
