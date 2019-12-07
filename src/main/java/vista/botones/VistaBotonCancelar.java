package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonCancelar {

    static int BOTON_ANCHO = 210;
    static int BOTON_ALTO = 70;

    public VistaBotonCancelar(Button botonCancelar){
        botonCancelar.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonCancelar.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/exit.png",
                botonCancelar.getWidth(),botonCancelar.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(botonCancelar.getWidth(),
                botonCancelar.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonCancelar.setBackground(backGround);

    }
}
