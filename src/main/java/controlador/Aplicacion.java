package controlador;

import modelo.juego.Juego;
import vista.contenedores.MenuPrincipal;
import vista.contenedores.PantallaDeCompra;
import vista.contenedores.PantallaDeJuego;
import vista.contenedores.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application {

    Stage ventana;
    Scene inicioView, menuView,tiendaView, batallaView;
    Juego batalla;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.ventana = stage;
        this.ventana.setTitle("AlgoChess");

        this.batalla = new Juego();

        PantallaDeCompra tienda = new PantallaDeCompra(batalla);
        this.tiendaView = new Scene(tienda, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        PantallaDeJuego pantalla = new PantallaDeJuego(ventana, batalla);
        this.batallaView = new Scene(pantalla, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        MenuPrincipal menuPrincipal = new MenuPrincipal(ventana, batalla, tiendaView);
        this.menuView = new Scene(menuPrincipal, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        PantallaInicial presentacion = new PantallaInicial(ventana, menuView);
        this.inicioView = new Scene(presentacion, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());

        ventana.setScene(inicioView);
        ventana.setFullScreen(false);
        ventana.show();

    }
}
