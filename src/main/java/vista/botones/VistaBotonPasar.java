package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonPasar {

    static int BOTON_ANCHO = 210;
    static int BOTON_ALTO = 70;

    public VistaBotonPasar(Button botonPasar){
        botonPasar.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonPasar.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/pasar.png",
                botonPasar.getWidth(),botonPasar.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(botonPasar.getWidth(),
                botonPasar.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonPasar.setBackground(backGround);

    }
}
