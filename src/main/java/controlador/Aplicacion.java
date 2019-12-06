package controlador;

import modelo.juego.Juego;
import vista.contenedores.Escena;
import vista.contenedores.MenuPrincipal;
import vista.contenedores.PantallaDeJuego;
import vista.contenedores.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    Stage ventana;
    Scene inicioView, menuView, batallaView;
    Juego partida;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventana = stage;
        this.ventana.setTitle("AlgoChess");
        this.ventana.setFullScreen(false);
        this.ventana.setResizable(false);

        this.partida = new Juego();

        PantallaDeJuego pantalla = new PantallaDeJuego(this.ventana, partida);
        this.batallaView = new Escena(pantalla);

        MenuPrincipal menuPrincipal = new MenuPrincipal(this.ventana, partida, batallaView);
        this.menuView = new Escena(menuPrincipal);

        PantallaInicial presentacion = new PantallaInicial(this.ventana, menuView);
        this.inicioView = new Escena(presentacion);

        this.ventana.setScene(inicioView);
        this.ventana.show();

    }
}
