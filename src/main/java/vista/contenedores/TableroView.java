package vista.contenedores;

import controlador.buttonHandlers.HandlerAtacar;
import controlador.buttonHandlers.HandlerElegirPieza;
import controlador.buttonHandlers.HandlerRecibirAtaque;
import controlador.buttonHandlers.HandlerUbicarPieza;
import modelo.equipos.Equipo;
import modelo.juego.Jugador;
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
        this.table = new GridPane();
        this.tablero = tablero;

        this.height = ConstantesDeAplicacion.getAltoVentana() - 64;
        this.width = height;
        this.tileHeigth = width / this.tablero.getLado();
        this.tileWidth = height / this.tablero.getLado();

        this.panes = new CasilleroView[(int)width][(int) height];

        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                CasilleroView v = new CasilleroView(this.tablero.casilleroEn(new Posicion(i+1,j+1)),this.tileWidth,this.tileHeigth);
                panes[i][j] = v;

                this.table.add(v , i, j);

            }
        }
        this.addView(this.table);

    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public void prepararUbicar(Pieza pieza, Ronda ronda){
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                HandlerUbicarPieza evento = new HandlerUbicarPieza(pieza, this, ronda);
                evento.setPosicion(this.panes[i][j].casilleroModel.getPosicion());
                this.panes[i][j].setEvent(evento);


            }
        }
    }

    public void prepararElegir(Equipo equipo, BorderPane ventana, Ronda ronda){
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Pieza pieza = this.panes[i][j].casilleroModel.getPieza();
                if (pieza != null && pieza.getEquipo()==equipo) {
                    HandlerElegirPieza evento = new HandlerElegirPieza(pieza, ventana, this, ronda);
                    this.panes[i][j].setEvent(evento);
                }

            }
        }
    }

    public void prepararAtacar(Pieza piezaAtaca, Ronda ronda, BorderPane ventana, MenuBatalla batallaView) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Pieza piezaRecibe = this.panes[i][j].casilleroModel.getPieza();
                if (piezaRecibe != null && piezaRecibe.getEquipo()!=piezaAtaca.getEquipo()) {
                    HandlerRecibirAtaque evento = new HandlerRecibirAtaque(piezaAtaca, piezaRecibe, ronda, this, ventana, batallaView);
                    this.panes[i][j].setEvent(evento);
                }

            }
        }
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void removerEvento() {
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                this.panes[i][j].setEvent(null);
            }
        }
    }
}
