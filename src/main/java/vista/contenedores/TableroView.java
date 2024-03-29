package vista.contenedores;

import controlador.buttonHandlers.*;
import javafx.scene.image.Image;
import modelo.equipos.Equipo;
import modelo.juego.Juego;
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
    private BorderPane ventana;
    public double width;
    public double height;
    private double tileWidth;
    private double tileHeigth;

    private GridPane grilla;

    private CasilleroView[][] casilleroViews;

    private PanelTurno panelTurno;
    private Tablero tablero;
    private Ronda ronda;

    public TableroView(BorderPane ventana, Juego partida, PanelTurno panelTurno){

        this.ventana = ventana;
        this.panelTurno = panelTurno;
        this.grilla = new GridPane();
        this.tablero = partida.getTablero();
        this.ronda = partida.getRonda();
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
        this.panelTurno.setDescripcion("Selecciona un casillero donde ubicar la pieza");
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
        this.panelTurno.setDescripcion("Fase de batalla: Selecciona una pieza y elige una acción");
    }

    public void prepararAtacar(Pieza piezaAtaca, String accion) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Pieza piezaRecibe = this.casilleroViews[i][j].casilleroModel.getPieza();
                if (piezaRecibe != null) {
                    HandlerRecibirAtaque evento = new HandlerRecibirAtaque(piezaAtaca, piezaRecibe, this.ronda);
                    this.casilleroViews[i][j].setEvent(evento);
                }

            }
        }
        this.panelTurno.setDescripcion(accion + "a: Elige una pieza");
    }

    public void prepararMover(Pieza piezaMueve) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Posicion posicionCasillero = this.casilleroViews[i][j].casilleroModel.getPosicion();
                Posicion posicionPieza = piezaMueve.getPosicion();
                if (this.casilleroViews[i][j].casilleroModel.getPieza() == null &&
                        posicionCasillero.distanciaA(posicionPieza) == 1) {
                    HandlerMover evento = new HandlerMover(piezaMueve, posicionCasillero, posicionPieza, this.ronda,this);
                    this.casilleroViews[i][j].setEvent(evento);
                }

            }
            this.panelTurno.setDescripcion("Mover: Selecciona un casillero donde quieres mover");
        }
    }

    public void prepararMoverBatallon(Pieza piezaMueve) {
        this.removerEvento();
        for (int i = 0; i < this.tablero.getLado(); i++) {
            for (int j = 0; j < this.tablero.getLado(); j++) {
                Posicion posicionCasillero = this.casilleroViews[i][j].casilleroModel.getPosicion();
                Posicion posicionPieza = piezaMueve.getPosicion();
                if (posicionCasillero.distanciaA(posicionPieza) == 1) {
                    HandlerMoverBatallon evento = new HandlerMoverBatallon(piezaMueve, posicionCasillero, posicionPieza, this.ronda,this);
                    this.casilleroViews[i][j].setEvent(evento);
                }

            }
            this.panelTurno.setDescripcion("Mover batallon: Selecciona un casillero donde quieres mover");
        }
    }

    public void movimiento(){
        this.ronda.movimiento();
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
        this.removerEvento();
        if (!this.ronda.puedenComprar()) {
            this.prepararElegir(this.ronda.getJugadorActual().getEquipo(), this.ventana, this.ronda);
            this.hideSeleccion();
        }
    }
}
