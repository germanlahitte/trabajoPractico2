package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.PanelBatalla;
import vista.contenedores.TableroView;

import java.nio.file.Paths;

public class HandlerRecibirAtaque implements EventHandler<ActionEvent> {
    private Ronda ronda;
    private Pieza piezaAtaca, piezaRecibe;


    public HandlerRecibirAtaque(Pieza piezaAtaca, Pieza piezaRecibe, Ronda ronda) {
        this.piezaAtaca = piezaAtaca;
        this.piezaRecibe = piezaRecibe;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            this.piezaAtaca.atacar(this.piezaRecibe);
            AudioClip audioAtaque = new AudioClip(Paths.get("src/main/java/vista/audio/ataque.wav").toUri().toString());
            audioAtaque.play();
            this.ronda.avanzar();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
