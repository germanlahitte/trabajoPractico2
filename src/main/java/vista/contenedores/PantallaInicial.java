package vista.contenedores;
import controlador.botones.BotonComenzar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaInicial extends VBox {
    Stage stage;

    public PantallaInicial(Stage stage,Scene proximaEscena){
        super();
        this.stage = stage;
        this.setSpacing(20);
        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonComenzarElJuego = new Button();
        botonComenzarElJuego.setMaxSize(287,41);
        botonComenzarElJuego.setMinSize(287,41);
        botonComenzarElJuego.setTranslateX(1275);
        botonComenzarElJuego.setTranslateY(775);
        Image comenzar = new Image("file:src/main/java/vista/imagenes/comenzar.png",botonComenzarElJuego.getWidth(),botonComenzarElJuego.getHeight(),false, true, true);
        BackgroundImage bImage = new BackgroundImage(comenzar, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(botonComenzarElJuego.getWidth(), botonComenzarElJuego.getHeight(), true, true, true, false));
        Background backGround = new Background(bImage);
        botonComenzarElJuego.setBackground(backGround);

        BotonComenzar botonComenzar = new BotonComenzar(stage,proximaEscena);
        botonComenzarElJuego.setOnAction(botonComenzar);
        this.getChildren().addAll(botonComenzarElJuego);


    }

}
