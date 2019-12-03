package vista.contenedores;

import vista.ConstantesDeAplicacion;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonSalirView {

    static int anchoBotonSalir =300;
    static int altoBotonSalir = 80;

    public BotonSalirView(){

    }
    public void setBotonSalirView(Button botonSalirDelJuego,int desplazamientoXBotonSalir,int desplazamientoYBotonSalir){
        botonSalirDelJuego.setMaxSize(anchoBotonSalir,altoBotonSalir);
        botonSalirDelJuego.setMinSize(anchoBotonSalir,altoBotonSalir);
        botonSalirDelJuego.setTranslateX(ConstantesDeAplicacion.getAnchoVentana() - desplazamientoXBotonSalir);
        botonSalirDelJuego.setTranslateY(ConstantesDeAplicacion.getAltoVentana() - desplazamientoYBotonSalir );
        Image salir = new Image("file:src/main/java/vista/imagenes/exit.png",botonSalirDelJuego.getWidth(),botonSalirDelJuego.getHeight(),false, true, true);
        BackgroundImage image = new BackgroundImage(salir, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(botonSalirDelJuego.getWidth(), botonSalirDelJuego.getHeight(), true, true, true, false));
        Background fondo = new Background(image);
        botonSalirDelJuego.setBackground(fondo);

    }
}
