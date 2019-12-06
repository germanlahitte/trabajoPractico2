package vista.contenedores;

import controlador.buttonHandlers.*;
import javafx.scene.image.Image;
import modelo.equipos.Equipo;
import modelo.juego.Observer;
import modelo.juego.Ronda;
import modelo.piezas.Pieza;
import modelo.ubicacion.Posicion;
import vista.ConstantesDeAplicacion;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import modelo.ubicacion.Tablero;

public class TableroView extends Group implements Observer {
    public double width;
    public double height;
    private double tileWidth;
    private double tileHeigth;

    private GridPane grilla;

    private CasilleroView[][] casilleroViews;

    private Tablero tablero;
    private Ronda ronda;

    public TableroView(Tablero tablero, Ronda ronda){
        this.grilla = new GridPane();
        this.tablero = tablero;
        this.ronda = ronda;
        ronda.addObserver(this);

        this.height = ConstantesDeAplicacion.getAltoVentana() - 64;
        this.width = height;
        this.tileHeigth = width / this.tablero.getLado();
        this.tileWidth = height / this.tablero.getLado();

        this.casilleroViews = new CasilleroView[(int)this.width][(int)this.height];

        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                CasilleroView v = new CasilleroView(this.tablero.casilleroEn(new Posicion(i+1,j+1)),this.tileWidth,this.tileHeigth);
                this.casilleroViews[i][j] = v;

                this.grilla.add(v , i, j);

            }
        }
        this.addView(this.grilla);

    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public void setSeleccion(Posicion posicion){
        this.hideSeleccion();
        this.casilleroViews[posicion.getHorizontal() - 1][posicion.getVertical() - 1].setSeleccion();
    }

    public void hideSeleccion(){
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                this.casilleroViews[i][j].hideSeleccion();
            }
        }
    }

    public void prepararUbicar(Pieza pieza, Ronda ronda){
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                HandlerUbicarPieza evento = new HandlerUbicarPieza(pieza, this, ronda);
                evento.setPosicion(this.casilleroViews[i][j].casilleroModel.getPosicion());
                this.casilleroViews[i][j].setEvent(evento);


            }
        }
    }

    public void prepararElegir(Equipo equipo, BorderPane ventana, Ronda ronda){
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Pieza piezaEnCasillero = this.casilleroViews[i][j].casilleroModel.getPieza();
                if (piezaEnCasillero != null && piezaEnCasillero.getEquipo()==equipo) {
                    HandlerElegirPieza evento = new HandlerElegirPieza(piezaEnCasillero, ventana, this, ronda);
                    this.casilleroViews[i][j].setEvent(evento);
                }

            }
        }
    }

    public void prepararAtacar(Pieza piezaAtaca, Ronda ronda, BorderPane ventana, PanelBatalla batallaView) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Pieza piezaRecibe = this.casilleroViews[i][j].casilleroModel.getPieza();
                if (piezaRecibe != null) {
                    HandlerRecibirAtaque evento = new HandlerRecibirAtaque(piezaAtaca, piezaRecibe, ronda, this, ventana, batallaView);
                    this.casilleroViews[i][j].setEvent(evento);
                }

            }
        }
    }

    public void prepararMover(Pieza piezaMueve, Ronda ronda, BorderPane ventana, PanelBatalla batallaView) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Posicion posicionCasillero = this.casilleroViews[i][j].casilleroModel.getPosicion();
                Posicion posicionPieza = piezaMueve.getPosicion();
                if (this.casilleroViews[i][j].casilleroModel.getPieza() == null &&
                        posicionCasillero.distanciaA(posicionPieza) == 1) {
                    HandlerMover evento = new HandlerMover(piezaMueve, posicionCasillero, posicionPieza, ronda, this, ventana, batallaView);
                    this.casilleroViews[i][j].setEvent(evento);
                }

            }
        }
    }

    public void prepararMoverBatallon(Pieza piezaMueve, Ronda ronda, BorderPane ventana, PanelBatalla batallaView) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Posicion posicionCasillero = this.casilleroViews[i][j].casilleroModel.getPosicion();
                Posicion posicionPieza = piezaMueve.getPosicion();
                if (this.casilleroViews[i][j].casilleroModel.getPieza() == null &&
                        posicionCasillero.distanciaA(posicionPieza) == 1) {
                    HandlerMoverBatallon evento = new HandlerMoverBatallon(piezaMueve, posicionCasillero, posicionPieza, ronda, this, ventana, batallaView);
                    this.casilleroViews[i][j].setEvent(evento);
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
                this.casilleroViews[i][j].setEvent(null);
            }
        }
    }

    @Override
    public void change() {
        this.hideSeleccion();
    }
}
