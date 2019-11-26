package vista.contenedores;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    MenuPrincipal contenedorCentral;

    public ContenedorPrincipal(Stage escenario){
        this.setMenu(escenario);
    }

    private void setMenu(Stage escenario) {
        this.menuBar = new BarraDeMenu(escenario);
        this.setTop(menuBar);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
}
