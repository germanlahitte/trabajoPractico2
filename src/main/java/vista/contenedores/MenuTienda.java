package vista.contenedores;

import controlador.buttonHandlers.HandlerBotonComprar;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.juego.Ronda;


public class MenuTienda extends VBox {

    public MenuTienda(Ronda ronda){

        this.setAlignment(Pos.CENTER);

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

        this.getChildren().addAll(botonComprarSoldado,botonComprarJinete,botonComprarCurandero,botonComprarCatapulta);

    }
}
