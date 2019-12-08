package vista.contenedores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.juego.Observer;
import modelo.ubicacion.Casillero;
import modelo.ubicacion.Posicion;


public class CasilleroView extends Pane implements Observer {

    private Pane seleccion;
    private Background fondoColor;
    Button boton;
    Casillero casilleroModel;
    double width, heigth;
    Background fondoPasto;
    Pane graficoCasillero;



    public CasilleroView(Casillero casillero, double tileWidth, double tileHeigth) {

        casillero.addObserver(this);
        this.casilleroModel = casillero;

        this.width=tileWidth;
        this.heigth=tileHeigth;
        this.setMinHeight(tileHeigth);
        this.setMinWidth(tileWidth);

        this.fondoColor = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/fondo-" + this.casilleroModel.getEquipo().getNombre() + ".png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));
        this.setBackground(fondoColor);

        this.fondoPasto = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));
        this.graficoCasillero = new Pane();
        this.graficoCasillero.setMinHeight(tileHeigth);
        this.graficoCasillero.setMinWidth(tileWidth);
        this.graficoCasillero.setBackground(this.fondoPasto);

        this.boton = new Button();
        this.boton.setMinHeight(tileHeigth);
        this.boton.setMinWidth(tileWidth);
        this.boton.setBackground(this.fondoPasto);


        this.seleccion = new Pane();
        this.seleccion.setMinWidth(tileWidth);
        this.seleccion.setMinHeight(tileHeigth);
        Background fondoSeleccion = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/seleccion.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));
        this.seleccion.setBackground(fondoSeleccion);

        this.seleccion.setVisible(false);

        this.getChildren().addAll(this.graficoCasillero, this.seleccion, this.boton);

    }
    public void setEvent(EventHandler<ActionEvent> evento){
        this.boton.setOnAction(evento);
    }

    public void setSeleccion(){
        this.seleccion.setVisible(true);
    }

    public void hideSeleccion(){
        this.seleccion.setVisible(false);
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
            this.boton.setBackground(this.fondoPasto);
        }
    }
}
