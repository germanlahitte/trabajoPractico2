package vista.contenedores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.juego.Observer;
import modelo.ubicacion.Casillero;


public class CasilleroView extends Pane implements Observer {

    private Background colorFondo;
    Button boton;
    Casillero casilleroModel;
    double width, heigth;
    Background graficoPasto;
    Pane graficoCasillero;



    public CasilleroView(Casillero casillero, double tileWidth, double tileHeigth) {

        casillero.addObserver(this);
        this.casilleroModel = casillero;

        this.width=tileWidth;
        this.heigth=tileHeigth;
        this.setMinHeight(tileHeigth);
        this.setMinWidth(tileWidth);

        this.colorFondo = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/fondo-" + this.casilleroModel.getEquipo().getNombre() + ".png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));
        this.setBackground(colorFondo);

        //this.graficoCasillero = new Pane();
        this.graficoPasto = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));
        //this.setBackground(colorFondo);
        this.graficoCasillero = new Pane();
        this.graficoCasillero.setMinHeight(tileHeigth);
        this.graficoCasillero.setMinWidth(tileWidth);
        this.graficoCasillero.setBackground(this.graficoPasto);

        this.boton = new Button();
        this.boton.setMinHeight(tileHeigth);
        this.boton.setMinWidth(tileWidth);
        this.boton.setBackground(this.graficoPasto);

        this.getChildren().addAll(this.graficoCasillero, this.boton);
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
        } else {
            this.boton.setBackground(this.graficoPasto);
        }
    }
}
