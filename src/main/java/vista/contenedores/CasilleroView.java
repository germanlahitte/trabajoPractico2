package vista.contenedores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.juego.Observer;
import modelo.ubicacion.Casillero;


public class CasilleroView extends Pane implements Observer {

    Button boton;
    Casillero casilleroModel;
    double width, heigth;



    public CasilleroView(Casillero casillero, double tileWidth, double tileHeigth) {

        casillero.addObserver(this);
        this.casilleroModel = casillero;

        this.width=tileWidth;
        this.heigth=tileHeigth;
        this.setMinHeight(tileHeigth);
        this.setMinWidth(tileWidth);


        Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero-" + casillero.getEquipo().getNombre() + ".png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));

        this.setBackground(bi);
        this.boton = new Button();
        this.boton.setMinHeight(tileHeigth);
        this.boton.setMinWidth(tileWidth);
        this.boton.setBackground(bi);
        this.getChildren().add(this.boton);
    }
    public void setEvent(EventHandler<ActionEvent> evento){
        this.boton.setOnAction(evento);
    }

    @Override
    public void change() {
        if (this.casilleroModel.getPieza()!=null) {
            Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/piezas-img/" +
                    this.casilleroModel.getPieza().getNombre() + "-" +
                    this.casilleroModel.getPieza().getEquipo().getNombre() + ".png"),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(this.width, this.heigth, false, false, false, false)));
            this.boton.setBackground(bi);
        }
    }
}
