package vista.contenedores;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuPrincipal extends VBox {
    Stage ventana;

    public MenuPrincipal (Stage ventana) {
        super();
        this.ventana = ventana;
        this.setSpacing(20);

        Image imagen = new Image("file:src/main/java/vista/imagenes/fondoMenu.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
}
