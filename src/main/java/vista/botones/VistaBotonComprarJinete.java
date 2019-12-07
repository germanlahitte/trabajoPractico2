package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonComprarJinete {

    static int BOTON_ANCHO = 300;
    static int BOTON_ALTO = 100;

    public VistaBotonComprarJinete(Button botonComenzarElJuego){
        botonComenzarElJuego.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonComenzarElJuego.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/jineteAzulSaluda.png",
                botonComenzarElJuego.getWidth(),botonComenzarElJuego.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(botonComenzarElJuego.getWidth(),
                botonComenzarElJuego.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonComenzarElJuego.setBackground(backGround);

    }
}
