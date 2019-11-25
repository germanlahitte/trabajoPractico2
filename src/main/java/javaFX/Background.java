package javaFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Background  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button boton = new Button("Comenzar el juego");
        boton.setTranslateX(700);
        boton.setTranslateY(550);
        boton.setMinSize(100,30);
        Image fondo = new Image("file:fondo2.jpg");
        ImageView fondoView = new ImageView(fondo);
        Group root = new Group();
        root.getChildren().addAll(fondoView);
        root.getChildren().add(boton);
        Scene escena = new Scene(root,2880,1800);
        stage.setScene(escena);
        stage.setTitle("AlgoChess");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
