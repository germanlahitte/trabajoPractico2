package vista.contenedores;

import vista.ConstantesDeAplicacion;
import controlador.buttonHandlers.HandlerBotonJugar;
import modelo.juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import controlador.buttonHandlers.HandlerBotonSalir;

public class MenuPrincipal extends VBox {

    Stage ventana;
    AudioClip audioMenu;
    ContenedorVertical espacioV1,espacioV2;
    ContenedorHorizontal opcionesj1, opcionesJ2,espacioH;

    public MenuPrincipal (Stage ventana, Juego batalla, Scene proximaEscena) {
        super();
        this.ventana = ventana;
        this.setSpacing(60);

        Image imagen = new Image("file:src/main/java/vista/imagenes/fondoMenu.png",ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana(), false, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        /*this.audioMenu = new AudioClip(Paths.get("src/main/java/vista/audio/clashMenuOST1.wav").toUri().toString());*/
        /*si hago audioMenu.play() se reproduce desde la creación del objeto. A través de todas las escenas*/
        /*saco el archivo del paquete porque pesa mucho, lo subo al drive*/

        this.espacioV1 = new ContenedorVertical();
        this.espacioV2 = new ContenedorVertical();
        this.espacioH = new ContenedorHorizontal();
        this.opcionesj1 = new ContenedorHorizontal();
        this.opcionesJ2 = new ContenedorHorizontal();

        TextField campoJugadorRojo = new TextField();
        campoJugadorRojo.setPromptText("General Rojo");
        campoJugadorRojo.setFocusTraversable(false);
        campoJugadorRojo.setMaxWidth(400);
        TextField campoJugadorAzul = new TextField();
        campoJugadorAzul.setPromptText("General Azul");
        campoJugadorAzul.setFocusTraversable(false);
        campoJugadorAzul.setMaxWidth(400);

        //creacion de boton Jugar
        Button botonJugar = new Button();
        BotonJugarView configurarBotonJugar = new BotonJugarView();
        configurarBotonJugar.setBotonJugarView(botonJugar);

        //creacion de boton Salir
        Button botonSalirDelJuego = new Button();
        BotonSalirView configurarBotonSalir = new BotonSalirView();
        configurarBotonSalir.setBotonSalirView(botonSalirDelJuego);


        this.getChildren().addAll(botonJugar);

        this.opcionesj1.getChildren().addAll(espacioV1,campoJugadorRojo);
        this.opcionesJ2.getChildren().addAll(espacioV2,campoJugadorAzul);
        campoJugadorRojo.setAlignment(Pos.CENTER_LEFT);
        campoJugadorAzul.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(espacioH, opcionesj1, opcionesJ2);

        HandlerBotonJugar eventoJugar = new HandlerBotonJugar(this.ventana, campoJugadorRojo, campoJugadorAzul, batalla, proximaEscena);
        botonJugar.setOnAction(eventoJugar);
        HandlerBotonSalir opcionSalirHandler = new HandlerBotonSalir();
        botonSalirDelJuego.setOnAction(opcionSalirHandler);
    }

}
