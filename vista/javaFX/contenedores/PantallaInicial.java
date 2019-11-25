package contenedores;
import botones.BotonComenzar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaInicial extends VBox{
    Stage stage;

    public PantallaInicial(Stage stage,Scene proximaEscena){
        super();
        this.stage = stage;
        this.setSpacing(20);
        Image imagen = new Image("file:vista/imagenes/algoChess2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonComenzarElJuego = new Button();
        botonComenzarElJuego.setTranslateX(700);
        botonComenzarElJuego.setTranslateY(550);
        botonComenzarElJuego.setText("Comenzar el juego");
        BotonComenzar botonComenzar = new BotonComenzar(stage,proximaEscena);
        botonComenzarElJuego.setOnAction(botonComenzar);
        this.getChildren().addAll(botonComenzarElJuego);


    }

}
