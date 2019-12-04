package vista.contenedores;

import controlador.ConstantesDeAplicacion;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.juego.Juego;
import modelo.juego.Ronda;

public class PantallaDeCompra extends VBox {

    public PantallaDeCompra(Juego partida){
        super();
        Image imagen = new Image("file:src/main/java/vista/imagenes/fondoTabla.png",
                                    ConstantesDeAplicacion.getAnchoVentana(),
                                    ConstantesDeAplicacion.getAltoVentana(), false, true, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,
                                                                    BackgroundRepeat.NO_REPEAT,
                                                                    BackgroundPosition.CENTER,
                                                                    BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        BorderPane contenedor = new BorderPane();
        contenedor.setRight(new MenuTienda(partida.getRonda()));
        contenedor.setPadding(new Insets(10, 20, 10, 20));

        contenedor.setCenter(new TableroView(partida.getTablero()));

        this.getChildren().add(contenedor);
    }

}
