package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonComprar;
import controlador.buttonHandlers.HandlerBotonPasar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.juego.Observer;
import modelo.juego.Ronda;
import vista.ConstantesDeAplicacion;


public class MenuTienda extends VBox implements Observer {

    Text creditosText;
    Ronda ronda;
    Button botonComprarSoldado;
    Button botonComprarJinete;
    Button botonComprarCurandero;
    Button botonComprarCatapulta;
    Button botonPasar;

    public MenuTienda(Ronda ronda, TableroView vistaTablero){

        this.setAlignment(Pos.CENTER_LEFT);
        this.setWidth(200);
        this.setSpacing(5);
        this.creditosText = new Text();
        this.creditosText.setStroke(Color.WHITE);
        this.ronda = ronda;

        this.ronda.addObserver(this);

        this.getChildren().add(this.creditosText);

        this.botonComprarSoldado = new Button("Comprar Soldado");
        botonComprarSoldado.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarSoldado = new HandlerBotonComprar(this, ronda, 1, vistaTablero);
        botonComprarSoldado.setOnAction(eventoComprarSoldado);

        this.botonComprarJinete = new Button("Comprar Jinete");
        botonComprarJinete.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarJinete = new HandlerBotonComprar(this, ronda, 2, vistaTablero);
        botonComprarJinete.setOnAction(eventoComprarJinete);

        this.botonComprarCurandero = new Button("Comprar Curandero");
        botonComprarCurandero.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarCurandero = new HandlerBotonComprar(this, ronda, 3, vistaTablero);
        botonComprarCurandero.setOnAction(eventoComprarCurandero);

        this.botonComprarCatapulta = new Button("Comprar Catapulta");
        botonComprarCatapulta.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarCatapulta = new HandlerBotonComprar(this, ronda, 4, vistaTablero);
        botonComprarCatapulta.setOnAction(eventoComprarCatapulta);
        this.getChildren().addAll(botonComprarSoldado,botonComprarJinete,botonComprarCurandero,botonComprarCatapulta);

        this.botonPasar = new Button("Pasar");
        this.botonPasar.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonPasar eventoPasar = new HandlerBotonPasar(ronda);
        this.botonPasar.setOnAction(eventoPasar);



        this.getChildren().add(botonPasar);



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
