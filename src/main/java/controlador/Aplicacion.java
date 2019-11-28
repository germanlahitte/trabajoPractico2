package controlador;

import controlador.juego.Juego;
import modelo.ProveedorConstantes;
import vista.contenedores.MenuPrincipal;
import vista.contenedores.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    Stage ventana;
    Scene inicio,menu;
    Juego batalla;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ventana = stage;
        ventana.setTitle("AlgoChess");

        this.batalla = new Juego();

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana,batalla);
        this.menu = new Scene(menuPrincipal, ProveedorConstantes.getAnchoVentana(), ProveedorConstantes.getAltoVentana());

        PantallaInicial presentacion = new PantallaInicial(ventana, menu);
        this.inicio = new Scene(presentacion, ProveedorConstantes.getAnchoVentana(), ProveedorConstantes.getAltoVentana());

        ventana.setScene(inicio);
        ventana.setFullScreen(false);
        ventana.show();

    }
}
