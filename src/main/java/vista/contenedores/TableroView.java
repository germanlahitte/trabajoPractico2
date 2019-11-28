package vista.contenedores;

import controlador.juego.Juego;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.ubicacion.Tablero;

public class TableroView extends Group {
    public double width;
    public double heigth;
    private double tileWidth = 64;
    private double tileHeigth = 64;

    private GridPane table;

    private Pane[][] panes;

    public TableroView(Tablero map){
        table = new GridPane();
        width = tileWidth * 20;
        heigth = tileHeigth * 20;
        panes = new Pane[ (int)width][(int)heigth];
        Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    Pane v = new Pane();
                    v.setMinHeight(this.tileHeigth);
                    v.setMinWidth(this.tileWidth);
                    v.setBackground(bi);
                    panes[i][j] = v;

                    table.add(v , i, j);

                }
            }
        /*
        Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/fondoMenu.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.width, this.heigth, false, false, false, false)));
        table.setBackground(bi);
        */
        this.addView(table);

    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }
}
