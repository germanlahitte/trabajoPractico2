package vista.contenedores;

import vista.ConstantesDeAplicacion;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonJugarView {
    static int BOTON_ANCHO = 250;
    static int BOTON_ALTO = 50;

    public BotonJugarView(){

    }

    public void setBotonJugarView(Button botonJugar){
        botonJugar.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
        botonJugar.setMinSize(BOTON_ANCHO, BOTON_ALTO);
        Image crearJuego = new Image("file:src/main/java/vista/imagenes/jugar.png",botonJugar.getWidth(),botonJugar.getHeight(),false, true, true);
        BackgroundImage bkgImgJuego = new BackgroundImage(crearJuego, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(botonJugar.getWidth(), botonJugar.getHeight(), true, true, true, false));
        Background bkgBotJuego = new Background(bkgImgJuego);
        botonJugar.setBackground(bkgBotJuego);
        botonJugar.setTranslateX(ConstantesDeAplicacion.getAnchoVentana() - BOTON_ANCHO);
        botonJugar.setTranslateY(ConstantesDeAplicacion.getAltoVentana() - BOTON_ALTO);


    }
}
