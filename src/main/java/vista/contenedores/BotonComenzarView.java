package vista.contenedores;

import controlador.ConstantesDeAplicacion;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonComenzarView {
    static int anchoBotonComenzar = 287;
    static int altoBotonComenzar = 41;

    public BotonComenzarView(){

    }

    public void setBotonComenzarView(Button botonComenzarElJuego){
        botonComenzarElJuego.setMaxSize(anchoBotonComenzar, altoBotonComenzar);
        botonComenzarElJuego.setMinSize(anchoBotonComenzar, altoBotonComenzar);
        botonComenzarElJuego.setTranslateX(ConstantesDeAplicacion.getAnchoVentana() - anchoBotonComenzar);
        botonComenzarElJuego.setTranslateY(ConstantesDeAplicacion.getAltoVentana() - altoBotonComenzar);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/comenzar.png",botonComenzarElJuego.getWidth(),botonComenzarElJuego.getHeight(),false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(botonComenzarElJuego.getWidth(), botonComenzarElJuego.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonComenzarElJuego.setBackground(backGround);


    }
}
