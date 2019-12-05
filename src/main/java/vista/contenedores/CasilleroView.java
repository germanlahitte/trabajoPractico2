package vista.contenedores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;


public class CasilleroView extends Pane {

    Button boton;

    public CasilleroView(double tileWidth, double tileHeigth, Background bi) {
        this.boton = new Button();
        this.boton.setMinHeight(tileHeigth);
        this.boton.setMinWidth(tileWidth);
        this.boton.setBackground(bi);
        this.getChildren().add(this.boton);
    }
    public void setEvent(EventHandler<ActionEvent> evento){
        this.boton.setOnAction(evento);
    }
}
