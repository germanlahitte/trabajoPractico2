package vista.contenedores;

import vista.ConstantesDeAplicacion;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Escena extends Scene {
    public Escena(VBox pantalla) {
        super(pantalla, ConstantesDeAplicacion.getAnchoVentana(), ConstantesDeAplicacion.getAltoVentana());
    }
}
