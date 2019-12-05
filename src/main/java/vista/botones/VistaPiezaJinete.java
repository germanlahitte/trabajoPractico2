package vista.botones;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaPiezaJinete {

    public VistaPiezaJinete(Button boton){
        boton.setStyle("-fx-background-color: transparent;");
        //Lo que sigue no está funcionando
        Image pieza = new Image("file:src/main/java/vista/imagenes/jineteAzulSaluda.png",
                boton.getWidth(),boton.getHeight(),
                false, true, true);
        BackgroundImage bImage = new BackgroundImage(pieza, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(boton.getWidth(),
                boton.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        boton.setBackground(backGround);
    }
}
