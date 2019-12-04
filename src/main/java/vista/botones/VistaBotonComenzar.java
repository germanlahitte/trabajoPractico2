package vista.botones;

import controlador.ConstantesDeAplicacion;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonComenzar {

    static int BOTON_ANCHO = 287;
    static int BOTON_ALTO = 41;

    public VistaBotonComenzar(Button botonComenzarElJuego){
        botonComenzarElJuego.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonComenzarElJuego.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        botonComenzarElJuego.setTranslateX(ConstantesDeAplicacion.getAnchoVentana() - BOTON_ANCHO);
        botonComenzarElJuego.setTranslateY(ConstantesDeAplicacion.getAltoVentana() - BOTON_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/comenzar.png",
                                    botonComenzarElJuego.getWidth(),botonComenzarElJuego.getHeight(),
                                   false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                                    BackgroundPosition.CENTER, new BackgroundSize(botonComenzarElJuego.getWidth(),
                                                    botonComenzarElJuego.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonComenzarElJuego.setBackground(backGround);

    }
}
