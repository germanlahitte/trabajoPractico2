package controlador;

import controlador.juego.Juego;
import modelo.ProveedorConstantes;
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
        this.batallaView = new Scene(pantalla, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana, batalla, batallaView);
        this.menuView = new Scene(menuPrincipal, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        PantallaInicial presentacion = new PantallaInicial(ventana, menuView);
        this.inicioView = new Scene(presentacion, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        ventana.setScene(inicioView);
        ventana.setFullScreen(false);
        ventana.show();

    }
}
