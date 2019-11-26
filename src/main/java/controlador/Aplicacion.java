package controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import vista.contenedores.MenuPrincipal;
import vista.contenedores.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("AlgoChess");
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        Scene escenaDeMenu = new Scene(menuPrincipal,1600,1000);
        PantallaInicial pantallaInicial = new PantallaInicial(stage,escenaDeMenu);
        Scene escenaDeComienzoDelJuego = new Scene(pantallaInicial,1600,1000);
        stage.setScene(escenaDeComienzoDelJuego);
        stage.setFullScreen(false);
        stage.show();

    }
}
