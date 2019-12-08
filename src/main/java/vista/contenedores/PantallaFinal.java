package vista.contenedores;

import controlador.buttonHandlers.HandlerVolverAJugar;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.juego.Juego;
import vista.ConstantesDeAplicacion;


public class PantallaFinal extends VBox {
    public PantallaFinal(Stage ventana, Juego partida, Scene menuPrincipal) {
        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png", ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana(), false, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        Button jugarDeNuevo = new Button("Jugar de nuevo");
        jugarDeNuevo.setAlignment(Pos.CENTER);
        jugarDeNuevo.setTranslateX(ConstantesDeAplicacion.getAnchoVentana()/2);
        jugarDeNuevo.setTranslateY(ConstantesDeAplicacion.getAltoVentana()/2);
        HandlerVolverAJugar eventoVolverAJugar = new HandlerVolverAJugar(ventana, partida, menuPrincipal);
        jugarDeNuevo.setOnAction(eventoVolverAJugar);
        this.getChildren().add(jugarDeNuevo);
    }
}
