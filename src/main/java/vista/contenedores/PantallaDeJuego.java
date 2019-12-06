package vista.contenedores;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import modelo.juego.Juego;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.ubicacion.Tablero;
import vista.ConstantesDeAplicacion;


public class PantallaDeJuego extends VBox {
    private Juego partida;
    private Tablero tablero;
    private TableroView vistaTablero;
    private MenuTienda menuTienda;
    private PanelTurno panelTurno;

    public PantallaDeJuego(Stage ventana, Juego partida) {
        super();
        BorderPane border = new BorderPane();
        border.setPadding(new Insets(10, 10, 10, 10));
        Image imagen = new Image("file:src/main/java/vista/imagenes/algoChessV3.png", ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana(), false, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.partida = partida;

        this.tablero = this.partida.getTablero();
        this.panelTurno = new PanelTurno(this.partida.getRonda(), ventana);

        this.vistaTablero = new TableroView(border, this.partida, this.panelTurno);
        this.menuTienda = new MenuTienda(this.partida.getRonda(), this.vistaTablero);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER_LEFT);

        border.setTop(panelTurno);
        border.setLeft(vbox);
        border.setCenter(vistaTablero);
        border.setRight(menuTienda);

        this.getChildren().add(border);

    }

    public void setEscenaFinal(Scene escenaFinal) {
        this.panelTurno.setEscenaFinal(escenaFinal);
    }
}
