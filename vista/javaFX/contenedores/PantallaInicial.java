package contenedores;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//public class PantallaInicial  extends Application {
//    @Override
//    public void start(Stage stage) throws Exception {
//        Button boton = new Button("Comenzar el juego");
//        boton.setTranslateX(700);
//        boton.setTranslateY(550);
//        boton.setMinSize(100,30);
//        Image fondo = new Image("file:vista/imagenes/fondo2.jpg");
//        ImageView fondoView = new ImageView(fondo);
//        Group root = new Group();
//        root.getChildren().addAll(fondoView);
//        root.getChildren().add(boton);
//        Scene escena = new Scene(root,2880,1800);
//        stage.setScene(escena);
//        stage.setTitle("AlgoChess");
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

public class PantallaInicial extends VBox{
    Stage stage;

    public PantallaInicial(Stage stage){
        super();
        this.stage = stage;
        this.setSpacing(20);
        Image imagen = new Image("file:vista/imagenes/fondo2.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonComenzarElJuego = new Button();
        botonComenzarElJuego.setTranslateX(700);
        botonComenzarElJuego.setTranslateY(550);
        botonComenzarElJuego.setText("Comenzar el juego");
        this.getChildren().addAll(botonComenzarElJuego);


    }

}
