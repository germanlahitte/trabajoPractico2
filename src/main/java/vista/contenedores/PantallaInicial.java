package vista.contenedores;

import controlador.botones.BotonAvanzar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaInicial extends VBox {

    public PantallaInicial(Stage ventana, Scene menu){
        super();
        this.setSpacing(20);

        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        Button botonComenzarElJuego = new Button();
        botonComenzarElJuego.setMaxSize(287,41);
        botonComenzarElJuego.setMinSize(287,41);
        botonComenzarElJuego.setTranslateX(1275);
        botonComenzarElJuego.setTranslateY(775);
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
