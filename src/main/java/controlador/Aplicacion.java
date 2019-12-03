package controlador;

import modelo.juego.Juego;
import vista.ConstantesDeAplicacion;
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
    Juego batalla;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventana = stage;
        this.ventana.setTitle("AlgoChess");

        this.batalla = new Juego();

        PantallaDeJuego pantalla = new PantallaDeJuego(ventana, batalla);
        this.batallaView = new Escena(pantalla);

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana, batalla, batallaView);
        this.menuView = new Escena(menuPrincipal);

        PantallaInicial presentacion = new PantallaInicial(ventana, menuView);
        this.inicioView = new Escena(presentacion);

        ventana.setScene(inicioView);
        ventana.setFullScreen(true);
        ventana.setResizable(false);
        ventana.show();

    }
}
