package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import modelo.armas.ArmaArcoJinete;
import modelo.armas.ArmaEspadaJinete;
import modelo.juego.Ronda;
import modelo.piezas.Catapulta;
import modelo.piezas.Curandero;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
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

                if(this.piezaAtaca.getClass()== Catapulta.class) {
                    audioAtaque = new AudioClip(Paths.get("src/main/java/vista/audio/catapulta.wav").toUri().toString());
                } else {
                    if(this.piezaAtaca.getClass()== Curandero.class) {
                        audioAtaque = new AudioClip(Paths.get("src/main/java/vista/audio/crearCurandero.wav").toUri().toString());
                    } else {
                        if(this.piezaAtaca.getArma().getClass() == ArmaArcoJinete.class){
                            audioAtaque = new AudioClip(Paths.get("src/main/java/vista/audio/flecha.wav").toUri().toString());
                        }
                    }

                }
            audioAtaque.play();
            this.ronda.avanzar();

        } catch (Exception e) {
            AudioClip audioJugar = new AudioClip(Paths.get("src/main/java/vista/audio/nonono.wav").toUri().toString());
            audioJugar.play();
            System.out.println(e.getMessage());
        }
    }
}
