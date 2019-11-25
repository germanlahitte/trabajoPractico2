package main;

import contenedores.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    @Override

    public void start(Stage stage) throws Exception {
        stage.setTitle("AlgoChess");

        PantallaInicial pantallaInicial = new PantallaInicial(stage);
        Scene escenaDeComienzoDelJuego = new Scene(pantallaInicial,2880,1800);
        stage.setScene(escenaDeComienzoDelJuego);
        stage.setFullScreen(true);
        stage.show();

    }
}
