package vista.contenedores;

import controlador.ConstantesDeAplicacion;
import controlador.botones.BotonAvanzar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaInicial extends VBox {

    static int anchoBoton = 287;
    static int altoBoton = 41;

    public PantallaInicial(Stage ventana, Scene menu){
        super();
        this.setSpacing(20);

        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png", ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana(), false, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        Button botonComenzarElJuego = new Button();
        botonComenzarElJuego.setMaxSize(anchoBoton, altoBoton);
        botonComenzarElJuego.setMinSize(anchoBoton, altoBoton);
        botonComenzarElJuego.setTranslateX(ConstantesDeAplicacion.getAnchoVentana() - anchoBoton);
        botonComenzarElJuego.setTranslateY(ConstantesDeAplicacion.getAltoVentana() - altoBoton);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/comenzar.png",botonComenzarElJuego.getWidth(),botonComenzarElJuego.getHeight(),false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(botonComenzarElJuego.getWidth(), botonComenzarElJuego.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonComenzarElJuego.setBackground(backGround);

        this.setBackground(new Background(imagenDeFondo));
        this.getChildren().addAll(botonComenzarElJuego);

        BotonAvanzar eventoClickEnComenzar = new BotonAvanzar(ventana, menu);
        botonComenzarElJuego.setOnAction(eventoClickEnComenzar/*e->{ventana.setScene(menu);ventana.show();}*/);
    }

}
