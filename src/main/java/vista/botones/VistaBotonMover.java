package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonMover {

    static int BOTON_ANCHO = 210;
    static int BOTON_ALTO = 70;

    public VistaBotonMover(Button botonMover){
        botonMover.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonMover.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/mover.png",
                botonMover.getWidth(),botonMover.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(botonMover.getWidth(),
                botonMover.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonMover.setBackground(backGround);

    }
}
