package vista.contenedores;

import controlador.ConstantesDeAplicacion;
import controlador.botones.HandlerBotonAvanzar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import vista.botones.VistaBotonComenzar;

import java.nio.file.Paths;

public class PantallaInicial extends VBox {

    public PantallaInicial(Stage ventana, Scene menu){
        super();
        this.setSpacing(20);

        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png",
                                ConstantesDeAplicacion.getAnchoVentana(),
                                ConstantesDeAplicacion.getAltoVentana(),
                             false, true, true);

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                                                            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                                                            BackgroundSize.DEFAULT);

        AudioClip audioInicio = new AudioClip(Paths.get("src/main/java/vista/audio/jingle2.wav").toUri().toString());
        audioInicio.play();

        Button botonComenzarElJuego = new Button();
        VistaBotonComenzar vistaBotonComenzar = new VistaBotonComenzar(botonComenzarElJuego);

        this.setBackground(new Background(imagenDeFondo));
        this.getChildren().addAll(botonComenzarElJuego);

        HandlerBotonAvanzar eventoClickEnComenzar = new HandlerBotonAvanzar(ventana, menu);
        botonComenzarElJuego.setOnAction(eventoClickEnComenzar);

    }

}
