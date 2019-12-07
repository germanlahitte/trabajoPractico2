package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonCurar {

    static int BOTON_ANCHO = 210;
    static int BOTON_ALTO = 70;

    public VistaBotonCurar(Button botonCurar){
        botonCurar.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonCurar.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/curar.png",
                botonCurar.getWidth(),botonCurar.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(botonCurar.getWidth(),
                botonCurar.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonCurar.setBackground(backGround);

    }
}
