package modelo.juego;

import modelo.equipos.Equipo;
import modelo.piezas.*;

import java.util.ArrayList;

public class Jugador {
    private static int credito = 20;
    private String nombre;
    private Equipo bando;
    private Billetera billetera;
    private ArrayList<Pieza> piezas;


    public Jugador(String nombre, Equipo bando) {
        this.nombre = nombre;
        this.bando = bando;
        this.billetera = new Billetera(credito);
        this.piezas = new ArrayList<>();

    }

    public Equipo getEquipo() {
        return this.bando;
    }

    public void agregarPieza(Pieza pieza){
        piezas.add(pieza);
    }

    public void comprarSoldado()  {
        Soldado soldadoNuevo = this.billetera.comprarSoldado(this.bando);
        this.agregarPieza(soldadoNuevo);
    }

    public void comprarJinete() {
        Jinete jineteNuevo = this.billetera.comprarJinete(this.bando);
        this.agregarPieza(jineteNuevo);
    }

    public void comprarCatapulta() {
        Catapulta catapultaNueva = this.billetera.comprarCatapulta(this.bando);
        this.agregarPieza(catapultaNueva);
    }
    public void comprarCurandero() {
        Curandero curanderoNuevo = this.billetera.comprarCurandero(this.bando);
       this.agregarPieza(curanderoNuevo);
    }

    //metodo usado para test
    public int getCantidadDePiezas() {
        return this.piezas.size();
    }

    //Si un jugador se quedo sin piezas es perdedor
    public boolean esPerdedor(){
        piezas.removeIf(pieza -> pieza.vida() == 0);
        return (piezas.size() ==0);
    }

    public boolean tieneSaldo() {
       return (this.billetera.tieneSaldo());
    }

    public void comprar(Tienda tienda) {
        /*Acá pasa algo*/

        tienda.venta();
    }
}
