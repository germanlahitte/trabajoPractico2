package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonComprar;
import controlador.buttonHandlers.HandlerBotonPasar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modelo.juego.Observer;
import modelo.juego.Ronda;
import vista.ConstantesDeAplicacion;
import vista.botones.VistaBotonComprarCatapulta;
import vista.botones.VistaBotonComprarCurandero;
import vista.botones.VistaBotonComprarJinete;
import vista.botones.VistaBotonComprarSoldado;


public class MenuTienda extends VBox implements Observer {

    Text creditosText;
    Ronda ronda;
    Button botonComprarSoldado;
    Button botonComprarJinete;
    Button botonComprarCurandero;
    Button botonComprarCatapulta;

    public MenuTienda(Ronda ronda, TableroView vistaTablero){

        this.setAlignment(Pos.CENTER);
        this.setWidth(200);
        this.setSpacing(5);
        this.creditosText = new Text();
        this.creditosText.setFont(Font.loadFont("file:src/main/java/vista/imagenes/fuente.ttf", 11));
        this.creditosText.setFill(Color.FIREBRICK);
        this.creditosText.setStroke(Color.WHITE);
        this.ronda = ronda;

        this.ronda.addObserver(this);

        this.getChildren().add(this.creditosText);

        this.botonComprarSoldado = new Button(/*"Comprar Soldado"*/);
        this.botonComprarSoldado.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        VistaBotonComprarSoldado vistaBotonComprarSoldado = new VistaBotonComprarSoldado(botonComprarSoldado);
        HandlerBotonComprar eventoComprarSoldado = new HandlerBotonComprar(this, ronda, 1, vistaTablero);
        this.botonComprarSoldado.setOnAction(eventoComprarSoldado);

        this.botonComprarJinete = new Button(/*"Comprar Jinete"*/);
        this.botonComprarJinete.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        VistaBotonComprarJinete vistaBotonComprarJinete = new VistaBotonComprarJinete(botonComprarJinete);
        HandlerBotonComprar eventoComprarJinete = new HandlerBotonComprar(this, ronda, 2, vistaTablero);
        this.botonComprarJinete.setOnAction(eventoComprarJinete);

        this.botonComprarCurandero = new Button(/*"Comprar Curandero"*/);
        this.botonComprarCurandero.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        VistaBotonComprarCurandero vistaBotonComprarCurandero=new VistaBotonComprarCurandero(botonComprarCurandero);
        HandlerBotonComprar eventoComprarCurandero = new HandlerBotonComprar(this, ronda, 3, vistaTablero);
        this.botonComprarCurandero.setOnAction(eventoComprarCurandero);

        this.botonComprarCatapulta = new Button(/*"Comprar Catapulta"*/);
        this.botonComprarCatapulta.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        VistaBotonComprarCatapulta vistaBotonComprarCatapulta = new VistaBotonComprarCatapulta(botonComprarCatapulta);
        HandlerBotonComprar eventoComprarCatapulta = new HandlerBotonComprar(this, ronda, 4, vistaTablero);
        this.botonComprarCatapulta.setOnAction(eventoComprarCatapulta);
        this.getChildren().addAll(this.botonComprarSoldado,this.botonComprarJinete,this.botonComprarCurandero,this.botonComprarCatapulta);

    }

    @Override
    public void change() {
        if (this.ronda.puedenComprar()) {
            if (!this.ronda.getJugadorActual().tieneSaldo()) {
                this.ronda.avanzar();
            }
            this.setVisible(true);
            this.creditosText.setText("Créditos disponibles: " + this.ronda.getJugadorActual().getCredito());
        }
    }
}
