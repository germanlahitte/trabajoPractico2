package vista.contenedores;

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

    private Pane[][] panes;

    public TableroView(Tablero tablero){
        table = new GridPane();

        height = ConstantesDeAplicacion.getAltoVentana() - 64;
        width = height;
        tileHeigth = width / tablero.getLado();
        tileWidth = height / tablero.getLado();

        panes = new Pane[(int)width][(int) height];
        Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));

        for (int i = 0; i < tablero.getLado(); i++) {
            for (int j = 0; j < tablero.getLado(); j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                v.setBackground(bi);
                panes[i][j] = v;

                table.add(v , i, j);

            }
        }
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
