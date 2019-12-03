package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;

public class HandlerBotonSalir implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        AudioClip salir = new AudioClip(Paths.get("src/main/java/vista/audio/exit.wav").toUri().toString());
        //salir.play();
        System.exit(0);
    }
}
