package controlador;

import vista.contenedores.MenuPrincipal;
import vista.contenedores.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    Stage ventana;
    Scene inicio,menu;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ventana = stage;
        ventana.setTitle("AlgoChess");

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana);
        this.menu = new Scene(menuPrincipal,1600,1000);

        PantallaInicial presentacion = new PantallaInicial(ventana, menu);
        this.inicio = new Scene(presentacion,1600,1000);

        ventana.setScene(inicio);
        ventana.setFullScreen(false);
        ventana.show();

    }
}
