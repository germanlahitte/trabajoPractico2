package vista.contenedores;

import controlador.botones.BotonCrear;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.equipos.EquipoAzul;
import modelo.equipos.EquipoRojo;

import java.util.ArrayList;

public class MenuPrincipal extends VBox {
    Stage ventana;
    ContenedorVertical espacioV1,espacioV2;
    ContenedorHorizontal opcionesj1, opcionesJ2,espacioH;
    ArrayList<Jugador> jugadores;

    public MenuPrincipal (Stage ventana) {
        super();
        this.ventana = ventana;
        this.setSpacing(60);

        Image imagen = new Image("file:src/main/java/vista/imagenes/fondoMenu.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

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

        Button crearJugadorRojo = new Button();
        crearJugadorRojo.setMaxSize(200,40);
        crearJugadorRojo.setMinSize(200,40);
        Image crearRojo = new Image("file:src/main/java/vista/imagenes/crearRojo.png",crearJugadorRojo.getWidth(),crearJugadorRojo.getHeight(),false, true, true);
        BackgroundImage bkgImgRojo = new BackgroundImage(crearRojo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(crearJugadorRojo.getWidth(), crearJugadorRojo.getHeight(), true, true, true, false));
        Background bkgBotRojo = new Background(bkgImgRojo);
        crearJugadorRojo.setBackground(bkgBotRojo);
        Button crearJugadorAzul = new Button();
        crearJugadorAzul.setMaxSize(200,40);
        crearJugadorAzul.setMinSize(200,40);
        Image crearAzul = new Image("file:src/main/java/vista/imagenes/crearAzul.png",crearJugadorAzul.getWidth(),crearJugadorAzul.getHeight(),false, true, true);
        BackgroundImage bkgImgAzul = new BackgroundImage(crearAzul, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(crearJugadorAzul.getWidth(), crearJugadorAzul.getHeight(), true, true, true, false));
        Background bkgBotAzul = new Background(bkgImgAzul);
        crearJugadorAzul.setBackground(bkgBotAzul);

        this.opcionesj1.getChildren().addAll(espacioV1,campoJugadorRojo,crearJugadorRojo);
        this.opcionesJ2.getChildren().addAll(espacioV2,campoJugadorAzul,crearJugadorAzul);
        campoJugadorRojo.setAlignment(Pos.CENTER_LEFT);
        campoJugadorAzul.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(espacioH, opcionesj1, opcionesJ2);
        this.jugadores=new ArrayList<>();
        BotonCrear eventoCrearRojo = new BotonCrear(campoJugadorRojo, new EquipoRojo(),jugadores);
        BotonCrear eventoCrearAzul = new BotonCrear(campoJugadorAzul, new EquipoAzul(),jugadores);

        crearJugadorRojo.setOnAction(eventoCrearRojo);
        crearJugadorAzul.setOnAction(eventoCrearAzul);
//
//        if(jugadores.size()==2){
//            Button comprar = new Button();
//            comprar.setMaxSize(200,40);
//            comprar.setMinSize(200,40);
//            Image comprarPiezas = new Image("file:src/main/java/vista/imagenes/comprar.png",comprar.getWidth(),comprar.getHeight(),false, true, true);
//            BackgroundImage bkgImgComprar = new BackgroundImage(comprarPiezas, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(comprar.getWidth(), comprar.getHeight(), true, true, true, false));
//            Background bkgBotComprar = new Background(bkgImgComprar);
//            comprar.setBackground(bkgBotComprar);
//            this.getChildren().add(comprar);
//        }
    }
}
