package vista.contenedores;

import vista.ConstantesDeAplicacion;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonComenzarView {
    static int BOTON_COMENZAR_ANCHO = 287;
    static int BOTON_COMENZAR_ALTO = 41;

    public BotonComenzarView(){

    }

    public void setBotonComenzarView(Button botonComenzarElJuego){
        botonComenzarElJuego.setMaxSize(BOTON_COMENZAR_ANCHO, BOTON_COMENZAR_ALTO);
        botonComenzarElJuego.setMinSize(BOTON_COMENZAR_ANCHO, BOTON_COMENZAR_ALTO);
        botonComenzarElJuego.setTranslateX(ConstantesDeAplicacion.getAnchoVentana() - BOTON_COMENZAR_ANCHO);
        botonComenzarElJuego.setTranslateY(ConstantesDeAplicacion.getAltoVentana() - BOTON_COMENZAR_ALTO);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/comenzar.png",botonComenzarElJuego.getWidth(),botonComenzarElJuego.getHeight(),false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(botonComenzarElJuego.getWidth(), botonComenzarElJuego.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonComenzarElJuego.setBackground(backGround);


    }
}
