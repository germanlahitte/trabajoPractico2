package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonComprar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.juego.Observer;
import modelo.juego.Ronda;


public class MenuTienda extends VBox implements Observer {

    Text creditosText;
    Ronda ronda;

    public MenuTienda(Ronda ronda){

        this.setAlignment(Pos.CENTER_LEFT);
        this.creditosText = new Text();
        this.ronda = ronda;

        this.ronda.addObserver(this);

        Button botonComprarSoldado = new Button("Comprar Soldado");
        HandlerBotonComprar eventoComprarSoldado = new HandlerBotonComprar(ronda,1);
        botonComprarSoldado.setOnAction(eventoComprarSoldado);

        Button botonComprarJinete = new Button("Comprar Jinete");
        HandlerBotonComprar eventoComprarJinete = new HandlerBotonComprar(ronda,2);
        botonComprarJinete.setOnAction(eventoComprarJinete);

        Button botonComprarCurandero = new Button("Comprar Curandero");
        HandlerBotonComprar eventoComprarCurandero = new HandlerBotonComprar(ronda,3);
        botonComprarCurandero.setOnAction(eventoComprarCurandero);

        Button botonComprarCatapulta = new Button("Comprar Catapulta");
        HandlerBotonComprar eventoComprarCatapulta = new HandlerBotonComprar(ronda,4);
        botonComprarCatapulta.setOnAction(eventoComprarCatapulta);

        this.setSpacing(5);
        this.getChildren().addAll(this.creditosText,botonComprarSoldado,botonComprarJinete,botonComprarCurandero,botonComprarCatapulta);

    }

    @Override
    public void change() {
        this.creditosText.setText("Créditos disponibles: " + this.ronda.getJugadorActual().getCredito());
    }
}
