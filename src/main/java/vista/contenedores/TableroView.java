package vista.contenedores;

import controlador.buttonHandlers.HandlerUbicarPieza;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import modelo.ubicacion.Posicion;
import vista.ConstantesDeAplicacion;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.ubicacion.Tablero;

public class TableroView extends Group {
    public double width;
    public double height;
    private double tileWidth;
    private double tileHeigth;

    private GridPane table;

    private CasilleroView[][] panes;

    private Tablero tablero;

    public TableroView(Tablero tablero){
        table = new GridPane();
        this.tablero = tablero;

        height = ConstantesDeAplicacion.getAltoVentana() - 64;
        width = height;
        tileHeigth = width / this.tablero.getLado();
        tileWidth = height / this.tablero.getLado();

        panes = new CasilleroView[(int)width][(int) height];
        Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));

        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                CasilleroView v = new CasilleroView(this.tablero.casilleroEn(new Posicion(i+1,j+1)),this.tileWidth,this.tileHeigth,bi);
                panes[i][j] = v;

                table.add(v , i, j);

            }
        }
        this.addView(table);

    }

    public Tablero getTablero() {
        return tablero;
    }

    public void prepararUbicar(Pieza pieza, Ronda ronda){
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                HandlerUbicarPieza evento = new HandlerUbicarPieza(pieza, this, ronda);
                evento.setPosicion(new Posicion(i+1,j+1));
                panes[i][j].setEvent(evento);


            }
        }
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }

    public void removerEvento() {
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                panes[i][j].setEvent(null);
            }
        }
    }
}
