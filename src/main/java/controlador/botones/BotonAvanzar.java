package controlador.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class BotonAvanzar implements EventHandler<ActionEvent> {

    Stage ventana;
    Scene proximaEscena;

    public BotonAvanzar(Stage ventana, Scene proximaEscena){
        this.ventana = ventana;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ventana.setScene(proximaEscena);
        ventana.setFullScreen(false);
        AudioClip jugar = new AudioClip(Paths.get("src/main/java/vista/audio/click.wav").toUri().toString());
        jugar.play();
    }
}

