package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonComprar;
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

    public MenuTienda(Ronda ronda, TableroView vistaTablero){

        this.setAlignment(Pos.CENTER_LEFT);
        this.setWidth(200);
        this.creditosText = new Text();
        this.creditosText.setStroke(Color.WHITE);
        this.ronda = ronda;

        this.ronda.addObserver(this);

        Button botonComprarSoldado = new Button("Comprar Soldado");
        botonComprarSoldado.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarSoldado = new HandlerBotonComprar(this, ronda,1, vistaTablero);
        botonComprarSoldado.setOnAction(eventoComprarSoldado);

        Button botonComprarJinete = new Button("Comprar Jinete");
        botonComprarJinete.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarJinete = new HandlerBotonComprar(this, ronda,2, vistaTablero);
        botonComprarJinete.setOnAction(eventoComprarJinete);

        Button botonComprarCurandero = new Button("Comprar Curandero");
        botonComprarCurandero.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarCurandero = new HandlerBotonComprar(this, ronda,3, vistaTablero);
        botonComprarCurandero.setOnAction(eventoComprarCurandero);

        Button botonComprarCatapulta = new Button("Comprar Catapulta");
        botonComprarCatapulta.setMinWidth(ConstantesDeAplicacion.getAnchoBotones());
        HandlerBotonComprar eventoComprarCatapulta = new HandlerBotonComprar(this, ronda,4, vistaTablero);
        botonComprarCatapulta.setOnAction(eventoComprarCatapulta);

        this.setSpacing(5);
        this.getChildren().addAll(this.creditosText,botonComprarSoldado,botonComprarJinete,botonComprarCurandero,botonComprarCatapulta);


    }

    @Override
    public void change() {
        if (this.ronda.puedenComprar()) {
            this.setVisible(true);
            this.creditosText.setText("Créditos disponibles: " + this.ronda.getJugadorActual().getCredito());
        }
    }
}
