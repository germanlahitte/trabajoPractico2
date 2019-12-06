package vista.contenedores;

import modelo.juego.Juego;
import vista.ConstantesDeAplicacion;
import controlador.buttonHandlers.HandlerBotonComenzar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class PantallaInicial extends VBox {

    public PantallaInicial(Stage ventana, Juego partida){
        super();
        this.setSpacing(20);

        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png", ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana(), false, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        AudioClip audioInicio = new AudioClip(Paths.get("src/main/java/vista/audio/jingle2.wav").toUri().toString());
        audioInicio.play();

        Button botonComenzarElJuego = new Button();
        BotonComenzarView configurarBotonComenzar = new BotonComenzarView();
        configurarBotonComenzar.setBotonComenzarView(botonComenzarElJuego);


        this.setBackground(new Background(imagenDeFondo));
        this.getChildren().addAll(botonComenzarElJuego);


        PantallaDeJuego pantalla = new PantallaDeJuego(ventana, partida);
        Scene batallaView = new Escena(pantalla);

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana, partida, batallaView);
        Scene menuView = new Escena(menuPrincipal);

        PantallaFinal pantallaFinal = new PantallaFinal(ventana, partida, menuView);
        Scene finalView = new Escena(pantallaFinal);
        pantalla.setEscenaFinal(finalView);

        HandlerBotonComenzar eventoClickEnComenzar = new HandlerBotonComenzar(ventana, menuView);
        botonComenzarElJuego.setOnAction(eventoClickEnComenzar);

    }

}
