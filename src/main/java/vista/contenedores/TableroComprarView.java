package vista.contenedores;

import controlador.ConstantesDeAplicacion;
import controlador.botones.HandlerBotonUbicar;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.ubicacion.Posicion;
import modelo.ubicacion.Tablero;

public class TableroComprarView extends Group {
    public double width;
    public double height;
    private double tileWidth;
    private double tileHeigth;

    private GridPane table;

    private Pane[][] panes;

    public TableroComprarView(Tablero tablero, MenuTienda menuTienda){
        table = new GridPane();

        width = ConstantesDeAplicacion.getAnchoVentana() * 0.75;
        height = width;
        tileHeigth = width / tablero.getLado();
        tileWidth = height / tablero.getLado();

        panes = new Pane[(int)width][(int) height];
        Background bi = new Background(new BackgroundImage(new Image("file:src/main/java/vista/imagenes/casillero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(tileWidth, tileHeigth, false, false, false, false)));

        for (int i = 1; i <= tablero.getLado(); i++) {
            for (int j = 1; j <= (tablero.getLado()/2); j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                v.setBackground(bi);
                Button b = new Button();
                b.setStyle("-fx-background-color: Red");
                HandlerBotonUbicar clickParaUbicar = new HandlerBotonUbicar(new Posicion(i,j),tablero,menuTienda,b);
                b.setOnAction(clickParaUbicar);
                v.getChildren().add(b);
                panes[i][j] = v;

                table.add(v , i, j);

            }
        }
        for (int i = 1; i <= tablero.getLado(); i++) {
            for (int j = (tablero.getLado()/2)+1; j <= tablero.getLado(); j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                v.setBackground(bi);
                Button b = new Button();
                b.setStyle("-fx-background-color: Blue");
                HandlerBotonUbicar clickParaUbicar = new HandlerBotonUbicar(new Posicion(i,j),tablero,menuTienda,b);
                b.setOnAction(clickParaUbicar);
                v.getChildren().add(b);
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
