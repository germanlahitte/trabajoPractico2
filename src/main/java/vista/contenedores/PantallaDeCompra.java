package vista.contenedores;

import controlador.ConstantesDeAplicacion;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.juego.Juego;

public class PantallaDeCompra extends VBox {

    private MenuTienda menuTienda;

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
        contenedor.setPadding(new Insets(10, 20, 10, 20));

        this.menuTienda = new MenuTienda(partida);

        contenedor.setRight(this.menuTienda);
        contenedor.setCenter(new TableroComprarView(partida.getTablero(),this.menuTienda));
        contenedor.setTop(new TurnoView(partida.getRonda()));

        this.getChildren().add(contenedor);
    }

}