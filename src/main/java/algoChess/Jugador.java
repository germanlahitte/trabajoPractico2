package algoChess;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Equipo bando;
    private Billetera billetera;
    private Tablero tablero;
    private ArrayList<Pieza> piezas;

    public Jugador(String nombre, Equipo bando, Tablero tablero) {
        this.nombre = nombre;
        this.bando = bando;
        this.billetera = new Billetera();
        this.tablero = tablero;
        this.piezas = new ArrayList<Pieza>();
    }

    public Equipo getEquipo() {
        return this.bando;
    }
    public void agregarPieza(Pieza pieza){
        piezas.add(pieza);
    }

    public void comprarSoldado() {
        Soldado soldadoNuevo = (Soldado) this.billetera.comprar(Soldado.class, this.bando);
        this.agregarPieza(soldadoNuevo);
    }

    public void comprarJinete() {
        Jinete jineteNuevo = (Jinete) this.billetera.comprar(Jinete.class, this.bando);
        this.agregarPieza(jineteNuevo);
    }

    public void comprarCatapulta(){
        Catapulta catapultaNueva = (Catapulta) this.billetera.comprar(Catapulta.class,this.bando);
        this.agregarPieza(catapultaNueva);
    }
    public void comprarCurandero(){
        Curandero curanderoNuevo = (Curandero) this.billetera.comprar(Curandero.class,this.bando);
       this.agregarPieza(curanderoNuevo);
    }

    public int getCantidadDePiezas() {
        return this.piezas.size();
    }
}
