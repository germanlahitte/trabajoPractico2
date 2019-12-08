package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import vista.contenedores.MenuTienda;
import vista.contenedores.TableroView;

import java.nio.file.Paths;

public class HandlerBotonComprar implements EventHandler<ActionEvent> {

    private Ronda ronda;
    private TableroView tableroView;
    private int pieza;
    private MenuTienda ventana;


    public HandlerBotonComprar(MenuTienda menuTienda, Ronda ronda, int pieza, TableroView vistaTablero) {
        this.ventana = menuTienda;
        this.ronda = ronda;
        this.tableroView = vistaTablero;
        this.pieza = pieza;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Pieza newPieza;
            switch (this.pieza) {
                case 1:
                    newPieza = this.ronda.getJugadorActual().comprarSoldado();
                    AudioClip soldadoSfx = new AudioClip(Paths.get("src/main/java/vista/audio/soldado.wav").toUri().toString());
                    soldadoSfx.play();
                    break;
                case 2:
                    newPieza = this.ronda.getJugadorActual().comprarJinete();
                    AudioClip jineteSfx = new AudioClip(Paths.get("src/main/java/vista/audio/crearJinete.wav").toUri().toString());
                    jineteSfx.play();
                    break;
                case 3:
                    newPieza = this.ronda.getJugadorActual().comprarCurandero();
                    AudioClip healerSfx = new AudioClip(Paths.get("src/main/java/vista/audio/crearCurandero.wav").toUri().toString());
                    healerSfx.play();
                    break;
                case 4:
                    newPieza = this.ronda.getJugadorActual().comprarCatapulta();
                    AudioClip trebuSfx = new AudioClip(Paths.get("src/main/java/vista/audio/catapulta.wav").toUri().toString());
                    trebuSfx.play();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + this.pieza);
            }
            this.tableroView.prepararUbicar(newPieza, this.ronda);
            this.ventana.setVisible(false);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            AudioClip sinMonedasSfx = new AudioClip(Paths.get("src/main/java/vista/audio/noMoney.wav").toUri().toString());
            sinMonedasSfx.play();
            if (!this.ronda.getJugadorActual().tieneSaldo()) {
                this.ronda.avanzar();
            }
        }
    }
}
