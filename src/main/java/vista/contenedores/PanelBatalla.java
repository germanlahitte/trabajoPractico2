package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonPasar;
import controlador.buttonHandlers.HandlerPrepararAtacar;
import controlador.buttonHandlers.HandlerPrepararMover;
import controlador.buttonHandlers.HandlerPrepararMoverBatallon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modelo.juego.Observer;
import modelo.juego.Ronda;
import modelo.piezas.Catapulta;
import modelo.piezas.Curandero;
import modelo.piezas.Pieza;
import modelo.piezas.Soldado;
import vista.ConstantesDeAplicacion;

public class PanelBatalla extends VBox implements Observer {

    private Ronda ronda;

    public PanelBatalla(Pieza pieza, TableroView vistaTablero, Ronda ronda, BorderPane ventana) {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setWidth(200);
        this.ronda = ronda;
        this.ronda.addObserver(this);
        this.setSpacing(5);

        Text vidaText = new Text("Vida " + pieza.getNombre() + ": " + pieza.getVida());
        vidaText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf", 12) );
        vidaText.setFill(Color.FIREBRICK);
        vidaText.setStroke(Color.WHITE);
        Text armaText = new Text("Arma: " + pieza.getArma().getNombre());
        armaText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf", 12) );
        armaText.setFill(Color.FIREBRICK);
        armaText.setStroke(Color.WHITE);
        this.getChildren().addAll(vidaText, armaText);

        if (pieza.getClass() != Catapulta.class) {
            Button botonMover = new Button("Mover");
            botonMover.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
            HandlerPrepararMover eventoMover = new HandlerPrepararMover(pieza, vistaTablero);
            botonMover.setOnAction(eventoMover);
            this.getChildren().add(botonMover);
        }

        if (pieza.getClass() == Soldado.class) {
            Button botonMoverBatallon = new Button("Mover Batallon");
            botonMoverBatallon.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
            HandlerPrepararMoverBatallon eventoMoverBatallon = new HandlerPrepararMoverBatallon(pieza, vistaTablero);
            botonMoverBatallon.setOnAction(eventoMoverBatallon);
            this.getChildren().add(botonMoverBatallon);
        }

        Button botonAtacar = new Button();
        if (pieza.getClass()== Curandero.class){
            botonAtacar.setText("Curar");
        } else {
            botonAtacar.setText("Atacar");
        }
        botonAtacar.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerPrepararAtacar eventoAtacar = new HandlerPrepararAtacar(pieza, vistaTablero, botonAtacar.getText());
        botonAtacar.setOnAction(eventoAtacar);
        this.getChildren().add(botonAtacar);


        Button botonPasar = new Button("Pasar");
        botonPasar.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonPasar eventoPasar = new HandlerBotonPasar(ronda);
        botonPasar.setOnAction(eventoPasar);
        this.getChildren().add(botonPasar);

    }

    @Override
    public void change() {
        this.setVisible(false);
    }
}
